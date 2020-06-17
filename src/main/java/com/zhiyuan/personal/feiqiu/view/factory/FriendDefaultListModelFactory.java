package com.zhiyuan.personal.feiqiu.view.factory;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈创建DefaultListModel的工厂---单例〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/17 18:13
 * @since 1.0.0
 */
public class FriendDefaultListModelFactory {

    //存储好友的元素列表
    private static DefaultListModel model;

    public FriendDefaultListModelFactory() {
    }

    /**
     * 功能描述: <br>
     * 〈获取好友的元素列表〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.DefaultListModel
     * @created 2020/6/17 18:32
     */
    public static DefaultListModel getListModelInstance (){
        if (null == model) {
            synchronized (FriendDefaultListModelFactory.class) {
                if (null == model) {
                    model = new DefaultListModel();
                    return model;
                }
            }
        }
        return model;
    }




}
