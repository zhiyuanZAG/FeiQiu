package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.constant.FontTypeEnum;
import com.zhiyuan.personal.feiqiu.constant.ToolIconEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.utils.DateUtils;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br>
 * 〈聊天窗口实体类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/27 15:49
 * @since 1.0
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChatWindow extends JFrame {

    //FRAM面板的y轴布局间隔
    private static final Integer FRAME_GAP_H = 2;
    //FRAM面板的X轴布局间隔
    private static final Integer FRAME_GAP_V = 5;
    //pannel面板的y轴布局间隔
    private static final Integer PANEL_GAP_H = 2;
    //pannel面板的X轴布局间隔
    private static final Integer PANEL_GAP_V = 1;

    //工具栏的高度
    private static final Integer TOOL_BAR_HEIGHT = 10;
    //工具栏图标高度
    private static final Integer TOOL_BAR_ICON_HEIGHT = 8;

    //字体
    private static Font KAI = new Font(FontTypeEnum.KAI.code, Font.BOLD, 12);

    //聊天输入框(文本域): 单行50字
    private static final Integer textAreaColumn = 50;

    //聊天输入框(文本域): 可视输入框15行
    private static final Integer textAreaRow = 15;

    //当前聊天的对象
    private ClientUser user;

    //当前聊天的聊天内容框
    private JTextArea CHAT_AREA;

    /**
     * 功能描述: <br>
     * 〈无参构造函数〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return
     * @created 2020/8/5 15:43
    */
    public ChatWindow() throws HeadlessException {
        super();
        CHAT_AREA = modifyChatArea();
    }

    /**
     * 功能描述: <br>
     * 〈在指定位置 展示当前聊天窗口<br>
     *     双击好友开启聊天对话框〉
     *
     * @author zhiyuan.zhang01
     * @param: [postionX, postionY]
     * @return void
     * @created 2020/7/27 16:59
    */
    private void showWindow(Integer postionX, Integer postionY) {
        // TODO: 2020/7/27 构建聊天窗口
        //聊天窗口布局(上+下)
        this.setLayout(new BorderLayout(FRAME_GAP_H, FRAME_GAP_V));
        //聊天窗口的顶部聊天对象信息
        JPanel targetPanel = new JPanel();
        JLabel targetLabel = buildTargetLabel();
        targetPanel.add(targetLabel);
        targetPanel.setBackground(Color.lightGray);
        targetPanel.setPreferredSize(targetLabel.getPreferredSize());
        this.add(targetPanel, BorderLayout.NORTH);  //窗口顶部的聊天对象信息

        //聊天窗口底部内容面板
        JPanel southFramePanel = new JPanel();
        //底部面板布局(中+右)
        southFramePanel.setLayout(new BorderLayout(PANEL_GAP_H, PANEL_GAP_V));
        //|-->底部面板的左半部分
        JPanel southFrameLeftPanel = new JPanel();
        //左半部分布局(上+中+下)
        southFrameLeftPanel.setLayout(new BorderLayout(PANEL_GAP_H, PANEL_GAP_V));
        //左半部分-上(对话框: 能复现对话两者的对话内容)
        this.CHAT_AREA.setSize(southFrameLeftPanel.getSize().width, (southFrameLeftPanel.getSize().height - TOOL_BAR_HEIGHT) * 3 / 4);  //设置聊天框大小
        JScrollPane jScrollPane = new JScrollPane(this.CHAT_AREA);
        jScrollPane.setSize(CHAT_AREA.getSize());
        southFrameLeftPanel.add(jScrollPane, BorderLayout.NORTH);
        //左半部分-中(工具栏: 暂时只添加传文件的按钮)
        JToolBar toolBar = createToolBar();
        toolBar.setSize(southFrameLeftPanel.getSize().width, TOOL_BAR_HEIGHT);  //设置工具栏大小
        southFrameLeftPanel.add(toolBar, BorderLayout.CENTER);
        //左半部分-下(输入框+发送按钮: 输入聊天内容)
        JTextArea inputArea = createInputArea();
        // TODO: 2020/8/6 聊天窗口的文本输入框 && 接收到消息后, 需要进行窗口注册
        inputArea.setSize(southFrameLeftPanel.getSize().width, southFrameLeftPanel.getSize().height - TOOL_BAR_HEIGHT - jScrollPane.getSize().height);  //设置文本输入框的大小
        southFrameLeftPanel.add(inputArea, BorderLayout.SOUTH);
        southFramePanel.add(southFrameLeftPanel, BorderLayout.CENTER);

        //|-->底部面板的右半部分
        JPanel southFrameRightPanel = new JPanel();
        //右半部分布局(上+下)
        southFrameRightPanel.setLayout(new BorderLayout(PANEL_GAP_H, PANEL_GAP_V));
        //右半部分-上(聊天对象的信息: ip+name+group)
        JPanel southFrameRightUpPanel = new JPanel();

        //右半部分-下(当前自身的信息: ip+name)
        southFramePanel.add(southFrameRightPanel, BorderLayout.EAST);

        this.add(southFramePanel, BorderLayout.SOUTH);  //窗口底部的内容面板
        this.setVisible(true);
    }

    /**
     * 功能描述: <br>
     * 〈创建聊天输入的文本域〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.JTextArea
     * @created 2020/8/6 18:56
    */
    private JTextArea createInputArea() {
        //初始化指定行数/每行字数
        JTextArea inputArea = new JTextArea(textAreaColumn, textAreaRow);
        inputArea.setLineWrap(true);    //输入文本自动换行
        inputArea.setForeground(Color.BLACK);   //设置组件的背景色
        inputArea.setFont(new Font(FontTypeEnum.KAI.code, Font.BOLD, 10 )); //设置输入框的字体
        //挂载一个按键的监听器(监听回车发送聊天内容)
        inputArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //添加回车键监听器
                if ((char) e.getKeyChar() == KeyEvent.VK_ENTER) {
                    // TODO: 2020/8/28  按下回车, 获取该输入框内的内容, 并调用UDP发送接口
                    
                }
            }
        });
        return inputArea;
    }

    /**
     * 功能描述: <br>
     * 〈创建一个聊天窗口工具栏〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.JToolBar
     * @created 2020/8/6 18:05
    */
    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);    //不允许移动该工具栏
        JButton sendFile = new JButton(IconUtils.getToolIconByName(ToolIconEnum.SEND_FILE, TOOL_BAR_ICON_HEIGHT, TOOL_BAR_ICON_HEIGHT));    //添加一个发送文件的按钮
        sendFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 2020/8/6 聊天窗口工具栏, 需要挂载一个发送文件的监听事件(在sendFile的按钮上)
            }
        });
        toolBar.add(sendFile);
        return toolBar;
    }

    /**
     * 功能描述: <br>
     * 〈定义滚动展示的聊天文本域〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.JTextArea
     * @created 2020/8/5 15:19
    */
    private JTextArea modifyChatArea() {
        JTextArea chatArea = new JTextArea();
        chatArea.setLineWrap(true); //设置自动换行
        chatArea.setForeground(Color.WHITE);    //设置文本域组件的背景色
        chatArea.setFont(new Font("楷体", Font.BOLD,13)); //设置聊天文本域的字体
        chatArea.setEditable(false);    //文本框不可编辑
        return chatArea;
    }

    /**
     * 功能描述: <br>
     * 〈创建聊天窗口的顶部聊天对象展示Label标签〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.JLabel
     * @created 2020/7/28 16:10
    */
    private JLabel buildTargetLabel() {
        JLabel targetLabel = new JLabel();
        targetLabel.setIcon(IconUtils.getSizedIconByName(this.user.getIconName(), 30, 30));  //设置头像
        String text = "<html><p style = \"line-height:5; font-size:16px;\"> IP: " + this.user.getHostIP() + "<br/> hostName: " + user.getName() + "</p></html>";
        targetLabel.setText(text);  //设置聊天好友展示信息
        targetLabel.setIconTextGap(5);  //设置头像与信息之间的间隔
        return targetLabel;
    }

    /**
     * 功能描述: <br>
     * 〈刷新聊天面板的展示内容(接收到聊天目标的内容)〉
     *
     * @author zhiyuan.zhang01
     * @param: [msg]
     * @return void
     * @created 2020/8/5 17:18
    */
    public void refreshContent(String msg) {
        //当前时间
        String currentTime = DateUtils.localDateTimeFormatDT(LocalDateTime.now());
        String appendStr = "<html><p style = \"line-height:10; font-size:13px; color:blue\"> " + currentTime + "<br/>" + msg + "</p></html>";
        this.CHAT_AREA.append(appendStr);
    }
}
