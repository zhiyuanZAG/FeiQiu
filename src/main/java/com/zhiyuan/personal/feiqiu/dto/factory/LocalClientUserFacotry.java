package com.zhiyuan.personal.feiqiu.dto.factory;

import com.alibaba.fastjson.JSONObject;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.dto.LocalUser;
import com.zhiyuan.personal.feiqiu.utils.IconUtils;
import com.zhiyuan.personal.feiqiu.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈本地用户client工厂〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/17 18:44
 * @since 1.0.0
 */
@Slf4j
public class LocalClientUserFacotry {

    //本机
    private static LocalUser localClient;

    public LocalClientUserFacotry() {
    }

    /**
     * 功能描述: <br>
     * 〈初始化创建当前客户端实例〉
     *
     * @return com.zhiyuan.personal.feiqiu.dto.ClientUser
     * @author zhiyuan.zhang01
     * @param: []
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
     * @return com.zhiyuan.personal.feiqiu.dto.ClientUser
     * @author zhiyuan.zhang01
     * @param: []
     * @created 2020/6/17 18:53
     */
    private static LocalUser createLocalClient() {
        //2020/6/17 按照本机IP创建本机user
        String localIp = IpUtils.getLocalIP();
        String iconName = IconUtils.randomGenerateIcon();
        LocalUser local = LocalUser.builder()
                .hostIP(localIp)
                .name(localIp)
                .iconName(iconName)
                .build();
        log.info("组装local用户端->{}", JSONObject.toJSONString(local));
        return local;
    }
}
