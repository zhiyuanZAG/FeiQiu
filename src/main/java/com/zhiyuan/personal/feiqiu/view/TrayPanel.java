package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.configuation.ExecutorConfig;
import com.zhiyuan.personal.feiqiu.dto.ChatMsgDto;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import com.zhiyuan.personal.feiqiu.utils.SpringContextUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 * 〈系统托盘面板〉
 *
 * @author zhiyuanzhang9
 * @create 2020/9/2 17:04
 * @since 1.0
 */
@Data
@Slf4j
public class TrayPanel extends TrayIcon {

    //弹出菜单的显示媒介
    private JDialog dialog;

    //当前托盘面板展示的所有待点开的聊天对象集合(多线程修改)
    private volatile List<ChatMsgDto> chatMsgDtoList;

    //标定软件icon图标是否闪烁的标识符(多线程修改)
    private volatile boolean imageNeedFlash = false;

    //标定当前展示的icon的名字: 默认展示softIcon; 当有消息提示时, 展示最后一个消息发送者的头像icon
    private String iconName;

    //自定义的弹出菜单
    private JPopupMenu pm;



    /**
     * 功能描述: <br>
     * 〈自定义构造器〉
     *
     * @author zhiyuan.zhang01
     * @param: [iconName, popup]
     * @return
     * @created 2020/9/14 17:14
    */
    public TrayPanel(String iconName, JPopupMenu popup) {
        super(IconUtils.getIconByName(iconName).getImage(), "feiqiu");
        this.iconName = Optional.ofNullable(iconName).orElse("softIcon.png");   //默认为软件logo
        this.chatMsgDtoList = new LinkedList<>();
        this.pm = popup;
        //初始化dialog
        dialog = new JDialog();
        dialog.setUndecorated(true);    //取消窗体装饰
        dialog.setAlwaysOnTop(true);    //设置窗体始终位于上方

        //设置图标大小为自动调节
        this.setImageAutoSize(true);

        //给托盘设置鼠标监听器
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                //鼠标进入到托盘区域
                log.info("--> 鼠标进入托盘");
                Dimension size = pm.getPreferredSize();
                dialog.setLocation(e.getX()-size.width-3, e.getY()-size.height-3);  //设置dialog框的显示位置
                dialog.setVisible(true);

                //显示弹出菜单的menu
                pm.show(dialog.getContentPane(), 0, 0);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                //鼠标退出托盘区域
                log.info("--> 鼠标退出托盘");
                dialog.setVisible(false);
            }
        });

        //给弹出菜单设置监听器
        pm.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                dialog.setVisible(false);
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                dialog.setVisible(false);
            }
        });

        //启动守护线程, 用于判定托盘图标是否需要闪烁
        SpringContextUtil.getBean(ExecutorConfig.class).singleAsyncServiceExecutor().execute(() -> {
            while (true) {
                if (imageNeedFlash) {
                    //需要闪烁
                    try {
                        //空白图片展示500ms
                        this.setImage(IconUtils.getIconByName("empty.png").getImage());
                        Thread.sleep(500);
                        //原Icon展示500ms
                        this.setImage(IconUtils.getIconByName(this.iconName).getImage());
                        Thread.sleep(500);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                } else {
                    try {
                        //不需要闪烁
                        this.setImage(IconUtils.getIconByName(this.iconName).getImage());
                        Thread.sleep(1000); //每1秒确认一次是否需要闪烁
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }

                }
            }
        });
    }
}
