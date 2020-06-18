package com.zhiyuan.personal.feiqiu;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import com.zhiyuan.personal.feiqiu.view.factory.FriendDefaultListModelFactory;
import com.zhiyuan.personal.feiqiu.view.factory.StartPanelFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.*;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class FeiqiuApplication {

	public static void main(String[] args) {

		//0. 初始化当前用户

		//1. 广播本机上线

		//2. 接收所有在线用户

		//3. 展开启动页面
		StartPanelFactory.getStartPanelInstance().showStartPanel();

		//4 更新好友列表

		System.out.println("====server Started====");

		// TODO: 2020/6/18 测试动态添加对象
		try {
			Thread.sleep(5000L);
			System.out.println("开始添加对象");
			DefaultListModel model = FriendDefaultListModelFactory.getListModelInstance();
			model.add(0, FriendUser.builder().hostIP("111.111.111.111").name("测试").groupName("测试组").build());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		SpringApplication.run(FeiqiuApplication.class, args);
	}

}
