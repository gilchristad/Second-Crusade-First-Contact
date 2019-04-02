import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JPanel{
    public boolean continuebool = false;
	private static final long serialVersionUID = 1L;
	public void GameOverFrame(int width, int height)
	{
		
		ImageIcon background = new ImageIcon("Images/Backgrounds/gameover.jpg");
        background.setImage(getScaledImage(background.getImage(), width, height));
        JLabel imagelabel = new JLabel(background);
        JButton skip = new JButton();
        imagelabel.setBounds(0,0,width,height);
        skip.setBounds(0,0,width,height);
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
                System.out.println("HERE");
            }
        });
    }
    public boolean getContinue(){
        return continuebool;
    }
    public void setContinue(){
        continuebool = false;
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
