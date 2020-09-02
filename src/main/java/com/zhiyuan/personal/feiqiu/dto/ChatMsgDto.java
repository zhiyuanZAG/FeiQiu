package com.zhiyuan.personal.feiqiu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈与单独对象的聊天内容的消息体〉
 *
 * @author zhiyuanzhang9
 * @create 2020/9/2 17:08
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMsgDto {

    //聊天对象
    private FriendUser friendUser;

    //当前聊天对象发送的消息体
    private List<MsgDto> msgDtos;

}
