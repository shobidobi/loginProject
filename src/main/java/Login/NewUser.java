package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 27/06/23
 * @author Ariel Dobkin
 * Description: The class represents the registration form for a new user
 */
public class NewUser extends JDialog {
    private JPanel Register;
    private JTextField tfUserName;
    private JPasswordField tfPassword;
    private JButton cancelButton;
    private JButton OKButton;
    public NewUser(JFrame parent){
        super(parent);
        setTitle("LoginForm");
        setContentPane(Register);
        setSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName=tfUserName.getText();
                String password=String.valueOf(tfPassword.getPassword());
                Check check=new Check();
                if(check.newUser(userName,password)){
                    dispose();
                    setVisible(false);
                    /*מעבר בין טפסים */
                    LoginPanel l=new LoginPanel(null);
                    l.setVisible(true);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.out.println("page closed(new user)");
                System.exit(0);
            }
        });
    }
}
