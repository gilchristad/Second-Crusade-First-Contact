import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.*;

public class RestArea extends JPanel{

    private static final long serialVersionUID = 1L;
    boolean returnb = false;

    public void RestAreaFrame(int width, int height) throws IOException {
    
    	 ImageIcon background = new ImageIcon("Images/Backgrounds/restarea.jpg");
         background.setImage(getScaledImage(background.getImage(), width, height));

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
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

}