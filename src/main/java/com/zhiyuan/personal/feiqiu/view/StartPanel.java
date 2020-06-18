package com.zhiyuan.personal.feiqiu.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈应用打开后, 展示的好友列表页〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 16:13
 * @since 1.0.0
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartPanel {

    //x轴绝对位置
    private static Integer POSITION_X = 1300;
    //y轴绝对位置
    private static Integer POSITION_Y = 15;
    //面板宽度
    private static Integer WIDTH = 300;
    //面板高度
    private static Integer HEIGHT = 760;
    //V方向组件间间隔(像素)
    private static Integer VGAP = 2;
    //H方向组件间间隔(像素)
    private static Integer HGAP = 3;

    //个人信息面板
    private JPanel namePanel;

    //好友列表面板
    private JPanel friendPanel;

    //下方工具栏面板
    private JToolPanel toolPanel;


    /**
     * 功能描述: <br>
     * 〈展示开始面板〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return void
     * @created 2020/6/16 19:14
     */
    public void showStartPanel(){
        JFrame frame = new JFrame("feiQiu");
        frame.setBounds(POSITION_X, POSITION_Y, WIDTH, HEIGHT);
        frame.setLayout(new BorderLayout(HGAP, VGAP));
        frame.add(namePanel, BorderLayout.NORTH);
        frame.add(friendPanel, BorderLayout.CENTER);
        frame.add(toolPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
