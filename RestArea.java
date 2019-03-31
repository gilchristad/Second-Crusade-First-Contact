import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.*;

public class RestArea extends JPanel{

    private static final long serialVersionUID = 1L;
    boolean returnb = false;

    public void RestAreaFrame() throws IOException {
    
        ImageIcon background = new ImageIcon("Images/Backgrounds/restarea.jpg");
        JButton restb = new JButton();
        JButton trainb = new JButton();
        JLabel bg = new JLabel();
        bg.setIcon(background);
        add(bg);
        add(restb);
        add(trainb);
    }

    public boolean getReturn(){
        return returnb;
    }

    public void setReturn(){
        returnb = false;
    }

}