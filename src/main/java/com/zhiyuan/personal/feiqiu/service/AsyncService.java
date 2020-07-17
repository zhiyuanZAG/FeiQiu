package com.zhiyuan.personal.feiqiu.service;

/**
 * 功能描述: <br>
 * 〈异步任务接口〉
 *
 * @author zhiyuan.zhang01
 * @param: 
 * @return 
 * @created 2020/7/16 15:11
*/
public interface AsyncService {

    /**
     * 功能描述: <br>
     * 〈异步启动接收UDP消息的线程(单线程执行)〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return void
     * @created 2020/7/16 15:19
    */
    void executeReceiveUDPMsg();
}
