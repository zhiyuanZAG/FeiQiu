package com.zhiyuan.personal.feiqiu.renderer;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import org.springframework.util.ResourceUtils;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

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

        /**
         * 设置jLable的文字
         *      用户IP
         *      用户名
         */
        String text = "<html> hostIP: " + user.getHostIP() + "<br/> hostName: " + user.getName() + "<html/>";

        //显示用户头像
        ImageIcon temp = null;
        if (null == user.getIconName()) {
            temp = IconUtils.getIconByName(IconUtils.randomGenerateIcon());
        } else {
            temp = IconUtils.getIconByName(user.getIconName());
        }
        setIcon(new ImageIcon(temp.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

        //设置头像与用户名的间隔.
        setIconTextGap(25);

        setText(text);
        return this;
    }
}
