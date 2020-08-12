package com.zhiyuan.personal.feiqiu.view.factory;

import lombok.Synchronized;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈创建存储本机元素列表的单例工厂〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/20 09:17
 * @since 1.0
 */
public class NameDefaultListModelFactory {

    //存储本机的元素列表
    private static DefaultListModel model;

    private NameDefaultListModelFactory() {
    }


    /**
     * 功能描述: <br>
     * 〈获取当前本机元素列表的单例〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return javax.swing.DefaultListModel
     * @created 2020/7/20 09:20
    */
    public static DefaultListModel getDefaultListInstance() {
        if (null == model) {
            synchronized (NameDefaultListModelFactory.class){
                if (null == model) {
                    model = new DefaultListModel();
                    return model;
                }
            }
        }
        return model;
    }
}
