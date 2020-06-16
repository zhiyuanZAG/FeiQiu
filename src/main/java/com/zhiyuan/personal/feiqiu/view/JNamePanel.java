package com.zhiyuan.personal.feiqiu.view;

import com.zhiyuan.personal.feiqiu.dto.ClientUser;
import lombok.*;

import javax.swing.*;
import java.awt.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 19:02
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
public class JNamePanel extends JPanel {
    //本机
    private ClientUser localClient;

    private JLabel label;

    public JNamePanel() {
        setSize(300, 60);
        setFont(new Font("楷体",Font.BOLD,40));
        label = new JLabel("hostIP");
        add(label);
    }
}
