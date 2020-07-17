package com.zhiyuan.personal.feiqiu.service;

import com.zhiyuan.personal.feiqiu.constant.UdpMsgTypeEnum;
import com.zhiyuan.personal.feiqiu.dto.ClientUser;

/**
 * 功能描述: <br>
 * 〈好友列表面板相关服务〉
 *
 * @author zhiyuan.zhang01
 * @param:
 * @return
 * @created 2020/7/16 16:20
*/
public interface FriendPanelService {

    /**
     * 功能描述: <br>
     * 〈新增朋友列表〉
     *
     * @author zhiyuan.zhang01
     * @param: [user]
     * @return void
     * @created 2020/7/16 16:22
    */
    void addFriendList(ClientUser user);

    /**
     * 功能描述: <br>
     * 〈根据收到的udp消息 维护好友人员列表〉
     *
     * @author zhiyuan.zhang01
     * @param: [typeEnum, user, msg]
     * @return boolean
     * @created 2020/7/16 18:30
    */
    boolean maintainFriendList(UdpMsgTypeEnum typeEnum, ClientUser user, String msg);

}
