package Front;

import Login.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_screen extends JDialog{

    private JButton loginButton;
    private JPanel Start;
    public main_screen(JFrame parent){
        super();
        setTitle("Start");
        setContentPane(Start);
        setSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                LoginPanel loginPanel=new LoginPanel(null);
                loginPanel.setVisible(true);
            }
        });
        setVisible(true);
    }
}
