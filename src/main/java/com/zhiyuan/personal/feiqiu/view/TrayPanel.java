package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.dto.ChatMsgDto;
import com.zhiyuan.personal.feiqiu.dto.FriendMsgMenuItem;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import com.zhiyuan.personal.feiqiu.view.factory.ChatWindowFactory;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈系统托盘面板〉
 *
 * @author zhiyuanzhang9
 * @create 2020/9/2 17:04
 * @since 1.0
 */
@Data
@Repository
public class TrayPanel extends Frame {

    //当前托盘面板展示的所有待点开的聊天对象集合(多线程修改)
    private volatile List<ChatMsgDto> chatMsgDtoList;

    //标定软件icon图标是否闪烁的标识符(多线程修改)
    private volatile boolean whetherFlash = false;

    /**
     * 标定当前展示的icon的名字:
     * 默认展示softIcon;
     * 当有消息提示时, 展示最后一个消息发送者的头像icon
     */
    private String iconName;

    //获取到的系统托盘
    SystemTray systemTray;

    //自定义的弹出菜单
    private JPopupMenu pm;

    //无参构造器初始化属性默认值
    public TrayPanel() throws HeadlessException {
        chatMsgDtoList = new LinkedList<>();
        iconName = "softIcon.png";  //当无未读消息时, 展示默认图标
        systemTray = SystemTray.getSystemTray();    //初始化系统托盘
        pm = new JPopupMenu();  //初始化弹出菜单

    }

}
