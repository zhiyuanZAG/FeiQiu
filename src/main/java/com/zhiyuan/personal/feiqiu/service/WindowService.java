package com.zhiyuan.personal.feiqiu.service;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.utils.WinPostionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈窗口运行相关服务〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/27 11:18
 * @since 1.0
 */
@Service
@Slf4j
public class WindowService {

    //当前已打开的聊天窗口的个数
    private static Integer windowCount = 0;


    /**
     * 功能描述: <br>
     * 〈异步:<br>启动一个聊天窗口〉
     *
     * @author zhiyuan.zhang01
     * @param: [user]
     * @return void
     * @created 2020/7/27 11:21
    */
    @Async("cachedAsyncServiceExecutor")
    public void createChatWindow(ClientUser user) {
        windowCount++;
        //新生成窗口的位置
        Map<Integer, Integer> postionMap = WinPostionUtils.getPostionByIndex(windowCount);
        int postionX = postionMap.keySet().stream().findFirst().get();
        int postionY = postionMap.values().stream().findFirst().get();

    }
}
