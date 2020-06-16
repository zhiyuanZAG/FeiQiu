package com.zhiyuan.personal.feiqiu.dto;

import lombok.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 18:18
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendUser extends ClientUser {

    //分组名
    private String groupName;

}
