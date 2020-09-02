package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.dto.ChatMsgDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.awt.*;
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

    //当前托盘面板展示的所有待点开的聊天对象集合
    private List<ChatMsgDto> chatMsgDtoList;

    //标定软件icon图标是否闪烁的标识符
    private volatile boolean whetherFlash = false;

    /**
     * 标定当前展示的icon的名字:
     *  默认展示softIcon;
     *  当有消息提示时, 展示最后一个消息发送者的头像icon
     */
    private String iconName;

    //无参构造器
    public TrayPanel() throws HeadlessException {
        chatMsgDtoList = new LinkedList<>();
        iconName = "softIcon.png";  //当无未读消息时, 展示默认图标
    }

    public void paintTrayPanel() {

        //获取当前的系统托盘
        SystemTray systemTray = SystemTray.getSystemTray();
        //自定义弹出菜单
        PopupMenu pm = new PopupMenu();
        chatMsgDtoList.stream().forEach(dto->{
            //1. 创建一个弹出菜单项
            //2. 添加该项到弹出菜单
            //3. 弹出菜单
        });

        //创建带有指定图像, 工具提示, 和弹出菜单的TrayIcon
        //给TrayIcon添加鼠标监听器(移动到托盘上, 展示未读消息列表; 左键单击对应的消息栏, 弹出聊天窗口并从托盘中移除该消息框)
        //将trayIcon添加到系统托盘

    }
}
