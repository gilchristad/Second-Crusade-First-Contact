
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



// WHEN SQUARE IS SELECTED, MUST DESELECT ALL OTHER SQUARES; DESELECT METHOD?? Do we even select squares? not really just have a "selected" value with square location or something
public class BattleView extends JPanel{

    private static final long serialVersionUID = 1L;

    Clip battleclip;
    boolean returnb = false;

    public void BattleViewFrame(int width, int height, int type) throws IOException {
        
        ImageIcon background = new ImageIcon("Images/Backgrounds/dungeon1.jpg");
        background.setImage(getScaledImage(background.getImage(), width, height));

        ImageIcon crusader = new ImageIcon("");
        crusader.setImage(getScaledImage(crusader.getImage(), width, height));

        ImageIcon archer = new ImageIcon("");
        archer.setImage(getScaledImage(archer.getImage(), width, height));

        ImageIcon cleric = new ImageIcon("");
        cleric.setImage(getScaledImage(cleric.getImage(), width, height));

        ImageIcon axeboy = new ImageIcon("");        
        axeboy.setImage(getScaledImage(axeboy.getImage(), width, height));

        ImageIcon alien1 = new ImageIcon("");        
        alien1.setImage(getScaledImage(alien1.getImage(), width, height));

        ImageIcon alien2 = new ImageIcon("");        
        alien2.setImage(getScaledImage(alien2.getImage(), width, height));

        ImageIcon alien3 = new ImageIcon("");        
        alien3.setImage(getScaledImage(alien3.getImage(), width, height));

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

        JLabel bg = new JLabel();
        JLabel c1 = new JLabel();
        JLabel c2 = new JLabel();
        JLabel c3 = new JLabel();
        JLabel c4 = new JLabel();
        JLabel a1 = new JLabel();
        JLabel a2 = new JLabel();
        JLabel a3 = new JLabel();
        JLabel a4 = new JLabel();

        bg.setIcon(background);
        c1.setIcon(crusader);
        c2.setIcon(archer);
        c3.setIcon(cleric);
        c4.setIcon(axeboy);
        a1.setIcon(alien1);
        a2.setIcon(alien2);
        a3.setIcon(alien3);
        a4.setIcon(alien3);

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
        JButton coward = new JButton();

        bg.setBounds(0,0,width,height);

        setLayout(null);
        add(bg);
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
        add(coward);

        cs00.setOpaque(false);
        cs00.setContentAreaFilled(false);
        cs00.setBorderPainted(false);
        cs00.setVisible(true);

        cs01.setOpaque(false);
        cs01.setContentAreaFilled(false);
        cs01.setBorderPainted(false);
        cs01.setVisible(true);

        cs02.setOpaque(false);
        cs02.setContentAreaFilled(false);
        cs02.setBorderPainted(false);
        cs02.setVisible(true);

        cs03.setOpaque(false);
        cs03.setContentAreaFilled(false);
        cs03.setBorderPainted(false);
        cs03.setVisible(true);

        cs10.setOpaque(false);
        cs10.setContentAreaFilled(false);
        cs10.setBorderPainted(false);
        cs10.setVisible(true);

        cs11.setOpaque(false);
        cs11.setContentAreaFilled(false);
        cs11.setBorderPainted(false);
        cs11.setVisible(true);

        cs12.setOpaque(false);
        cs12.setContentAreaFilled(false);
        cs12.setBorderPainted(false);
        cs12.setVisible(true);

        cs13.setOpaque(false);
        cs13.setContentAreaFilled(false);
        cs13.setBorderPainted(false);
        cs13.setVisible(true);

        cs20.setOpaque(false);
        cs20.setContentAreaFilled(false);
        cs20.setBorderPainted(false);
        cs20.setVisible(true);

        cs21.setOpaque(false);
        cs21.setContentAreaFilled(false);
        cs21.setBorderPainted(false);
        cs21.setVisible(true);

        cs22.setOpaque(false);
        cs22.setContentAreaFilled(false);
        cs22.setBorderPainted(false);
        cs22.setVisible(true);

        cs23.setOpaque(false);
        cs23.setContentAreaFilled(false);
        cs23.setBorderPainted(false);
        cs23.setVisible(true);

        cs30.setOpaque(false);
        cs30.setContentAreaFilled(false);
        cs30.setBorderPainted(false);
        cs30.setVisible(true);

        cs31.setOpaque(false);
        cs31.setContentAreaFilled(false);
        cs31.setBorderPainted(false);
        cs31.setVisible(true);

        cs32.setOpaque(false);
        cs32.setContentAreaFilled(false);
        cs32.setBorderPainted(false);
        cs32.setVisible(true);

        cs33.setOpaque(false);
        cs33.setContentAreaFilled(false);
        cs33.setBorderPainted(false);
        cs33.setVisible(true);

        as00.setOpaque(false);
        as00.setContentAreaFilled(false);
        as00.setBorderPainted(false);
        as00.setVisible(true);

        as01.setOpaque(false);
        as01.setContentAreaFilled(false);
        as01.setBorderPainted(false);
        as01.setVisible(true);

        as02.setOpaque(false);
        as02.setContentAreaFilled(false);
        as02.setBorderPainted(false);
        as02.setVisible(true);

        as03.setOpaque(false);
        as03.setContentAreaFilled(false);
        as03.setBorderPainted(false);
        as03.setVisible(true);

        as10.setOpaque(false);
        as10.setContentAreaFilled(false);
        as10.setBorderPainted(false);
        as10.setVisible(true);

        as11.setOpaque(false);
        as11.setContentAreaFilled(false);
        as11.setBorderPainted(false);
        as11.setVisible(true);

        as12.setOpaque(false);
        as12.setContentAreaFilled(false);
        as12.setBorderPainted(false);
        as12.setVisible(true);


        ImageIcon hi = new ImageIcon("Images/Icons/axeboy.png");

        JLabel imagelabel = new JLabel();
        //JLabel test = new JLabel();

        imagelabel.setIcon(background);
        //test.setIcon(hi);
        
        //test.setVisible(true);

        imagelabel.setBounds(0,0,width,height);
        //test.setBounds(0,0,111,116);
        battle instance;
        
        if (type == 1)
        {
        	instance = new battle(1);
        }
        else
        {
        	instance = new battle(2);
        }
        JLabel[] crusaders = new JLabel[16];
        JLabel[] aliens = new JLabel[16];
        
        setLayout(null);

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

//        JButton ability1 = new JButton();
//        JButton ability2 = new JButton();
//        JButton ability3 = new JButton();
//        JButton ability4 = new JButton();
//        JButton coward = new JButton();
//        ImageIcon crusader1 = new ImageIcon(""); - //(j * 100)%/
//        ImageIcon crusader2 = new ImageIcon("");aliens[a_counter].setBounds((int)(width*(0.88)) - (int)(j * (0.069 * width)),
//        ImageIcon crusader3 = new ImageIcon("");
//        ImageIcon crusader4 = new ImageIcon("");(j * (instance.alienBoard.getSquare(i, j).selectSquare().image.getIconWidth() + 20 + j))
//        ImageIcon alien1 = new ImageIcon("");
//        ImageIcon alien2 = new ImageIcon("");
//        ImageIcon alien3 = new ImageIcon("");
//        ImageIcon alien4 = new ImageIcon("");
//
//        JButton cs00 = new JButton();
//        JButton cs01 = new JButton();
//        JButton cs02 = new JButton();
//        JButton cs03 = new JButton();
//        JButton cs10 = new JButton();
//        JButton cs11 = new JButton();
//        JButton cs12 = new JButton();
//        JButton cs13 = new JButton();
//        JButton cs20 = new JButton();
//        JButton cs21 = new JButton();
//        JButton cs22 = new JButton();
//        JButton cs23 = new JButton();
//        JButton cs30 = new JButton();
//        JButton cs31 = new JButton();
//        JButton cs32 = new JButton();
//        JButton cs33 = new JButton();
//        JButton as00 = new JButton();
//        JButton as01 = new JButton();
//        JButton as02 = new JButton();
//        JButton as03 = new JButton();
//        JButton as10 = new JButton();
//        JButton as11 = new JButton();
//        JButton as12 = new JButton();
//        JButton as13 = new JButton();
//        JButton as20 = new JButton();
//        JButton as21 = new JButton();
//        JButton as22 = new JButton();
//        JButton as23 = new JButton();
//        JButton as30 = new JButton();
//        JButton as31 = new JButton();
//        JButton as32 = new JButton();
//        JButton as33 = new JButton();
//        JButton ability1 = new JButton();
//        JButton ability2 = new JButton();
//        JButton ability3 = new JButton();
//        JButton ability4 = new JButton();
//        JButton coward = new JButton();
//
//        add(cs00);
//        add(cs01);
//        add(cs02);
//        add(cs03);
//        add(cs10);
//        add(cs11);
//        add(cs12);
//        add(cs13);
//        add(cs20);
//        add(cs21);
//        add(cs22);
//        add(cs23);
//        add(cs30);
//        add(cs31);
//        add(cs32);
//        add(cs33);
//        add(as00);
//        add(as01);
//        add(as02);
//        add(as03);
//        add(as10);
//        add(as11);
//        add(as12);
//        add(as13);
//        add(as20);
//        add(as21);
//        add(as22);
//        add(as23);
//        add(as30);
//        add(as31);
//        add(as32);
//        add(as33);
//        add(ability1);
//        add(ability2);
//        add(ability3);
//        add(ability4);
//        add(coward);
//
//        cs00.setOpaque(false);
//        cs00.setContentAreaFilled(false);
//        cs00.setBorderPainted(false);
//        cs00.setVisible(true);
//
//        cs01.setOpaque(false);
//        cs01.setContentAreaFilled(false);
//        cs01.setBorderPainted(false);
//        cs01.setVisible(true);
//
//        cs02.setOpaque(false);
//        cs02.setContentAreaFilled(false);
//        cs02.setBorderPainted(false);
//        cs02.setVisible(true);
//
//        cs03.setOpaque(false);
//        cs03.setContentAreaFilled(false);
//        cs03.setBorderPainted(false);
//        cs03.setVisible(true);
//
//        cs10.setOpaque(false);
//        cs10.setContentAreaFilled(false);
//        cs10.setBorderPainted(false);
//        cs10.setVisible(true);
//
//        cs11.setOpaque(false);
//        cs11.setContentAreaFilled(false);
//        cs11.setBorderPainted(false);
//        cs11.setVisible(true);
//
//        cs12.setOpaque(false);
//        cs12.setContentAreaFilled(false);
//        cs12.setBorderPainted(false);
//        cs12.setVisible(true);
//
//        cs13.setOpaque(false);
//        cs13.setContentAreaFilled(false);
//        cs13.setBorderPainted(false);
//        cs13.setVisible(true);
//
//        cs20.setOpaque(false);
//        cs20.setContentAreaFilled(false);
//        cs20.setBorderPainted(false);
//        cs20.setVisible(true);
//
//        cs21.setOpaque(false);
//        cs21.setContentAreaFilled(false);
//        cs21.setBorderPainted(false);
//        cs21.setVisible(true);
//
//        cs22.setOpaque(false);
//        cs22.setContentAreaFilled(false);
//        cs22.setBorderPainted(false);
//        cs22.setVisible(true);
//
//        cs23.setOpaque(false);
//        cs23.setContentAreaFilled(false);
//        cs23.setBorderPainted(false);
//        cs23.setVisible(true);
//
//        cs30.setOpaque(false);
//        cs30.setContentAreaFilled(false);
//        cs30.setBorderPainted(false);
//        cs30.setVisible(true);
//
//        cs31.setOpaque(false);
//        cs31.setContentAreaFilled(false);
//        cs31.setBorderPainted(false);
//        cs31.setVisible(true);
//
//        cs32.setOpaque(false);
//        cs32.setContentAreaFilled(false);
//        cs32.setBorderPainted(false);
//        cs32.setVisible(true);
//
//        cs33.setOpaque(false);
//        cs33.setContentAreaFilled(false);
//        cs33.setBorderPainted(false);
//        cs33.setVisible(true);
//
//        as00.setOpaque(false);
//        as00.setContentAreaFilled(false);
//        as00.setBorderPainted(false);
//        as00.setVisible(true);
//
//        as01.setOpaque(false);
//        as01.setContentAreaFilled(false);
//        as01.setBorderPainted(false);
//        as01.setVisible(true);
//
//        as02.setOpaque(false);
//        as02.setContentAreaFilled(false);
//        as02.setBorderPainted(false);
//        as02.setVisible(true);
//
//        as03.setOpaque(false);
//        as03.setContentAreaFilled(false);
//        as03.setBorderPainted(false);
//        as03.setVisible(true);
//
//        as10.setOpaque(false);
//        as10.setContentAreaFilled(false);
//        as10.setBorderPainted(false);
//        as10.setVisible(true);
//
//        as11.setOpaque(false);
//        as11.setContentAreaFilled(false);
//        as11.setBorderPainted(false);
//        as11.setVisible(true);
//
//        as12.setOpaque(false);
//        as12.setContentAreaFilled(false);
//        as12.setBorderPainted(false);
//        as12.setVisible(true);
//
//        as13.setOpaque(false);
//        as13.setContentAreaFilled(false);
//        as13.setBorderPainted(false);
//        as13.setVisible(true);
//
//        as20.setOpaque(false);
//        as20.setContentAreaFilled(false);
//        as20.setBorderPainted(false);
//        as20.setVisible(true);
//
//        as21.setOpaque(false);
//        as21.setContentAreaFilled(false);
//        as21.setBorderPainted(false);
//        as21.setVisible(true);
//
//        as22.setOpaque(false);
//        as22.setContentAreaFilled(false);
//        as22.setBorderPainted(false);
//        as22.setVisible(true);
//
//        as23.setOpaque(false);
//        as23.setContentAreaFilled(false);
//        as23.setBorderPainted(false);
//        as23.setVisible(true);
//
//        as30.setOpaque(false);
//        as30.setContentAreaFilled(false);
//        as30.setBorderPainted(false);
//        as30.setVisible(true);
//
//        as31.setOpaque(false);
//        as31.setContentAreaFilled(false);
//        as31.setBorderPainted(false);
//        as31.setVisible(true);
//
//        as32.setOpaque(false);
//        as32.setContentAreaFilled(false);
//        as32.setBorderPainted(false);
//        as32.setVisible(true);
//
//        as33.setOpaque(false);
//        as33.setContentAreaFilled(false);
//        as33.setBorderPainted(false);
//        as33.setVisible(true);
//
//        ability1.setOpaque(false);
//        ability1.setContentAreaFilled(false);
//        ability1.setBorderPainted(false);
//        ability1.setVisible(true);
//
//        ability2.setOpaque(false);
//        ability2.setContentAreaFilled(false);
//        ability2.setBorderPainted(false);
//        ability2.setVisible(true);
//
//        ability3.setOpaque(false);
//        ability3.setContentAreaFilled(false);
//        ability3.setBorderPainted(false);
//        ability3.setVisible(true);
//
//        ability4.setOpaque(false);
//        ability4.setContentAreaFilled(false);
//        ability4.setBorderPainted(false);
//        ability4.setVisible(true);
//
//        coward.setOpaque(false);
//        coward.setContentAreaFilled(false);
//        coward.setBorderPainted(false);
//        coward.setVisible(true);
//
//
//
//        cs00.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs01.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs02.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs03.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs10.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs11.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs12.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs13.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs20.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs21.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs22.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs23.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs30.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs31.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs32.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        cs33.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        
//        as00.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as01.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as02.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as03.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as10.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as11.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as12.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as13.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as20.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as21.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as22.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as23.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as30.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as31.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as32.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        as33.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//        ability1.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//
//        ability2.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//
//        ability3.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//
//        ability4.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//
//            }
//        });
//
//        coward.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent arg0){
//                returnb = true;
//            }
//        });

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
