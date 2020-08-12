package com.zhiyuan.personal.feiqiu.registrar;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import com.zhiyuan.personal.feiqiu.view.ChatWindow;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 * 〈打开的聊天窗口的注册器〉
 *
 * @author zhiyuanzhang9
 * @create 2020/8/5 16:56
 * @since 1.0
 */
@Service
public class ChatWindowRegistrar {

    private List<ChatWindow> chatWindowList;

    /**
     * 功能描述: <br>
     * 〈注册需要观察内容的聊天窗口〉
     *
     * @author zhiyuan.zhang01
     * @param: [chatWindow]
     * @return void
     * @created 2020/8/5 17:07
    */
    public void registrar(ChatWindow chatWindow) {
        this.chatWindowList.add(chatWindow);
    }

    /**
     * 功能描述: <br>
     * 〈对聊天窗口取消注册〉
     *
     * @author zhiyuan.zhang01
     * @param: [chatWindow]
     * @return void
     * @created 2020/8/5 17:09
    */
    public void remove(ChatWindow chatWindow) {
        this.chatWindowList.remove(chatWindow);
    }

    /**
     * 功能描述: <br>
     * 〈更新指定聊天窗口面板的内容〉
     *
     * @author zhiyuan.zhang01
     * @param: [clientUser, msg]
     * @return void
     * @created 2020/8/5 17:17
    */
    public void updateChatContent(ClientUser clientUser, String msg) {
        Optional<ChatWindow> optional = this.chatWindowList.stream().filter(o -> o.getUser().getHostIP().equals(clientUser.getHostIP())).findFirst();
        if (optional.isPresent()) {
            optional.get().refreshContent(msg);
        }
    }
}
