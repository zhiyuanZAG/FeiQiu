package com.zhiyuan.personal.feiqiu.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈头像icon相关的工具类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/9 18:39
 * @since 1.0
 */
@Slf4j
public class IconUtils {

//    @Value("${iconPath}")
    private static String iconPath = "src/main/resources/icon" ;

    private static final String DEFAULT_ICON_NAME = "crown";

    //文件路径分隔符
    private static final String seperate = "/";


    public static List<String> iconNameList;

    /**
     * 功能描述: <br>
     * 〈初始化icon图片的名称集合〉
     *
     * @author zhiyuan.zhang01
     * @param:
     * @return
     * @created 2020/7/9 19:07
     */
    static {
        try {
            File file = new File(iconPath);
            if (file.isDirectory()) {
                File[] iconNames = file.listFiles();
                iconNameList = Arrays.stream(iconNames).map(File::getName).collect(Collectors.toList());
            }
        } catch (Exception e) {
            log.error("获取icon文件名失败, e->{}", e.getMessage());
            iconNameList = new ArrayList<>();
            iconNameList.add(DEFAULT_ICON_NAME);
        }
//        log.info("icon图片的name集合为: {}", JSONObject.toJSONString(iconNameList));
    }

    /**
     * 功能描述: <br>
     * 〈随机生成一个icon图片名〉
     *
     * @return java.lang.String
     * @author zhiyuan.zhang01
     * @param: []
     * @created 2020/7/9 18:45
     */
    public static String randomGenerateIcon() {
        Collections.shuffle(iconNameList);
        return iconNameList.get(0);
    }

    /**
     * 功能描述: <br>
     * 〈获取排序后的iconName的列表〉
     *
     * @return java.util.List<java.lang.String>
     * @author zhiyuan.zhang01
     * @param: []
     * @created 2020/7/9 19:05
     */
    public static List<String> getSortedNameList() {
        return iconNameList.stream().sorted().collect(Collectors.toList());
    }

    /**
     * 功能描述: <br>
     * 〈根据iconName, 从系统资源中获取对应的Icon〉
     *
     * @author zhiyuan.zhang01
     * @param: [iconName]
     * @return javax.swing.Icon
     * @created 2020/7/15 16:53
    */
    public static ImageIcon getIconByName(String iconName) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ResourceUtils.getURL(iconPath + seperate + iconName));
        }  catch (Exception e) {
            log.error("当前用户获取随机icon失败, e->{}", e.getMessage());
        }
        return icon;
    }


}
