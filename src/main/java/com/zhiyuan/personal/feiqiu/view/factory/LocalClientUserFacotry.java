package com.zhiyuan.personal.feiqiu.view.factory;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/17 18:44
 * @since 1.0.0
 */
public class LocalClientUserFacotry {

    //本机
    private static ClientUser localClient;

    public LocalClientUserFacotry() {
    }

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
        // TODO: 2020/6/17 更新成按照本机IP创建本机user
        return new ClientUser();
    }
}
