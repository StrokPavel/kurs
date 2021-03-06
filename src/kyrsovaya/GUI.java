package kyrsovaya;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {

    JLabel Label1, Label2, Label3, Label4;
    JButton Button1, Button2;
    JTextField TextField1, TextField2, TextField3;
    JTextArea TextArea1, TextArea2;
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

        Label4 = new JLabel();
        Label4.setBounds(30, 250, 730, 50);
        add(Label4);

        Button1 = new JButton("Зашифровать");
        Button1.setBounds(10, 50, 150, 50);
        add(Button1);
        Button1.addActionListener(event);

        TextArea2 = new JTextArea();
        TextArea2.setBounds(200, 50, 350, 50);
        add(TextArea2);

        TextArea1 = new JTextArea();
        TextArea1.setBounds(30, 150, 450, 100);
        add(TextArea1);

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
            TextArea2.setLineWrap(true);
            TextArea2.setWrapStyleWord(true);
            try {
                FileWriter f1 = new FileWriter("decrypt.txt");
                FileWriter f2 = new FileWriter("Original.txt");
                if (e.getSource() == Button1) {
                    String ss = b.encrypt(TextArea2.getText(), 1, 4);
                    String s = b.decrypt(b.encrypt(TextArea2.getText(), 1, 4), 1, 4);
                    String Astring_encryptoftext = a.encrypt(s);
                    String Astring_decryptoftext_atbash = a.decrypt(ss);
                    String Astring_decryptoftext_cesar = b.decrypt(Astring_decryptoftext_atbash, 1, 4);
                    TextArea1.setText(Astring_encryptoftext);
                    TextArea1.setLineWrap(true);
                    TextArea1.setWrapStyleWord(true);
                    f2.write(TextArea2.getText());
                    f2.close();
                    f1.write(Astring_encryptoftext);
                    f1.close();
                }
            } catch (IOException ex) {
                Logger.getLogger("НЕ УДАЛОСЬ СОЗДАТЬ ФАЙЛЫ");
            }

        }

    }
}
