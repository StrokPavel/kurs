package kyrsovaya;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kyrsovaya.*;

public class GUI extends JFrame {

    JLabel Label1, Label2, Label3, Label4;
    JButton Button1, Button2;
    JTextField TextField1, TextField2, TextField3;
    click event = new click();

    public GUI(String name) {

        super(name);

        setLayout(null);

        Label1 = new JLabel("Текст для шифрования");
        Label1.setBounds(350, 10, 400, 30);
        add(Label1);

        Label2 = new JLabel("Зашифрованный текст:");
        Label2.setBounds(200, 130, 200, 15);
        add(Label2);

        Label3 = new JLabel();
        Label3.setBounds(30, 170, 730, 50);
        add(Label3);

        Label4 = new JLabel();
        Label4.setBounds(30, 250, 730, 50);
        add(Label4);

        Button1 = new JButton("Зашифровать");
        Button1.setBounds(10, 50, 150, 50);
        add(Button1);
        Button1.addActionListener(event);

        TextField1 = new JTextField();
        TextField1.setBounds(200, 50, 350, 60);
        add(TextField1);

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public class click implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Cesar b = new Cesar();
            Atbash a = new Atbash();
            if (e.getSource() == Button1) {
                String ss = b.encrypt(TextField1.getText(), 1, 4);
                String s = b.decrypt(b.encrypt(TextField1.getText(), 1, 4), 1, 4);
                String Astring_encryptoftext = a.encrypt(s);
                String Astring_decryptoftext_atbash = a.decrypt(ss);
                String Astring_decryptoftext_cesar = b.decrypt(Astring_decryptoftext_atbash, 1, 4);
                Label3.setText("Метод Цезаря:  \r" + ss);
                Label4.setText("Метод Атбаш:  \r" + Astring_encryptoftext.trim());
            }

        }

    }
}