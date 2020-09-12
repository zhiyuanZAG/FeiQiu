package com.zhiyuan.personal.feiqiu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/9/11 16:47
 * @since 1.0
 */
@Data
public class FriendMsgMenuItem extends JMenuItem {

    //当前聊天对象的聊天消息实体
    private ChatMsgDto chatMsg;

    //构造器
    public FriendMsgMenuItem(String text, Icon icon) {
        super(text, icon);
    }
}
