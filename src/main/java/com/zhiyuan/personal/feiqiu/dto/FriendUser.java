package com.zhiyuan.personal.feiqiu.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.swing.*;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 18:18
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class FriendUser extends ClientUser {

    //分组名
    private String groupName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendUser)) return false;
        FriendUser that = (FriendUser) o;
        //当用户的IP相同, 即任务该用户为同一用户
        return Objects.equals(super.hostIP, that.hostIP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupName);
    }
}
