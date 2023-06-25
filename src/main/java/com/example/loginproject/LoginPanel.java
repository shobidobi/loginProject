package com.example.loginproject;

import entity.UsersEntity;
import jakarta.persistence.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * @version 25/06/2023
 * @author Ariel Dobkin
 */
public class LoginPanel extends JDialog {
    private JTextField tfUserName;
    private JPasswordField tfPassword;
    private JButton OKButton;
    private JButton cancelButton;
    private JPanel LoginForm;


    /**
     * @param parent Constructor initialization of the parent
     */
    public LoginPanel(JFrame parent){
        super(parent);
        setTitle("LoginForm");
        setContentPane(LoginForm);
        setSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName=tfUserName.getText();
                String password=String.valueOf(tfPassword.getPassword());
                user=getAuthenticatedUser(userName,password);
                if (user!=null){
                    dispose();//סגירת הטופס
                }
                else {
                    dispose();
                    setVisible(false);
                    /*מעבר בין טפסים */
                    LoginP l=new LoginP(null);
                    l.setVisible(true);
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.out.println("page closed");
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public UsersEntity user;

    /**
     * @param userName The username provided as input in the login form
     * @param password The password provided as input in the login form
     * @return An instance of user type if found otherwise null
     */
    private UsersEntity getAuthenticatedUser(String userName, String password) {
        user=null;
        Check check=new Check();
        check.isValid(userName,password,user);
        return user;
    }

    public static void main(String[] args) {
        LoginPanel loginPanel=new LoginPanel(null);
        UsersEntity user= loginPanel.user;
        if (user!=null){
            System.out.println("successful");
        }
        else {
            System.out.println("wrong");
        }
    }
}
