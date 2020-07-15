package com.zhiyuan.personal.feiqiu.service.impl;

import com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.service.UdpService;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈发送和接收udp广播的服务实现类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/15 17:13
 * @since 1.0
 */
@Service
public class UdpServiceImpl implements UdpService {

    @Override
    public void sendMsg(UdpMsgTypeEnum typeEnum, ClientUser user, String msg) {

    }

    @Override
    public void receiveMsg(String msg) {

    }
}
