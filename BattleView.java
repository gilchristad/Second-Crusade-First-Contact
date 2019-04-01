
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.*;
import java.awt.*;

public class BattleView extends JPanel{

    private static final long serialVersionUID = 1L;

    Clip battleclip;
    Clip bossclip;
    boolean returnb = false;

    public void BattleViewFrame(int width, int height, int type, Party party) throws IOException {
        
        ImageIcon background;
        JLabel imagelabel = new JLabel();

        JButton cs00 = new JButton();
        JButton cs01 = new JButton();
        JButton cs02 = new JButton();
        JButton cs03 = new JButton();
        JButton cs10 = new JButton();
        JButton cs11 = new JButton();
        JButton cs12 = new JButton();
        JButton cs13 = new JButton();
        JButton cs20 = new JButton();
        JButton cs21 = new JButton();
        JButton cs22 = new JButton();
        JButton cs23 = new JButton();
        JButton cs30 = new JButton();
        JButton cs31 = new JButton();
        JButton cs32 = new JButton();
        JButton cs33 = new JButton();
        JButton as00 = new JButton();
        JButton as01 = new JButton();
        JButton as02 = new JButton();
        JButton as03 = new JButton();
        JButton as10 = new JButton();
        JButton as11 = new JButton();
        JButton as12 = new JButton();
        JButton as13 = new JButton();
        JButton as20 = new JButton();
        JButton as21 = new JButton();
        JButton as22 = new JButton();
        JButton as23 = new JButton();
        JButton as30 = new JButton();
        JButton as31 = new JButton();
        JButton as32 = new JButton();
        JButton as33 = new JButton();
        JButton ability1 = new JButton();
        JButton ability2 = new JButton();
        JButton ability3 = new JButton();
        JButton ability4 = new JButton();
        JButton move = new JButton();
        JButton coward = new JButton();
        
        setLayout(null);

        cs00.setBounds((int)(0.051*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        cs01.setBounds((int)(0.123*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        cs02.setBounds((int)(0.194*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        cs03.setBounds((int)(0.267*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        cs10.setBounds((int)(0.051*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        cs11.setBounds((int)(0.123*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        cs12.setBounds((int)(0.194*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        cs13.setBounds((int)(0.267*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        cs20.setBounds((int)(0.051*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        cs21.setBounds((int)(0.123*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        cs22.setBounds((int)(0.194*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        cs23.setBounds((int)(0.267*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        cs30.setBounds((int)(0.051*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        cs31.setBounds((int)(0.123*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        cs32.setBounds((int)(0.194*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        cs33.setBounds((int)(0.267*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        as00.setBounds((int)(0.667*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        as01.setBounds((int)(0.739*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        as02.setBounds((int)(0.810*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        as03.setBounds((int)(0.882*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        as10.setBounds((int)(0.667*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        as11.setBounds((int)(0.739*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        as12.setBounds((int)(0.810*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        as13.setBounds((int)(0.882*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        as20.setBounds((int)(0.667*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        as21.setBounds((int)(0.739*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        as22.setBounds((int)(0.810*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        as23.setBounds((int)(0.882*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        as30.setBounds((int)(0.667*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        as31.setBounds((int)(0.739*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        as32.setBounds((int)(0.810*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        as33.setBounds((int)(0.882*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        ability1.setBounds((int)(0.018*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));        
        ability2.setBounds((int)(0.113*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));
        ability3.setBounds((int)(0.208*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));
        ability4.setBounds((int)(0.298*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));
        move.setBounds((int)(0.018*width),(int)(0.883*height),(int)(0.154*width),(int)(0.077*height));
        coward.setBounds((int)(0.208*width),(int)(0.883*height),(int)(0.154*width),(int)(0.077*height));

        cs00.setOpaque(false);
        cs00.setContentAreaFilled(false);
        cs00.setBorderPainted(false);

        cs01.setOpaque(false);
        cs01.setContentAreaFilled(false);
        cs01.setBorderPainted(false);

        cs02.setOpaque(false);
        cs02.setContentAreaFilled(false);
        cs02.setBorderPainted(false);

        cs03.setOpaque(false);
        cs03.setContentAreaFilled(false);
        cs03.setBorderPainted(false);

        cs10.setOpaque(false);
        cs10.setContentAreaFilled(false);
        cs10.setBorderPainted(false);

        cs11.setOpaque(false);
        cs11.setContentAreaFilled(false);
        cs11.setBorderPainted(false);

        cs12.setOpaque(false);
        cs12.setContentAreaFilled(false);
        cs12.setBorderPainted(false);

        cs13.setOpaque(false);
        cs13.setContentAreaFilled(false);
        cs13.setBorderPainted(false);

        cs20.setOpaque(false);
        cs20.setContentAreaFilled(false);
        cs20.setBorderPainted(false);

        cs21.setOpaque(false);
        cs21.setContentAreaFilled(false);
        cs21.setBorderPainted(false);

        cs22.setOpaque(false);
        cs22.setContentAreaFilled(false);
        cs22.setBorderPainted(false);

        cs23.setOpaque(false);
        cs23.setContentAreaFilled(false);
        cs23.setBorderPainted(false);

        cs30.setOpaque(false);
        cs30.setContentAreaFilled(false);
        cs30.setBorderPainted(false);

        cs31.setOpaque(false);
        cs31.setContentAreaFilled(false);
        cs31.setBorderPainted(false);

        cs32.setOpaque(false);
        cs32.setContentAreaFilled(false);
        cs32.setBorderPainted(false);

        cs33.setOpaque(false);
        cs33.setContentAreaFilled(false);
        cs33.setBorderPainted(false);

        as00.setOpaque(false);
        as00.setContentAreaFilled(false);
        as00.setBorderPainted(false);

        as01.setOpaque(false);
        as01.setContentAreaFilled(false);
        as01.setBorderPainted(false);

        as02.setOpaque(false);
        as02.setContentAreaFilled(false);
        as02.setBorderPainted(false);

        as03.setOpaque(false);
        as03.setContentAreaFilled(false);
        as03.setBorderPainted(false);

        as10.setOpaque(false);
        as10.setContentAreaFilled(false);
        as10.setBorderPainted(false);

        as11.setOpaque(false);
        as11.setContentAreaFilled(false);
        as11.setBorderPainted(false);

        as12.setOpaque(false);
        as12.setContentAreaFilled(false);
        as12.setBorderPainted(false);

        ability1.setOpaque(false);
        ability1.setContentAreaFilled(false);
        ability1.setBorderPainted(false);
        
        ability2.setOpaque(false);
        ability2.setContentAreaFilled(false);
        ability2.setBorderPainted(false);


        ability3.setOpaque(false);
        ability3.setContentAreaFilled(false);
        ability3.setBorderPainted(false);

        ability4.setOpaque(false);
        ability4.setContentAreaFilled(false);
        ability4.setBorderPainted(false);

        move.setOpaque(false);
        move.setContentAreaFilled(false);
        move.setBorderPainted(false);

        coward.setOpaque(false);
        coward.setContentAreaFilled(false);
        coward.setBorderPainted(false);

        imagelabel.setBounds(0,0,width,height);
        battle instance;
        
        if (type == 1)
        {
        	background = new ImageIcon("Images/Backgrounds/dungeon1.jpg");
            background.setImage(getScaledImage(background.getImage(), width, height));


            instance = new battle(1,party);
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Themes/BATTLE1.0.wav").getAbsoluteFile());
                battleclip = AudioSystem.getClip();
                battleclip.open(audioInputStream);
                while(battleclip.isRunning()){
                    battleclip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } catch(Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }   
        }
        else
        {
        	background = new ImageIcon("Images/Backgrounds/boss.jpg");
            background.setImage(getScaledImage(background.getImage(), width, height));
            instance = new battle(2,party);
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Themes/BOSS1.0.wav").getAbsoluteFile());
                bossclip = AudioSystem.getClip();
                bossclip.open(audioInputStream);
                while(bossclip.isRunning()){
                    bossclip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } catch(Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }   
        }

        imagelabel.setIcon(background);

        JLabel[] crusaders = new JLabel[16];
        JLabel[] aliens = new JLabel[16];
        
        int c_counter = 0;
        int a_counter = 0;
        for (int i = 0; i < 4; i++)
        {
        	for (int j = 0; j < 4; j++)
            {
            	if (instance.cruBoard.getSquare(i, j).selectSquare() != null)
            	{
            		crusaders[c_counter] = new JLabel();
            		crusaders[c_counter].setIcon(instance.cruBoard.getSquare(i, j).selectSquare().image);
            		crusaders[c_counter].setVisible(true);
            		crusaders[c_counter].setBounds((int)(0.0535 * width) + (int)(j * (float)(width/1440)) + (int)(j * (0.073 * width)), 
            				(int)(0.075 * height)+ (int)(i * (0.13 * height)), 
            				instance.cruBoard.getSquare(i, j).selectSquare().image.getIconWidth(),
            				instance.cruBoard.getSquare(i, j).selectSquare().image.getIconHeight());
            		add(crusaders[c_counter]);
            		c_counter++;
            	}
            }
        }
        // 188 x 212
        for (int i = 0; i < 4; i++)
        {
        	for (int j = 0; j < 4; j++)
            {
            	if (instance.alienBoard.getSquare(i, j).selectSquare() != null)
            	{
            		aliens[a_counter] = new JLabel();
            		aliens[a_counter].setIcon(instance.alienBoard.getSquare(i, j).selectSquare().image);
            		aliens[a_counter].setVisible(true);
            		aliens[a_counter].setBounds((int)(width*(0.675))+ (int)(j * (float)(width/1440)) + (int)(j * (0.07 * width)), 
            				(int)(0.075 * height)+ (int)(i * (0.13 * height)), 
            				instance.alienBoard.getSquare(i, j).selectSquare().image.getIconWidth(),
            				instance.alienBoard.getSquare(i, j).selectSquare().image.getIconHeight());
            		add(aliens[a_counter]);
            		System.out.println(a_counter + ": " + instance.alienBoard.getSquare(i, j).selectSquare().name);
            		a_counter++;
            	}
            }
        }
        
        add(imagelabel);
        add(cs00);
        add(cs01);
        add(cs02);
        add(cs03);
        add(cs10);
        add(cs11);
        add(cs12);
        add(cs13);
        add(cs20);
        add(cs21);
        add(cs22);
        add(cs23);
        add(cs30);
        add(cs31);
        add(cs32);
        add(cs33);
        add(as00);
        add(as01);
        add(as02);
        add(as03);
        add(as10);
        add(as11);
        add(as12);
        add(as13);
        add(as20);
        add(as21);
        add(as22);
        add(as23);
        add(as30);
        add(as31);
        add(as32);
        add(as33);
        add(ability1);
        add(ability2);
        add(ability3);
        add(ability4);
        add(move);
        add(coward);


       cs00.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs01.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs02.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs03.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs10.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs11.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs12.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs13.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs20.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs21.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs22.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs23.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs30.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs31.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs32.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       cs33.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       
       as00.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as01.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as02.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as03.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as10.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as11.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as12.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as13.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as20.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as21.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as22.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as23.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as30.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as31.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as32.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       as33.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });
       ability1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });

       ability2.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });

       ability3.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });

       ability4.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){

           }
       });

       move.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                returnb = true;
            }
        });


       coward.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
               returnb = true;
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
