package com.zhiyuan.personal.feiqiu.service.impl;

import com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.service.UdpService;
import com.zhiyuan.personal.feiqiu.socket.LanSendService;
import com.zhiyuan.personal.feiqiu.utils.UdpMsgStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈发送和接收udp广播的服务实现类
 *      定义UDP发送协议:<br>
 *            在线状态:主机IP:name:iconName:msg〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/15 17:13
 * @since 1.0
 */
@Service
public class UdpServiceImpl implements UdpService {

    @Autowired
    private LanSendService lanSendService;

    @Override
    public void sendMsg(UdpMsgTypeEnum typeEnum, ClientUser user, String msg) {
        //构建待发送的消息体
        String sendMsg = UdpMsgStringUtils.builderUdpMsg(typeEnum, user, msg);
        //调用udp相关方法, 组播发送消息体
        lanSendService.udpMsgSend(sendMsg);
    }

    @Override
    public void receiveMsg(String msg) {

    }
}
