package com.zhiyuan.personal.feiqiu.service;

import com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;

/**
 * 〈一句话功能简述〉<br>
 * 〈发送和接收udp广播的服务接口〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/10 14:59
 * @since 1.0
 */
public interface UdpService {


    /**
     * 功能描述: <br>
     * 〈发送udp广播消息〉
     *
     * @author zhiyuan.zhang01
     * @param: [msg]
     * @return void
     * @created 2020/7/10 15:01
    */
    public void sendMsg(ClientUser user, UdpMsgTypeEnum typeEnum);

    /**
     * 功能描述: <br>
     * 〈接收udp广播消息〉
     *
     * @author zhiyuan.zhang01
     * @param: [msg]
     * @return void
     * @created 2020/7/10 15:01
    */
    public void receiveMsg(String msg);
}
