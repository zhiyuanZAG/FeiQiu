package com.zhiyuan.personal.feiqiu.service.impl;

import com.zhiyuan.personal.feiqiu.service.AsyncService;
import com.zhiyuan.personal.feiqiu.socket.LanSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈异步线程执行的服务实现类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/16 15:20
 * @since 1.0
 */
@Service
public class AsyncServiceImpl implements AsyncService {


    @Autowired
    private LanSendService lanSendService;


    @Override
    @Async("")
    public void executeReceiveUDPMsg() {
        lanSendService.udpMsgReceive();
    }
}
