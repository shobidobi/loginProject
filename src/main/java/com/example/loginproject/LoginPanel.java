package com.example.loginproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 25/06/2023
 * @author Ariel Dobkin
 * Description: Description: The class represents the login form to the system
 */
public class LoginPanel extends JDialog {
    private JTextField tfUserName;
    private JPasswordField tfPassword;
    private JButton OKButton;
    private JButton cancelButton;
    private JPanel LoginForm;
    private JButton registerButton;


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
                boolean flag=getAuthenticatedUser(userName,password);
                if (flag){
                    dispose();//סגירת הטופס
                    System.out.println("Login successfully");
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
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                setVisible(false);
                NewUser newUser=new NewUser(null);
                newUser.setVisible(true);
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

    /**
     * @param userName The username provided as input in the login form
     * @param password The password provided as input in the login form
     * @return An instance of user type if found otherwise null
     */
    private boolean getAuthenticatedUser(String userName, String password) {
        //user=null;
        Check check=new Check();
        check.tryLogin(userName,password);
        return (check.isValid(userName,password));
    }

    public static void main(String[] args) {
        LoginPanel loginPanel=new LoginPanel(null);


    }
}
