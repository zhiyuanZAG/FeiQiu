package com.zhiyuan.personal.feiqiu.renderer;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义用户名面板渲染器〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/17 17:40
 * @since 1.0
 */
public class NamePanelCellRender extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        //用户信息
        ClientUser user = (ClientUser) value;

        //展示信息格式
        String text = "<html> <p style=\"line-height:5; font-size:12px;\"> IP: " + user.getHostIP() + "<br/> Name: " + user.getName() + "</p> <html/>";

        //显示用户头像
        ImageIcon temp = null;
        if (null == user.getIconName()) {
            temp = IconUtils.getIconByName(IconUtils.randomGenerateIcon());
        } else {
            temp = IconUtils.getIconByName(user.getIconName());
        }
        setIcon(new ImageIcon(temp.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

        //设置头像与用户名的间隔.
        setIconTextGap(35);

        System.out.println(text);
        setText(text);
        return this;
    }
}
