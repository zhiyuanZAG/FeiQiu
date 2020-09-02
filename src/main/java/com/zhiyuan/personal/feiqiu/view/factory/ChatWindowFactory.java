package com.zhiyuan.personal.feiqiu.view.factory;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.registrar.ChatWindowRegistrar;
import com.zhiyuan.personal.feiqiu.utils.SpringContextUtil;
import com.zhiyuan.personal.feiqiu.utils.WinPostionUtils;
import com.zhiyuan.personal.feiqiu.view.ChatWindow;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈聊天窗口的创建工厂: 用于创建聊天窗口(非单例工厂)<br>
 * 定义窗口的CLientUser对象 + 窗口的尺寸+ 窗口的背景色〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/27 15:47
 * @since 1.0
 */
public class ChatWindowFactory{

    //新建的聊天窗口的宽和高
    private static Integer WINDOW_WIDTH = 900;
    private static Integer WINDOW_HEIGHT = 700;

    //当前客户端打开的聊天窗口个数
    private static Integer WINDOW_COUNT = 0;

    //窗口注册管理器
    private static ChatWindowRegistrar windowRegistrar;

    //初始化工厂对象中的注册器属性
    static {
        windowRegistrar = SpringContextUtil.getBean(ChatWindowRegistrar.class);
    }

    /**
     * 功能描述: <br>
     * 〈创建并展示聊天窗口〉
     *
     * @return void
     * @author zhiyuan.zhang01
     * @param: [user]
     * @created 2020/9/1 15:47
     */
    public static void createAndShowChatWindow(FriendUser user) {
        ChatWindow chatWindow = new ChatWindow();
        chatWindow.setUser(user);
        chatWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);    //设置聊天窗口默认大小
        //获取当前窗口位置
        Map<String, Integer> postionMap = WinPostionUtils.getPostionByIndex(WINDOW_COUNT);
        Integer postionX = postionMap.get("postionX");
        Integer postionY = postionMap.get("postionY");
        chatWindow.createWindow(postionX, postionY);    //创建聊天窗口的内容
        /**
         * 挂载窗口事件监听器:
         * 1. 当窗口打开是, 将窗口注册到注册器中
         * 2. 当窗口关闭时, 从窗口注册器中删除
         */
        chatWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {   //窗口打开事件
                super.windowOpened(e);
                windowRegistrar.registrar(chatWindow);
                WINDOW_COUNT++;
            }

            @Override
            public void windowClosing(WindowEvent e) { //窗口关闭事件
                super.windowClosing(e);
                windowRegistrar.remove(chatWindow);
                WINDOW_COUNT--;
            }
        });
        chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭窗口时退出当前进程
        chatWindow.setVisible(true);
    }


}
