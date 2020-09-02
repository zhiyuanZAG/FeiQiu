package com.zhiyuan.personal.feiqiu.utils;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈窗口位置生成的工具类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/27 11:28
 * @since 1.0
 */
public class WinPostionUtils {

    //X轴方向的起始位置
    private static final Integer START_X = 300;
    //Y轴方向的起始位置
    private static final Integer START_Y = 254;
    //单窗口高度
    private static final Integer WINDOW_HIGHT = 700;

    //窗口折返时, Y方向的间隔距离
    private static final Integer GAP_Y = 300;

    /**
     * 功能描述: <br>
     * 〈获取当前个数窗口的位置〉
     *
     * @author zhiyuan.zhang01
     * @param: [count]
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @created 2020/7/27 11:30
    */
    public static Map<String, Integer> getPostionByIndex(Integer count) {
        Map<String, Integer> result = new HashMap<>();
        if (null == count) {
            return result;
        }

        Integer postionX = START_X;
        Integer postionY = START_Y;

        int i = 0;
        //最后一次转折的遍历次数
        int transition = 0;
        while (i < count) {
            if (getPostionY((count-transition),postionY) > (getScreenSizeY()-WINDOW_HIGHT)) {
                transition = i;
                postionY += GAP_Y;
            }
            i++;
        }
        //最终计算的窗口位置
        postionX = getPostionX((count - transition), postionX);
        postionY = getPostionY((count - transition), postionY);
        result.put("postionX", postionX);
        result.put("postionY", postionY);
        return result;
    }


    /**
     * 功能描述: <br>
     * 〈计算X轴位置〉
     *
     * @author zhiyuan.zhang01
     * @param: [count, postion]
     * @return java.lang.Integer
     * @created 2020/7/27 14:43
    */
    private static Integer getPostionX(Integer count, Integer postion) {
        return (count - 1) * 80 + postion;
    }

    /**
     * 功能描述: <br>
     * 〈计算Y轴的位置〉
     *
     * @author zhiyuan.zhang01
     * @param: [count, postion]
     * @return java.lang.Integer
     * @created 2020/7/27 14:45
    */
    private static Integer getPostionY(Integer count, Integer postion) {
        return (count - 1) * 120 + postion;
    }


    /**
     * 功能描述: <br>
     * 〈获取屏幕X轴尺寸〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return java.lang.Integer
     * @created 2020/7/27 14:39
    */
    public static Integer getScreenSizeX() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int)screenSize.getWidth();
    }

    /**
     * 功能描述: <br>
     * 〈获取屏幕Y轴尺寸〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return java.lang.Integer
     * @created 2020/7/27 14:40
    */
    public static Integer getScreenSizeY(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int)screenSize.getHeight();
    }
}
