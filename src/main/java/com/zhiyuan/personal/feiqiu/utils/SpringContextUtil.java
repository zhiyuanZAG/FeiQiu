package com.zhiyuan.personal.feiqiu.utils;

import com.zhiyuan.personal.feiqiu.view.factory.ChatWindowFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 〈一句话功能简述〉<br>
 * 〈用于获取spring容器中bean的工具类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/9/1 16:25
 * @since 1.0
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 功能描述: <br>
     * 〈通过beanName获取bean〉
     *
     * @author zhiyuan.zhang01
     * @param: [beanName]
     * @return java.lang.Object
     * @created 2020/9/1 16:27
    */
    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    /**
     * 功能描述: <br>
     * 〈根据class获取bean〉
     *
     * @author zhiyuan.zhang01
     * @param: [clazz]
     * @return T
     * @created 2020/9/1 16:28
    */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 功能描述: <br>
     * 〈通过name, 和class获取指定的bean〉
     *
     * @author zhiyuan.zhang01
     * @param: [name, clazz]
     * @return T
     * @created 2020/9/1 16:29
    */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
