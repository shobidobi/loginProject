package com.example.loginproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginP extends JDialog {
    private JPanel LoginPs;
    private JButton buttonOK;
    private JButton buttonCancel;

    public LoginP(JFrame parent) {
        super(parent);
        setTitle("wrong details");
        setContentPane(LoginPs);
        setSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPanel loginPanel=new LoginPanel(null);
                loginPanel.setVisible(true);
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        LoginP dialog = new LoginP(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
