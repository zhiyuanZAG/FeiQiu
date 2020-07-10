package com.zhiyuan.personal.feiqiu.constant;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈udp消息的发送类型〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/10 15:23
 * @since 1.0
 */
public enum UdpMsgTypeEnum {
    ONLINE("online", "主动上线"),
    STAYED("stayed", "保持在线"),
    OFFLINE("offline", "主动下线"),
    ;

    private String index;
    private String name;

    UdpMsgTypeEnum(String index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 功能描述: <br>
     * 〈根据index获取对应的枚举值〉
     *
     * @author zhiyuan.zhang01
     * @param: [index]
     * @return com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum
     * @created 2020/7/10 15:33
    */
    public static UdpMsgTypeEnum getByIndex(String index) {
        return Arrays.stream(UdpMsgTypeEnum.values()).filter(e -> e.getIndex().equals(index)).findFirst().orElse(null);
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
