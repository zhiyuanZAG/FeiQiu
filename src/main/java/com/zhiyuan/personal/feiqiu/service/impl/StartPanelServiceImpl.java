package com.zhiyuan.personal.feiqiu.service.impl;

import com.zhiyuan.personal.feiqiu.socket.LanSendService;
import com.zhiyuan.personal.feiqiu.service.StartPanelService;
import com.zhiyuan.personal.feiqiu.view.factory.StartPanelFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br>
 * 〈启动面板相关服务实现类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/19 16:24
 * @since 1.0.0
 */
public class StartPanelServiceImpl implements StartPanelService{

    @Autowired
    LanSendService lanSendService;

    @Override
    public void createAndShowGUI() {
        //0. 初始化当前用户

        //1. 广播本机上线

        //2. 接收所有在线用户

        //3. 展开启动页面
        StartPanelFactory.getStartPanelInstance().showStartPanel();

        //4 更新好友列表
    }
}
