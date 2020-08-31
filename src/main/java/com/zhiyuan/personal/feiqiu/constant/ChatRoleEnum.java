package com.zhiyuan.personal.feiqiu.constant;

/**
 * 〈一句话功能简述〉<br>
 * 〈聊天中的对象枚举: 本人/其他人〉
 *
 * @author zhiyuanzhang9
 * @create 2020/8/31 15:12
 * @since 1.0
 */
public enum ChatRoleEnum {

    SELF("self", "本人"),
    OTHER("other", "其他人"),
    ;

    public String code;
    public String desc;

    ChatRoleEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
