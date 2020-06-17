package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.model.FriendListModel;
import com.zhiyuan.personal.feiqiu.renderer.FriendListCellRenderer;
import com.zhiyuan.personal.feiqiu.view.factory.FriendDefaultListModelFactory;
import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

    private static Font FONT = new Font("楷体", Font.BOLD, 18);

    //宽度
    private static Integer WEIGHT = 290;

    //高度
    private static Integer HEIGHT = 670;


    /**
     * 功能描述: <br>
     * 〈创建一个JFriendPanel〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return com.zhiyuan.personal.feiqiu.view.JFriendPanelFactory
     * @created 2020/6/17 17:18
     */
    public static JPanel createFriendPanel() {
        JPanel jp = new JPanel();
        jp.setBackground(Color.white);

        //好友列表
        DefaultListModel model = FriendDefaultListModelFactory.getListModelInstance();
        JList friendList =  new JList(model);
        friendList.setCellRenderer(new FriendListCellRenderer());
        friendList.setFont(FONT);
        friendList.setPreferredSize(new Dimension(WEIGHT, HEIGHT));
        friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsp = new JScrollPane(friendList);
        jsp.setPreferredSize(new Dimension(WEIGHT, HEIGHT));

        //添加滚动pane
        jp.add(jsp);
        return jp;
    }


}
