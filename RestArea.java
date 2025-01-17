import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.*;

public class RestArea extends JPanel{

    private static final long serialVersionUID = 1L;
    Clip restclip;
    boolean returnb = false;
    int TWO_SECONDS = 2000;

    public void RestAreaFrame(int width, int height, Party party) throws IOException {

    	ImageIcon background = new ImageIcon("Images/Backgrounds/restarea.jpg");
        background.setImage(getScaledImage(background.getImage(), width, height));
        
        ImageIcon rest = new ImageIcon("Images/Backgrounds/restarearest.jpg");
        rest.setImage(getScaledImage(rest.getImage(), width, height));

        ImageIcon train = new ImageIcon("Images/Backgrounds/restareatrain.jpg");
        train.setImage(getScaledImage(train.getImage(), width, height));
        
        JButton restb = new JButton();
        JButton trainb = new JButton();
        JLabel bg = new JLabel();
        bg.setIcon(background);
        bg.setBounds(0,0,width, height);
        restb.setBounds((int)(0.094*width),(int)(0.087*height), (int)(0.126*width),(int)(0.092*height));
        trainb.setBounds((int)(0.78*width), (int)(0.087*height),(int)(0.126*width), (int)(0.092*height));

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Themes/REST2.0.wav").getAbsoluteFile());
            restclip = AudioSystem.getClip();
            restclip.open(audioInputStream);
            while(restclip.isRunning()){
                restclip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }   

        setLayout(null);
        add(bg);
        add(restb);
        add(trainb);

        restb.setOpaque(false);
        restb.setContentAreaFilled(false);
        restb.setBorderPainted(false);

        trainb.setOpaque(false);
        trainb.setContentAreaFilled(false);
        trainb.setBorderPainted(false);

        restb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
            	bg.setIcon(rest);
                Timer timer = new Timer(TWO_SECONDS, new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        for (int i = 0; i < 4; i++)
                        {
                        	for (int j = 0; j < 6; j++)
                        	{
                        		party.getParty(i).restoreHealth(j,5);
                        	}
                        }
                    	bg.setIcon(background);
                    	returnb = true;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
        trainb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
            	bg.setIcon(train);
                Timer timer = new Timer(TWO_SECONDS, new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                    	for (int i = 0; i < 4; i++)
                        {
                        	party.getParty(i).attackValue+=5;
                        }
                    	bg.setIcon(background);
                    	returnb = true;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

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