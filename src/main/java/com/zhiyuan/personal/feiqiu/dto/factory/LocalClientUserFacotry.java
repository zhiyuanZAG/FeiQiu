package com.zhiyuan.personal.feiqiu.dto.factory;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import com.zhiyuan.personal.feiqiu.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/17 18:44
 * @since 1.0.0
 */
@Slf4j
public class LocalClientUserFacotry {

    @Value("iconPath")
    private static String iconPath;

    //文件路径分隔符
    private static final String seperate = "/";

    private static final String DEFAULT_ICON_NAME = "crown";

    //本机
    private static ClientUser localClient;

    public LocalClientUserFacotry() {
    }

    /**
     * 功能描述: <br>
     * 〈初始化创建当前客户端实例〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return com.zhiyuan.personal.feiqiu.dto.ClientUser
     * @created 2020/7/9 18:11
    */
    public static ClientUser getLocalClientInstance() {
        if (null == localClient) {
            synchronized (LocalClientUserFacotry.class) {
                if (null == localClient) {
                    localClient = createLocalClient();
                    return localClient;
                }
            }
        }
        return localClient;
    }

    /**
     * 功能描述: <br>
     * 〈创建本机用户〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return com.zhiyuan.personal.feiqiu.dto.ClientUser
     * @created 2020/6/17 18:53
     */
    private static ClientUser createLocalClient() {
        // TODO: 2020/6/17 按照本机IP创建本机user
        String localIp = IpUtils.getLocalIP();
        String iconName = IconUtils.randomGenerateIcon();
        ImageIcon icon = new ImageIcon();
        try {
            new ImageIcon(ResourceUtils.getURL(iconPath + seperate + iconName));
        } catch (Exception e) {
            log.error("当前用户获取随机icon失败, e->{}", e.getMessage());
            try {
                icon = new ImageIcon(ResourceUtils.getURL(iconPath + seperate + DEFAULT_ICON_NAME));
            } catch (Exception e1) {
                log.error("当前用户设置默认icon失败, e->{}", e.getMessage());
            }
        }
        ClientUser local = ClientUser.builder()
                .hostIP(localIp)
                .name(localIp)
                .icon(icon)
                .build();
        return local;
    }
}
