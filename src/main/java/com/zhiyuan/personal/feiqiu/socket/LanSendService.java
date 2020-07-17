package com.zhiyuan.personal.feiqiu.socket;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈网络发送行为:
 *      udp: 组播的方式发送和接收〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/19 18:34
 * @since 1.0.0
 */
public interface LanSendService {

    /**
     * 功能描述: <br>
     * 〈发送udp消息体〉
     *
     * @author zhiyuan.zhang01
     * @param: [msg]
     * @return boolean
     * @created 2020/7/16 11:14
    */
    boolean udpMsgSend(String msg);

    /**
     * 功能描述: <br>
     * 〈接收udp消息体〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return java.lang.String
     * @created 2020/7/16 11:15
    */
    String udpMsgReceive();

}
