package com.zhiyuan.personal.feiqiu;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.service.StartPanelService;
import com.zhiyuan.personal.feiqiu.service.impl.StartPanelServiceImpl;
import com.zhiyuan.personal.feiqiu.view.factory.FriendDefaultListModelFactory;
import com.zhiyuan.personal.feiqiu.view.factory.StartPanelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;

@ComponentScan(basePackages = {"com.zhiyuan.personal.feiqiu.*"})
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class FeiqiuApplication {

	public static void main(String[] args) {
		//启动线程: 创建并显示GUI
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				StartPanelService startPanelService = new StartPanelServiceImpl();
				startPanelService.createAndShowGUI();
			}
		});

		//启动应用
		SpringApplication.run(FeiqiuApplication.class, args);
		System.out.println("====client Started====");

		// TODO: 2020/6/18 用于测试动态添加对象, 此处代码需屏蔽
		try {
			Thread.sleep(5000L);
			System.out.println("开始添加对象");
			DefaultListModel model = FriendDefaultListModelFactory.getListModelInstance();
			model.add(0, FriendUser.builder().hostIP("111.111.111.111").name("测试").groupName("测试组").build());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
