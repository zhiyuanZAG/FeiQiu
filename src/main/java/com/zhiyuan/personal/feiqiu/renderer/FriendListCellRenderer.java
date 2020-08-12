package com.zhiyuan.personal.feiqiu.renderer;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import org.springframework.util.ResourceUtils;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 * 〈好友列表单元渲染器〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/17 16:26
 * @since 1.0.0
 */
public class FriendListCellRenderer extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        FriendUser user = (FriendUser) value;

        //被选中后变色
        if (isSelected) {
            setBackground(Color.PINK);
        }

        /**
         * 设置jLable的文字
         *      hostIP
         *      hostName
         */
        String text = "<html> <p style=\"line-height:5; font-size:10px;\"> hostIP: " + user.getHostIP() + "<br/> hostName: " + user.getName() + "<html/>";

        //显示用户头像
        user.setIconName(Optional.ofNullable(user.getIconName()).orElse(IconUtils.randomGenerateIcon()));
        setIcon(IconUtils.getSizedIconByName(user.getIconName(), 40, 40));

        //设置头像与用户名的间隔 25px
        setIconTextGap(25);

        setText(text);
        return this;
    }
}
