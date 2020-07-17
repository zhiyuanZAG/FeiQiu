package com.zhiyuan.personal.feiqiu.socket.impl;

import com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.service.FriendPanelService;
import com.zhiyuan.personal.feiqiu.socket.LanSendService;
import com.zhiyuan.personal.feiqiu.utils.UdpMsgStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * 〈一句话功能简述〉<br>
 * 〈网络发送行为实现类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/7/16 11:16
 * @since 1.0
 */
@Service
@Slf4j
public class LanSendServiceImpl implements LanSendService {

    @Value("${broadcast.ip}")
    private String BC_IP;

    @Value("${broadcast.port}")
    private int BC_PORT;

    //包限制大小
    private final static int PACK_SIZE = 4096;

    @Autowired
    private FriendPanelService friendPanelService;

    @Override
    public boolean udpMsgSend(String msg) {
        boolean flag = false;
        MulticastSocket socket = null;
        try {
            socket = new MulticastSocket();
            log.info("开始发送udpMsg: BC_IP= {}, PORT= {}, msg={}", BC_IP, BC_PORT, msg);
            //多播指定IP
            InetAddress group = InetAddress.getByName(BC_IP);
            //加入多播组
            socket.joinGroup(group);
            //组装数据包
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, BC_PORT);
            //开始发送数据包
            socket.send(packet);
            flag = true;
        } catch (UnknownHostException e) {
            log.error("组播发送msg失败, UnknownHostException->{}", e.getMessage());
        } catch (IOException e) {
            log.error("组播发送msg失败, IOException->{}", e.getMessage());
        }finally {
            if (null != socket) {
                socket.close();
            }
        }
        return flag;
    }

    @Override
    public String udpMsgReceive() {
        MulticastSocket socket = null;
        try {
            socket = new MulticastSocket();
            //多播指定IP
            InetAddress group = InetAddress.getByName(BC_IP);
            //加入多播组
            socket.joinGroup(group);
            DatagramPacket packet = new DatagramPacket(new byte[PACK_SIZE], PACK_SIZE);
            //开始接收消息
            while (true) {
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                //解析接收到的消息
                log.info("接收到udp消息:{}", msg);
                decodeUdpMsg(msg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != socket) {
                socket.close();
            }
        }
        return null;
    }

    /**
     * 功能描述: <br>
     * 〈解析接收到的udp消息〉
     *
     * @author zhiyuan.zhang01
     * @param: [msg]
     * @return void
     * @created 2020/7/16 18:14
    */
    private void decodeUdpMsg(String msg) {
        String[] result = UdpMsgStringUtils.encodeUdpMsg(msg);
        if (null != result && result.length >= 4) {
            //消息类型
            UdpMsgTypeEnum typeEnum = UdpMsgTypeEnum.getByIndex(result[0]);
            //发送消息的主机
            String hostIp = result[1];
            //发送消息的主机名
            String hostName = result[2];
            //发送消息的主机头像
            String hostIconName = result[3];
            //发送消息的主机传递的消息
            // TODO: 2020/7/16 此消息作为后续扩容插口, 暂不起实际作用
            String hostMsg = null;
            if (result.length > 4) {
                hostMsg = result[4];
            }
            ClientUser user = ClientUser.builder()
                    .hostIP(hostIp)
                    .name(hostName)
                    .iconName(hostIconName)
                    .build();
            friendPanelService.maintainFriendList(typeEnum, user, hostMsg);
        }
    }

}
