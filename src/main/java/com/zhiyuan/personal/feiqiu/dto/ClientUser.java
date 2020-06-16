package com.zhiyuan.personal.feiqiu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ClientUser {

    //IP地址
    private String hostIP;

    //用户名
    private String name;


}
