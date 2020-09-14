package com.zhiyuan.personal.feiqiu.view.factory;

import com.zhiyuan.personal.feiqiu.dto.ChatMsgDto;
import com.zhiyuan.personal.feiqiu.dto.FriendMsgMenuItem;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import com.zhiyuan.personal.feiqiu.view.TrayPanel;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    private static TrayPanel trayPanel;


    private TrayPanelFactory() {
    }

    private static TrayPanel getTrayPanel() {
        return trayPanel;
    }

    private static void setTrayPanel(TrayPanel trayPanel) {
        TrayPanelFactory.trayPanel = trayPanel;
    }

    /**
     * 功能描述: <br>
     * 〈实例化 唯一的系统托盘对象〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return com.zhiyuan.personal.feiqiu.view.TrayPanel
     * @created 2020/9/14 17:41
    */
    public static TrayPanel getTrayPanelInst() {
        if (null == trayPanel) {
            synchronized (TrayPanelFactory.class) {
                if (null == trayPanel) {
                    //初始化实例
                    String iconName = "softIcon.png";
                    JPopupMenu popupMenu = new JPopupMenu();
                    //创建带有指定图像, 和弹出菜单的TrayIcon
                    trayPanel = new TrayPanel(iconName, popupMenu);
                }
            }
        }
        return trayPanel;
    }

    /**
     * 功能描述: <br>
     * 〈初始化系统托盘〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return void
     * @created 2020/9/11 17:53
    */
    public static void initTrayPanel() throws java.awt.AWTException{

        //获取当前的系统托盘
        SystemTray systemTray = SystemTray.getSystemTray();
        TrayPanel trayPanel = getTrayPanelInst();

        //刷新托盘内的菜单项
        reFreshChatItem(trayPanel);

        //将trayIcon添加到系统托盘
        systemTray.add(trayPanel);

    }


    /**
     * 功能描述: <br>
     * 〈新增的未读消息, 添加进入到系统托盘中〉
     *
     * @author zhiyuan.zhang01
     * @param: [chatMsgDto]
     * @return void
     * @created 2020/9/14 18:06
    */
    public void addNewChatMsg(ChatMsgDto chatMsgDto) {
        TrayPanel trayPanel = getTrayPanelInst();
        //将未读消息添加到消息集合中
        trayPanel.getChatMsgDtoList().add(chatMsgDto);
        //将托盘图标更新成最新消息者的头像
        trayPanel.setImage(IconUtils.getIconByName(chatMsgDto.getFriendUser().getIconName()).getImage());
        //当有未读消息时, 设置托盘图标闪烁
        trayPanel.setImageNeedFlash(trayPanel.getChatMsgDtoList().size() > 0);
    }



    /**
     * 功能描述: <br>
     * 〈当有新消息时, 重新刷新系统托盘内的菜单项〉
     *
     * @author zhiyuan.zhang01
     * @param: [trayPanel]
     * @return void
     * @created 2020/9/14 10:48
    */
    public static void reFreshChatItem(TrayPanel trayPanel) {
        //清除原有的所有菜单选项
        trayPanel.getPm().removeAll();
        //重新渲染菜单项
        trayPanel.getChatMsgDtoList().stream().forEach(dto -> {
            //1. 创建一个弹出菜单项
            //单个菜单样式: "好友名    消息条数"
            JMenuItem chatItem = new FriendMsgMenuItem(dto.getFriendUser().getName() +"    "+ dto.getMsgDtos().size(), IconUtils.getIconByName(dto.getFriendUser().getIconName()));
            //2. 将该项添加到弹出菜单
            trayPanel.getPm().add(chatItem);
            //3. 给该项添加双击事件(双击后打开聊天窗口; 窗口打开后, 需要将该聊天从托盘面盘中删除)
            chatItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //单击或双击
                    if (e.getClickCount() == 1 || e.getClickCount() == 2) {
                        //1. 弹出该好友的对话框
                        ChatWindowFactory.createAndShowChatWindow(dto.getFriendUser());
                        //2. 系统托盘消失
                        trayPanel.getDialog().setVisible(false);
                        //3. 从系统托盘中删除该对话对象
                        trayPanel.getChatMsgDtoList().remove(dto);
                        //4. 判断系统托盘是否需要闪烁
                        if (!(trayPanel.getChatMsgDtoList().size() > 0)) {
                            //不闪烁
                            trayPanel.setImageNeedFlash(false);
                            //设置托盘图标为原始默认图标
                            trayPanel.setImage(IconUtils.getIconByName("softIcon.png").getImage());
                        }
                    }
                }
            });
        });
    }
}
