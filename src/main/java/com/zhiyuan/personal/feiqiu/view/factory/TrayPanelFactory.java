package com.zhiyuan.personal.feiqiu.view.factory;

import com.zhiyuan.personal.feiqiu.dto.FriendMsgMenuItem;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import com.zhiyuan.personal.feiqiu.view.TrayPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 〈一句话功能简述〉<br>
 * 〈系统托盘的工厂〉
 *
 * @author zhiyuanzhang9
 * @create 2020/9/11 17:49
 * @since 1.0
 */
@Repository
public class TrayPanelFactory {

    @Autowired
    private TrayPanel trayPanel;

    /**
     * 功能描述: <br>
     * 〈初始化系统托盘〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return void
     * @created 2020/9/11 17:53
    */
    public void initTrayPanel() {

        //获取当前的系统托盘
        SystemTray systemTray = SystemTray.getSystemTray();
        //自定义弹出菜单
        JPopupMenu pm = new JPopupMenu();
        //为弹出菜单自定义UI
        trayPanel.getChatMsgDtoList().stream().forEach(dto -> {
            //1. 创建一个弹出菜单项
            //单个菜单样式: "好友名    消息条数"
            JMenuItem chatItem = new FriendMsgMenuItem(dto.getFriendUser().getName() +"    "+ dto.getMsgDtos().size(), IconUtils.getIconByName(dto.getFriendUser().getIconName()));
            //2. 将该项添加到弹出菜单
            trayPanel.getPm().add(chatItem);
            //3. 给该项添加双击事件(双击后打开聊天窗口; 窗口打开后, 需要将该聊天从托盘面盘中删除)
            chatItem.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //单击或双击
                    if (e.getClickCount() == 1 || e.getClickCount() == 2) {
                        //1. 弹出该好友的对话框
                        ChatWindowFactory.createAndShowChatWindow(dto.getFriendUser());
                        //2. 系统托盘消失
                        trayPanel.setVisible(false);
                        //3. 从系统托盘中删除该对话对象
                        trayPanel.getChatMsgDtoList().remove(dto);
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
        });

        //创建带有指定图像, 工具提示, 和弹出菜单的TrayIcon
        //给TrayIcon添加鼠标监听器(移动到托盘上, 展示未读消息列表; 左键单击对应的消息栏, 弹出聊天窗口并从托盘中移除该消息框)
        //将trayIcon添加到系统托盘

    }
}
