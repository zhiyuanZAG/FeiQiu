package com.zhiyuan.personal.feiqiu.utils;

import com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;

/**
 * 〈一句话功能简述〉<br>
 * 〈构建udp消息的工具类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/15 17:15
 * @since 1.0
 */
public class UdpMsgStringUtils {

    public static final String SEPERATOR = ":";


    /**
     * 功能描述: <br>
     * 〈构建UDP消息Strign〉
     *
     * @return java.lang.String
     * @author zhiyuan.zhang01
     * @param: [typeEnum, user, msg]
     * @created 2020/7/15 17:16
     */
    public static String builderUdpMsg(UdpMsgTypeEnum typeEnum, ClientUser user, String msg) {
        return typeEnum.getIndex() + SEPERATOR + user.getHostIP() + SEPERATOR + user.getName() + SEPERATOR + user.getIconName() + SEPERATOR + msg;
    }

    /**
     * 功能描述: <br>
     * 〈解析接收到的udp消息〉
     *
     * @author zhiyuan.zhang01
     * @param: [msg]
     * @return java.lang.String[]
     * @created 2020/7/16 18:16
    */
    public static String[] encodeUdpMsg(String msg) {
        return msg.split(SEPERATOR);
    }
}
