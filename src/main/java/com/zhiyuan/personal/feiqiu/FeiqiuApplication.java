package com.zhiyuan.personal.feiqiu;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.service.StartPanelService;
import com.zhiyuan.personal.feiqiu.service.impl.StartPanelServiceImpl;
import com.zhiyuan.personal.feiqiu.view.factory.FriendDefaultListModelFactory;
import com.zhiyuan.personal.feiqiu.view.factory.StartPanelFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import java.util.List;

@ComponentScan(basePackages = {"com.zhiyuan.personal.feiqiu.*"})
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@Slf4j
public class FeiqiuApplication {

	public static void main(String[] args) {

		//启动swing的工作线程
		new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				ConfigurableApplicationContext context = new SpringApplicationBuilder(FeiqiuApplication.class)
						.headless(false)
						.run(args);
				//创建并显示GUI
				StartPanelService startPanelService = context.getBean(StartPanelService.class);
				startPanelService.createAndShowGUI();
				return null;
			}
		}.execute();
		System.out.println("====client Started====");

		// TODO: 2020/6/18 用于测试动态添加对象, 此处代码需屏蔽
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(3000L);
				System.out.println("开始添加对象");
				DefaultListModel model = FriendDefaultListModelFactory.getListModelInstance();
				model.add(0, FriendUser.builder().hostIP("111.111.111." + i).name("测试" + i).groupName("测试组").build());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
