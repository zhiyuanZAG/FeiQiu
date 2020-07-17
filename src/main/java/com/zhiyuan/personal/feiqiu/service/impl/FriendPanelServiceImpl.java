package com.zhiyuan.personal.feiqiu.service.impl;

import com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.dto.factory.LocalClientUserFacotry;
import com.zhiyuan.personal.feiqiu.service.FriendPanelService;
import com.zhiyuan.personal.feiqiu.socket.LanSendService;
import com.zhiyuan.personal.feiqiu.view.factory.FriendDefaultListModelFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈朋友列表面板相关服务实现类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/16 16:22
 * @since 1.0
 */
@Service
@Slf4j
public class FriendPanelServiceImpl implements FriendPanelService {

    @Autowired
    private UdpServiceImpl udpService;

    @Override
    public void addFriendList(ClientUser user) {

    }

    @Override
    public boolean maintainFriendList(UdpMsgTypeEnum typeEnum, ClientUser user, String msg) {
        boolean flag = false;
        try {
            routerMaintain(typeEnum, user);
            flag = true;
        } catch (Exception e) {
            log.error("处理udp消息异常, e->{}", e.getMessage());
        }
        return flag;
    }

    /**
     * 功能描述: <br>
     * 〈通过udp的类型, 处理〉
     *
     * @author zhiyuan.zhang01
     * @param: [typeEnum, user]
     * @return void
     * @created 2020/7/17 15:00
    */
    private void routerMaintain(UdpMsgTypeEnum typeEnum, ClientUser user) {
        //查询已存放的list内容
        DefaultListModel model = FriendDefaultListModelFactory.getListModelInstance();
        boolean flag = model.contains(user);
        switch (typeEnum) {
            case ONLINE:    //主动上线
                log.info("用户{}已上线", user.getHostIP());
                if (flag) { //该用户已保存
                    return;
                }
                // 1. 将新上线用户添加到列表
                model.add(0, user);
                // 2. 广播本机在线
                udpService.sendMsg(UdpMsgTypeEnum.STAYED, LocalClientUserFacotry.getLocalClientInstance(), null);
                break;
            case STAYED:    //保持在线
                log.info("用户{}保持在线", user.getHostIP());
                if (flag) {
                    return;
                }
                model.add(0, user);
                break;
            case OFFLINE:   //主动下线
                log.info("用户{}下线", user.getHostIP());
                if (flag) {
                    model.removeElement(user);
                }
                break;
        }
    }
}
