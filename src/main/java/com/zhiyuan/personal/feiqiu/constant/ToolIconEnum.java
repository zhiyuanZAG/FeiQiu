package com.zhiyuan.personal.feiqiu.constant;

import java.util.Arrays;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 * 〈工具icon的枚举〉
 *
 * @author zhiyuanzhang9
 * @create 2020/8/6 18:30
 * @since 1.0
 */
public enum ToolIconEnum {

    UNKNOWN("unknown", "未知图标"),
    SEND_FILE("sendFile", "发送文件"),
    ;


    public String name;
    public String desc;

    ToolIconEnum(String code, String desc) {
        this.name = code;
        this.desc = desc;
    }

    /**
     * 功能描述: <br>
     * 〈根据name, 获取工具枚举〉
     *
     * @return com.zhiyuan.personal.feiqiu.constant.ToolIconEnum
     * @author zhiyuan.zhang01
     * @param: [name]
     * @created 2020/8/6 18:32
     */
    public static ToolIconEnum getByName(String name) {
        return Arrays.stream(ToolIconEnum.values()).filter(o -> o.name.equals(name)).findFirst().orElse(UNKNOWN);
    }
}
