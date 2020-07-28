package com.zhiyuan.personal.feiqiu.view;

import lombok.*;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈工具面板实体类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/6/16 19:06
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JToolPanel extends JPanel {

    //工具栏
    private String comment;
}
