package com.zhiyuan.personal.feiqiu.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.swing.*;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class FriendUser extends ClientUser {

    //分组名
    private String groupName;

//    @Builder(toBuilder = true)
//    public FriendUser(String hostIP, String name, ImageIcon icon, String groupName) {
//        super(hostIP, name, icon);
//        this.groupName = groupName;
//    }

}
