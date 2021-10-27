package thread1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JLabel sign;
    private JButton button;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BITLAB Application");
        setSize(500,500);
        setLayout(null);

        sign = new JLabel("#");
        sign.setSize(50,30);
        sign.setLocation(100,100);
        add(sign);

        button = new JButton("FIRE");
        button.setSize(300,30);
        button.setLocation(100,270);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Location signNew = new Location(sign);
                signNew.start();
            }
        });
        add(button);
    }
}
