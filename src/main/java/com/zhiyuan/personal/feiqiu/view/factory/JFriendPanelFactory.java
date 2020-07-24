package com.zhiyuan.personal.feiqiu.view.factory;

import com.alibaba.fastjson.JSONObject;
import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.renderer.FriendListCellRenderer;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
@Slf4j
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
        friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //列表内容只可单选
        //注册选项监视器
        friendList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                FriendUser user = (FriendUser) friendList.getSelectedValue();
                log.info("已选择的好友项为: {}", JSONObject.toJSONString(user));
            }
        });
        //注册动作事件监视器
        friendList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //响应双击实现
                if (e.getClickCount() == 2) {
                    FriendUser user = (FriendUser) friendList.getSelectedValue();
                    log.info("双击选择的好友项为: {}", JSONObject.toJSONString(user));
                    //提交线程池, 展示聊天窗口
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //定义可滚动pane
        JScrollPane jsp = new JScrollPane(friendList);
        jsp.setPreferredSize(new Dimension(WEIGHT, HEIGHT));

        //滚动pane 添加到jpanel上
        jp.add(jsp);
        return jp;
    }


}
