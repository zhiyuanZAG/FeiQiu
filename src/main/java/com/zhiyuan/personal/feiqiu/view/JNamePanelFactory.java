package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.view.factory.LocalClientUserFacotry;
import lombok.*;

import javax.swing.*;
import java.awt.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 19:02
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
public class JNamePanelFactory {

    //宽度
    private static Integer WEIGHT = 290;

    //高度
    private static Integer HEIGHT = 60;

    //字体
    private static Font FONT = new Font("楷体", Font.BOLD, 40);


    /**
     * 功能描述: <br>
     * 〈创建当前用户panel〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.JPanel
     * @created 2020/6/17 19:00
     */
    public static JPanel createNamePanel(){
        JPanel jp = new JPanel();
        jp.setSize(WEIGHT, HEIGHT);
        jp.setBackground(Color.PINK);
        ClientUser localClient = LocalClientUserFacotry.getLocalClientInstance();
        //// TODO: 2020/6/17 需要展示真是用户IP信息
        JLabel label = label = new JLabel("hostIP");
//        JLabel label = label = new JLabel(localClient.getHostIP());

        label.setFont(FONT);
        jp.add(label);
        return jp;
    }
}
