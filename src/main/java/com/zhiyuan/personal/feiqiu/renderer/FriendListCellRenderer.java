package com.zhiyuan.personal.feiqiu.renderer;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;

import javax.swing.*;
import java.awt.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈好友列表单元渲染器〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/17 16:26
 * @since 1.0.0
 */
public class FriendListCellRenderer  extends JLabel implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        FriendUser user = (FriendUser)value;

        /**
         * 设置jLable的文字
         *      用户IP
         *      用户名
         */
        String text = "<html>" + user.getHostIP() + "<br/>" + user.getName() + "<html/>";
        setText(text);
        return this;
    }
}
