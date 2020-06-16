package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import lombok.*;

import javax.swing.*;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 19:04
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JFriendPanel extends JPanel {

    //好友列表
    private List<FriendUser> friendUserList;
}
