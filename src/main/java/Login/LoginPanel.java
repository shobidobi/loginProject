package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

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
                login flag=getAuthenticatedUser(userName,password);
                if (flag==login.Login_successfully){
                    dispose();//סגירת הטופס
                    System.out.println("Login successfully");
                }
                else if (flag==login.password_not_valid){
                    JLabel label=new JLabel("One of the details is incorrect");
                    label.setFont(new Font("Arial", Font.BOLD,40));
                    JOptionPane.showMessageDialog(null,label);
                }
                else {
                    JLabel label=new JLabel("The user does not exist in the system");
                    label.setFont(new Font("Arial", Font.BOLD,40));
                    JOptionPane.showMessageDialog(null,label);
                }
                dispose();
                setVisible(false);
                    /*מעבר בין טפסים */
//                    LoginP l=new LoginP(null);
//                    l.setVisible(true);
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
     * @return An enum value describing the connection problems or its success.
     */
    private login getAuthenticatedUser(String userName, String password) {
        //user=null;
        Check check=new Check();
        check.tryLogin(userName,password);
        login Authenticate=(check.isValid(userName,password));
        return Authenticate;
    }

    public static void main(String[] args) {
        LoginPanel loginPanel=new LoginPanel(null);


    }
}
