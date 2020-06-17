package com.zhiyuan.personal.feiqiu.model;

import com.zhiyuan.personal.feiqiu.dto.FriendUser;
import lombok.*;

import javax.swing.*;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈开始面板_好友列表模型〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/17 16:08
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendListModel extends AbstractListModel {

    List<FriendUser> friendUsers;

    @Override
    public int getSize() {
        return friendUsers.size();
    }

    @Override
    public Object getElementAt(int index) {
        return friendUsers.get(index);
    }
}
