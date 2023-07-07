package Login;

import javax.swing.*;
import java.awt.*;

public class loginPanels extends JDialog {
    private JPanel loginForm;
    private JTextField tfUserName;
    private JPasswordField tfPassword;
    private JButton OKButton;
    private JButton cancelButton;

    public loginPanels(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginForm);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        loginPanels panel=new loginPanels(null);
    }
}
