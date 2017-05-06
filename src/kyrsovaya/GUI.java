/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kyrsovaya;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kyrsovaya.*;

/**
 *
 * @author DELL
 */
public class GUI extends JFrame {

    JLabel Label1, Label2;
    JButton Button1, Button2;
    JTextField TextField1, TextField2, TextField3;
    MouseEvent click;

    public GUI(String name) {

        super(name);

        setLayout(null);

        Label1 = new JLabel("Текст для шифрования");
        Label1.setBounds(350, 10, 400, 30);
        add(Label1);

        Label2 = new JLabel("Зашифрованный текст:");
        Label2.setBounds(200, 130, 200, 15);
        add(Label2);

        Button1 = new JButton("Зашифровать");
        Button1.setBounds(10, 30, 150, 100);
        add(Button1);
        Button1.addActionListener((ActionListener) click);

        TextField1 = new JTextField();
        TextField1.setBounds(200, 50, 350, 60);
        add(TextField1);


        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}