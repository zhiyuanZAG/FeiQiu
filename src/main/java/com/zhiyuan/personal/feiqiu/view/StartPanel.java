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

    //个人信息面板
    private JNamePanel namePanel;

    //好友列表面板
    private JFriendPanel friendPanel;

    //下方工具栏面板
    private JToolPanel toolPanel;


    /**
     * 功能描述: <br>
     * 〈创建〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return void
     * @created 2020/6/16 19:14
     */
    public void createStartPanel (){
        JFrame frame = new JFrame("feiQiu");
        frame.setBounds(1300, 15, 300, 750);
        frame.setLayout(new BorderLayout());
        frame.add(namePanel, BorderLayout.NORTH);
        frame.add(friendPanel, BorderLayout.CENTER);
        frame.add(toolPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        StartPanel panel = new StartPanel();
        panel.namePanel = new JNamePanel();
        panel.friendPanel = new JFriendPanel();
        panel.toolPanel = new JToolPanel();
        panel.createStartPanel();
    }
}
