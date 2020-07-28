package com.zhiyuan.personal.feiqiu.view.factory;

import com.alibaba.fastjson.JSONObject;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.dto.factory.LocalClientUserFacotry;
import com.zhiyuan.personal.feiqiu.renderer.NamePanelCellRender;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 19:02
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@Slf4j
public class JNamePanelFactory {

    //宽度
    private static Integer WEIGHT = 290;

    //高度
    private static Integer HEIGHT = 100;

    //字体
    private static Font FONT = new Font("宋体", Font.BOLD, 40);


    /**
     * 功能描述: <br>
     * 〈创建当前用户panel〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.JPanel
     * @created 2020/6/17 19:00
     */
    public static JPanel createNamePanel(){
        JPanel jp = new JPanel();
        jp.setSize(WEIGHT, HEIGHT);
        jp.setBackground(Color.PINK);
        ClientUser localClient = LocalClientUserFacotry.getLocalClientInstance();

        DefaultListModel model = NameDefaultListModelFactory.getDefaultListInstance();
        JList<ClientUser> localClientList = new JList(model);
        localClientList.setCellRenderer(new NamePanelCellRender());
        localClientList.setFont(FONT);
        localClientList.setBackground(Color.PINK);
        // 2020/6/17 需要展示真实用户IP信息
        log.info("localUser->{}", JSONObject.toJSONString(localClient));
        jp.add(localClientList);
        model.add(0, localClient);
        return jp;
    }
}
