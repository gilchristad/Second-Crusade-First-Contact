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
import java.util.Random;

public class BattleView extends JPanel{

    private static final long serialVersionUID = 1L;
    int c_counter = 0;
    boolean unitSelected = false;
    boolean unitTargeted = false;
    int unitCoordinateX;
    int unitCoordinateY;
    boolean moveSelected = false;
    boolean ability1Selected = false;
    boolean ability2Selected = false;
    boolean ability3Selected = false;
    boolean ability4Selected = false;
    ImageIcon selectsquare = new ImageIcon("Images/Icons/selectedsquare.jpg");
    String unitName;

    Clip battleclip;
    Clip bossclip;
    boolean returnb = false;
    JLabel[] crusaders;
    JLabel[] aliens;
    public void BattleViewFrame(int width, int height, int type, Party party) throws IOException {
        
        ImageIcon background;
        JLabel imagelabel = new JLabel();
        JLabel[][] crusaderSquareLabels = new JLabel[4][4];
        JLabel[][] alienSquareLabels = new JLabel[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                crusaderSquareLabels[i][j] = new JLabel();
                crusaderSquareLabels[i][j].setIcon(selectsquare);
                crusaderSquareLabels[i][j].setVisible(false);
                add(crusaderSquareLabels[i][j]);
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                alienSquareLabels[i][j] = new JLabel();
                alienSquareLabels[i][j].setIcon(selectsquare);
                alienSquareLabels[i][j].setVisible(false);
                add(alienSquareLabels[i][j]);
            }
        }

        crusaderSquareLabels[0][0].setBounds((int)(0.051*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[0][1].setBounds((int)(0.123*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[0][2].setBounds((int)(0.194*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[0][3].setBounds((int)(0.267*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[1][0].setBounds((int)(0.051*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[1][1].setBounds((int)(0.123*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[1][2].setBounds((int)(0.194*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[1][3].setBounds((int)(0.267*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[2][0].setBounds((int)(0.051*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[2][1].setBounds((int)(0.123*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[2][2].setBounds((int)(0.194*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[2][3].setBounds((int)(0.267*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[3][0].setBounds((int)(0.051*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[3][1].setBounds((int)(0.123*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[3][2].setBounds((int)(0.194*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        crusaderSquareLabels[3][3].setBounds((int)(0.267*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[0][0].setBounds((int)(0.667*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[0][1].setBounds((int)(0.739*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[0][2].setBounds((int)(0.810*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[0][3].setBounds((int)(0.882*width),(int)(0.063*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[1][0].setBounds((int)(0.667*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[1][1].setBounds((int)(0.739*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[1][2].setBounds((int)(0.810*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[1][3].setBounds((int)(0.882*width),(int)(0.190*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[2][0].setBounds((int)(0.667*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[2][1].setBounds((int)(0.739*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[2][2].setBounds((int)(0.810*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[2][3].setBounds((int)(0.882*width),(int)(0.318*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[3][0].setBounds((int)(0.667*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[3][1].setBounds((int)(0.739*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[3][2].setBounds((int)(0.810*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));
        alienSquareLabels[3][3].setBounds((int)(0.882*width),(int)(0.446*height),(int)(0.066*width),(int)(0.117*height));

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
        as13.setOpaque(false);
        as13.setContentAreaFilled(false);
        as13.setBorderPainted(false);
        as20.setOpaque(false);
        as20.setContentAreaFilled(false);
        as20.setBorderPainted(false);
        as21.setOpaque(false);
        as21.setContentAreaFilled(false);
        as21.setBorderPainted(false);
        as22.setOpaque(false);
        as22.setContentAreaFilled(false);
        as22.setBorderPainted(false);
        as23.setOpaque(false);
        as23.setContentAreaFilled(false);
        as23.setBorderPainted(false);
        as30.setOpaque(false);
        as30.setContentAreaFilled(false);
        as30.setBorderPainted(false);
        as31.setOpaque(false);
        as31.setContentAreaFilled(false);
        as31.setBorderPainted(false);
        as32.setOpaque(false);
        as32.setContentAreaFilled(false);
        as32.setBorderPainted(false);
        as33.setOpaque(false);
        as33.setContentAreaFilled(false);
        as33.setBorderPainted(false);
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
            System.out.println("BNew battle");
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

        crusaders = new JLabel[16];
        aliens = new JLabel[16];
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
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                        crusaderSquareLabels[i][j].setIcon(selectsquare);
                        crusaderSquareLabels[i][j].setVisible(false);
                    }
                }
                crusaderSquareLabels[0][0].setVisible(true);
                if(unitSelected == false){
                    if(instance.cruBoard.getSquare(0,0).selectSquare() != null){
                        unitSelected = true;
                        unitName = instance.cruBoard.getSquare(0,0).selectSquare().name;
                    }
                    else{
                    }
                }
                else{
                    if(unitTargeted == false){
                        if(instance.cruBoard.getSquare(0,0).selectSquare() != null){
                            unitTargeted = true;
                            unitCoordinateX = 0;
                            unitCoordinateY = 0;
                        }
                    }
                    // if(moveSelected){
                    //     //move unit to this square
                    // }
                }
            }
        });
        cs01.addActionListener(new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[0][1].setVisible(true);
            // for (int i = 0; i < c_counter; i++)
            // {
            //     crusaders[i].setVisible(true);
            // }
                if(unitSelected == false){
                    if(instance.cruBoard.getSquare(0,1).selectSquare() != null){
                        unitSelected = true;
                        unitName = instance.cruBoard.getSquare(0,1).selectSquare().name;
                    }
                    else{
                        //?
                    }
                }
                else{
                    if(unitTargeted == false){
                        if(instance.cruBoard.getSquare(0,1).selectSquare() != null){
                            unitTargeted = true;
                            unitCoordinateX = 0;
                            unitCoordinateY = 1;
                        }
                    }
                    // if(moveSelected){
                    //     //move unit to this square
                    // }
                }
            
           }
       });
        cs02.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[0][2].setVisible(true);
            // for (int i = 0; i < c_counter; i++)
            // {
            //     crusaders[i].setVisible(true);
            // }
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(0,2).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(0,2).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(0,2).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 0;
                        unitCoordinateY = 2;
                    }
                }
                // if(moveSelected){
                //     //move unit to this square
                // }
            }
           }
       });
        cs03.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[0][3].setVisible(true);
            // for (int i = 0; i < c_counter; i++)
            // {
            //     crusaders[i].setVisible(true);
            // }
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(0,3).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(0,3).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(0,3).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 0;
                        unitCoordinateY = 3;
                    }
                }
                // if(moveSelected){
                //     //move unit to this square
                // }
            }
           }
       });
        cs10.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[1][0].setVisible(true);
            // for (int i = 0; i < c_counter; i++)
            // {
            //     crusaders[i].setVisible(true);
            // }
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(1,0).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(1,0).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(1,0).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 1;
                        unitCoordinateY = 0;
                    }
                }
                // if(moveSelected){
                //     //move unit to this square
                // }
            }
           }
       });
        cs11.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[1][1].setVisible(true);
            // for (int i = 0; i < c_counter; i++)
            // {
            //     crusaders[i].setVisible(true);
            // }
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(1,1).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(1,1).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(1,1).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 1;
                        unitCoordinateY = 1;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs12.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[1][2].setVisible(true);
            // for (int i = 0; i < c_counter; i++)
            // {
            //     crusaders[i].setVisible(true);
            // }
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(1,2).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(1,2).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(1,2).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 1;
                        unitCoordinateY = 2;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs13.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[1][3].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(1,3).selectSquare() != null){
                    unitSelected = true;                    
                    unitName = instance.cruBoard.getSquare(1,3).selectSquare().name;

                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(1,3).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 1;
                        unitCoordinateY = 3;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs20.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[2][0].setVisible(true);
            // for (int i = 0; i < c_counter; i++)
            //     {
            //         crusaders[i].setVisible(true);
            // 	}
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(2,0).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(2,0).selectSquare().name;
                }
                else{
                    
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(2,0).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 2;
                        unitCoordinateY = 0;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs21.addActionListener(new ActionListener(){
        
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[2][1].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(2,1).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(2,1).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(2,1).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 2;
                        unitCoordinateY = 1;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs22.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[2][2].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(2,2).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(2,2).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(2,2).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 2;
                        unitCoordinateY = 2;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs23.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[2][3].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(2,3).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(2,3).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(2,3).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 2;
                        unitCoordinateY = 3;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs30.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[3][0].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(3,0).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(3,0).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(3,0).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 3;
                        unitCoordinateY = 0;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs31.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[3][1].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(3,1).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(3,1).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(3,1).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 3;
                        unitCoordinateY = 1;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs32.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[3][2].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(3,2).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(3,2).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(3,2).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 3;
                        unitCoordinateY = 2;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
        cs33.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    crusaderSquareLabels[i][j].setIcon(selectsquare);
                    crusaderSquareLabels[i][j].setVisible(false);
                }
            }
            crusaderSquareLabels[3][3].setVisible(true);
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(3,3).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(3,3).selectSquare().name;
                }
                else{
                }
            }
            else{
                if(unitTargeted == false){
                    if(instance.cruBoard.getSquare(3,3).selectSquare() != null){
                        unitTargeted = true;
                        unitCoordinateX = 3;
                        unitCoordinateY = 3;
                    }
                }
                if(moveSelected){
                    //move unit to this square
                }
            }
           }
       });
       
        as00.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[0][0].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(0,0).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 0;
                    unitCoordinateY = 0;
                }
            }
           }
           
       });
        as01.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[0][1].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(0,1).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 0;
                    unitCoordinateY = 1;
                }
            }
           }
       });
        as02.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[0][2].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(0,2).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 0;
                    unitCoordinateY = 0;
                }
            }
           }
       });
        as03.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[0][3].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(0,3).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 0;
                    unitCoordinateY = 3;
                }
            }
           }
       });
        as10.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[1][0].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(1,0).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 1;
                    unitCoordinateY = 0;
                }
            }
           }
       });
        as11.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[1][1].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(1,1).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 1;
                    unitCoordinateY = 1;
                }
            }
           }
       });
        as12.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[1][2].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(1,2).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 1;
                    unitCoordinateY = 2;
                }
            }
           }
       });
        as13.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[1][3].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(1,3).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 1;
                    unitCoordinateY = 3;
                }
            }
           }
       });
        as20.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[2][0].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(2,0).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 2;
                    unitCoordinateY = 0;
                }
            }
           }
       });
        as21.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[2][1].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(2,1).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 2;
                    unitCoordinateY = 1;
                }
            }
           }
       });
        as22.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[2][2].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(2,2).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 2;
                    unitCoordinateY = 2;
                }
            }
           }
       });
        as23.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[2][3].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(2,3).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 2;
                    unitCoordinateY = 3;
                }
            }
           }
       });
        as30.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[3][0].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(3,0).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 3;
                    unitCoordinateY = 0;
                }
            }
           }
       });
        as31.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[3][1].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(3,1).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 3;
                    unitCoordinateY = 1;
                }
            }
           }
       });
        as32.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[3][2].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(3,2).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 3;
                    unitCoordinateY = 2;
                }
            }
           }
       });
        as33.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    alienSquareLabels[i][j].setIcon(selectsquare);
                    alienSquareLabels[i][j].setVisible(false);
                }
            }
            alienSquareLabels[3][3].setVisible(true);
            if(unitTargeted == false){
                if(instance.alienBoard.getSquare(3,3).selectSquare() != null){
                    unitTargeted = true;
                    unitCoordinateX = 3;
                    unitCoordinateY = 3;
                }
            }
           }
       });
       
        ability1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
               System.out.println(unitName);
                if(unitSelected){
                    if(unitName == "cleric"){
                        party.getParty(1).heal(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                    }
                    else if(unitName == "archer"){
                        party.getParty(2).snipe(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                    }
                    else if(unitName == "swordandshield"){
                        party.getParty(0).sashiltdBash(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                    }
                    else if(unitName == "swordsman"){
                        party.getParty(3).swordsmanslash(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                    }
                }
           }
       });
        ability2.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            System.out.println(unitName);
            if(unitSelected){
                if(unitName == "cleric"){
                    party.getParty(1).clericslash(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "archer"){
                    party.getParty(2).shoot(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "swordandshield"){
                    party.getParty(0).slash(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "swordsman"){
                    party.getParty(3).hiltdBash(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
            }
           }
       });
        ability3.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            System.out.println(unitName);
            if(unitSelected){
                if(unitName == "cleric"){
                    party.getParty(1).clericblock(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "archer"){
                    party.getParty(2).block(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "swordandshield"){
                    party.getParty(0).sasblock(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "swordsman"){
                    party.getParty(3).swordsmanblock(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
            }
           }
       });
        ability4.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            System.out.println(unitName);
            if(unitSelected){
                if(unitName == "cleric"){
                    party.getParty(1).holy_light(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "archer"){
                    party.getParty(2).rain(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "swordandshield"){
                    party.getParty(0).sasslice(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
                else if(unitName == "swordsman"){
                    party.getParty(3).slice(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                }
            }
           }
       });

        move.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){

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