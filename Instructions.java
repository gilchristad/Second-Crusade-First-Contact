import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instructions extends JPanel {
    public boolean continuebool = false;
    private static final long serialVersionUID = 1L;

    public void InstructionsFrame() {
        
        ImageIcon background = new ImageIcon("Images/instructions.jpg");
        JLabel imagelabel = new JLabel(background);
        JButton skip = new JButton();
        imagelabel.setBounds(0,0,1920,1080);
        skip.setBounds(0,0,1920,1080);
        setLayout(null);
        add(imagelabel);
        add(skip);
        skip.setOpaque(false);
        skip.setContentAreaFilled(false);
        skip.setBorderPainted(false);
        skip.setVisible(true);
        skip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                continuebool = true;
            }
        });
    }
    public boolean getContinue(){
        return continuebool;
    }
    public void setContinue(){
        continuebool = false;
    }
}