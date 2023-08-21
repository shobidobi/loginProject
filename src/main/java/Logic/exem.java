package Logic;

import javax.swing.*;
import java.awt.*;

public class exem extends JDialog {
    private JPanel panel1;
    private JButton deckButton;
    private JButton button1;

    public exem(JFrame parent){
        super(parent);
        ImageIcon icon=new ImageIcon("images/deckImage.jpg");
        deckButton.setIcon(icon);
    }
}
