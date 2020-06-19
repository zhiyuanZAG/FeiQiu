package com.zhiyuan.personal.feiqiu.view.factory;

import com.zhiyuan.personal.feiqiu.view.JToolPanel;
import com.zhiyuan.personal.feiqiu.view.StartPanel;

/**
 * 〈一句话功能简述〉<br>
 * 〈开始面板创建工厂〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/18 15:34
 * @since 1.0.0
 */
public class StartPanelFactory {

    private static StartPanel startPanel;

    private StartPanelFactory() {
    }

    /**
     * 功能描述: <br>
     * 〈获取单例〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return com.zhiyuan.personal.feiqiu.view.StartPanel
     * @created 2020/6/18 15:43
     */
    public static StartPanel getStartPanelInstance() {
        if (null == startPanel) {
            synchronized (StartPanelFactory.class) {
                if (null == startPanel) {
                    startPanel = createStartPanel();
                    return startPanel;
                }
            }
        }
        return startPanel;
    }

    /**
     * 功能描述: <br>
     * 〈创建单例〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return com.zhiyuan.personal.feiqiu.view.StartPanel
     * @created 2020/6/18 15:43
     */
    private static StartPanel createStartPanel() {
        return StartPanel.builder()
                .namePanel(JNamePanelFactory.createNamePanel())
                .friendPanel(JFriendPanelFactory.createFriendPanel())
                .toolPanel(new JToolPanel())
                .isOpen(false)
                .build();
    }

}
