package com.zhiyuan.personal.feiqiu.view.factory;

import com.zhiyuan.personal.feiqiu.renderer.FriendListCellRenderer;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈启动面板, 好友列表面板〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 19:04
 * @since 1.0.0
 */
@Data
@Builder
public class JFriendPanelFactory{

    private static Font FONT = new Font("楷体", Font.BOLD, 20);

    //宽度
    private static Integer WEIGHT = 280;

    //高度
    private static Integer HEIGHT = 650;

    //列表宽度
    private static Integer LIST_WEIGHT = 260;

    //列表高度
    private static Integer LIST_HEIGHT = 640;


    /**
     * 功能描述: <br>
     * 〈创建一个JFriendPanel〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return com.zhiyuan.personal.feiqiu.view.factory.JFriendPanelFactory
     * @created 2020/6/17 17:18
     */
    public static JPanel createFriendPanel() {
        JPanel jp = new JPanel();
        jp.setBackground(Color.white);

        //可变好友列表
        DefaultListModel model = FriendDefaultListModelFactory.getListModelInstance();
        //构建Jlist
        JList friendList =  new JList(model);
        //应用自定义单元渲染器
        friendList.setCellRenderer(new FriendListCellRenderer());
        //定义好友列表的字体及格式
        friendList.setFont(FONT);
        friendList.setPreferredSize(new Dimension(LIST_WEIGHT, LIST_HEIGHT));
        friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //定义可滚动pane
        JScrollPane jsp = new JScrollPane(friendList);
        jsp.setPreferredSize(new Dimension(WEIGHT, HEIGHT));

        //滚动pane 添加到jpanel上
        jp.add(jsp);
        return jp;
    }


}
