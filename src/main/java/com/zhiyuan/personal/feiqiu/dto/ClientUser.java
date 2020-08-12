package com.zhiyuan.personal.feiqiu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.swing.*;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈客户端用户实体类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 18:15
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ClientUser {

    //IP地址
    String hostIP;

    //用户名
    String name;

    //用户头像
    String iconName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientUser user = (ClientUser) o;
        return Objects.equals(hostIP, user.hostIP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostIP);
    }
}
