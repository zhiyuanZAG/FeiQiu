package com.zhiyuan.personal.feiqiu.configuation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程池配置〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/24 15:24
 * @since 1.0
 */
@Configuration
@EnableAsync
@Slf4j
public class ExecutorConfig {

    /**
     * 功能描述: <br>
     * 〈单例线程池〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return java.util.concurrent.Executor
     * @created 2020/7/24 15:34
    */
    @Bean
    public Executor singleAsyncServiceExecutor(){
        log.info("### 配置spring内部使用的单例线程池");
        return Executors.newSingleThreadExecutor();
    }

    @Bean
    public Executor cachedAsyncServiceExecutor(){
        log.info("### 配置spring内部使用的缓冲线程池");
        return Executors.newCachedThreadPool();
    }

}
