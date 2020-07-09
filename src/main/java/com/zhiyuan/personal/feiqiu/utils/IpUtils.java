package com.zhiyuan.personal.feiqiu.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.*;
import java.util.Enumeration;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/9 17:54
 * @since 1.0
 */
@Slf4j
public class IpUtils {

    public static final String DEFAULT_IP = "127.0.0.1";


    /**
     * 直接根据第一个网卡地址作为其内网ipv4地址，避免返回 127.0.0.1
     *
     * @return
     */
    public static String getLocalIpByNetcard() {
        try {
            for (Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces(); e.hasMoreElements(); ) {
                NetworkInterface item = e.nextElement();
                for (InterfaceAddress address : item.getInterfaceAddresses()) {
                    if (item.isLoopback() || !item.isUp()) {
                        continue;
                    }
                    if (address.getAddress() instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address) address.getAddress();
                        return inet4Address.getHostAddress();
                    }
                }
            }
            return InetAddress.getLocalHost().getHostAddress();
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能描述: <br>
     * 〈获取本地IP地址〉
     *
     * @author zhiyuan.zhang01
     * @param: []
     * @return java.lang.String
     * @created 2020/7/9 17:56
    */
    public static String getLocalIP(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("获取当前IP异常:{}", e.getMessage());
            return DEFAULT_IP;
        }
    }

    public static void main(String[] args) {
        System.out.println("当前IP为:"+ IpUtils.getLocalIP());

        System.out.println("通过网卡获取当前IP为:"+IpUtils.getLocalIpByNetcard());
    }
}
