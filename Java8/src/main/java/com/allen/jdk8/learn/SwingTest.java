package com.allen.jdk8.learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @descript 通过swing的一个例子引出lambda表达式
 * @author cyfIverson
 * @date 2019-07-18 10:40 AM
 */
public class SwingTest {


    public static void main(String[] args) {
        JFrame jframe = new JFrame("My JFrame");
        JButton jbutton = new JButton("My Button");

        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed");
            }
        });

        jbutton.addActionListener(event->{
            System.out.println("Button Pressed");
            System.out.println("测试");
        });

        jframe.add(jbutton);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
