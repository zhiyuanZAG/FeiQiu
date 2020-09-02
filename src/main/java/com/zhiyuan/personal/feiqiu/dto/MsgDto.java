package com.zhiyuan.personal.feiqiu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br>
 * 〈聊天的单个内容消息体〉
 *
 * @author zhiyuanzhang9
 * @create 2020/9/2 17:11
 * @since 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MsgDto {

    //接收|发送的消息内容
    private String msg;

    //接收|发送消息的时间
    private LocalDateTime dateTime;
}
