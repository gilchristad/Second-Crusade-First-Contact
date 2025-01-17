import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.*;
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
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width2 = (int)screenSize.getWidth();
    int height2 =  (int)screenSize.getHeight();
    int c_counter = 0;
    int a_counter = 0;
    boolean unitSelected = false;
    boolean unitTargeted = false;
    int victoryCount=0;
    int unitCoordinateX;
    int unitCoordinateY;
    boolean moveSelected = false;
    boolean ability1Selected = false;
    boolean ability2Selected = false;
    boolean ability3Selected = false;
    boolean ability4Selected = false;
    JLabel ability1icon = new JLabel();
    JLabel ability2icon = new JLabel();
    JLabel ability3icon = new JLabel();
    JLabel ability4icon = new JLabel();
    boolean defeat=false;
    boolean totalVictory=false;
    int result;
    ImageIcon selectsquare = new ImageIcon("Images/Icons/selectedsquare.jpg");
    ImageIcon healicon = new ImageIcon("Images/Icons/heal.png");
    ImageIcon blockicon = new ImageIcon("Images/Icons/block.png");
    ImageIcon holyicon = new ImageIcon("Images/Icons/holylight.png");
    ImageIcon rainicon = new ImageIcon("Images/Icons/rain.png");
    ImageIcon shooticon = new ImageIcon("Images/Icons/shoot.png");
    ImageIcon slashicon = new ImageIcon("Images/Icons/slash.png");
    ImageIcon sliceicon = new ImageIcon("Images/Icons/slice.png");
    ImageIcon snipeicon = new ImageIcon("Images/Icons/snipe.png");
    ImageIcon hilticon = new ImageIcon("Images/Icons/hiltbash.png");
    String unitName;
    battle instance;
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
        
        JLabel[] stats = new JLabel[6];
        
        JLabel gametext = new JLabel("<html>Text color: <font color='red'>red</font></html>",JLabel.CENTER);
        gametext.setForeground(Color.RED);
        gametext.setFont(new Font("Georgia", Font.PLAIN, 14));
        gametext.setText("");
        
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
        JButton confirm = new JButton();
        JButton cancel = new JButton();



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
        confirm.setBounds((int)(0.421*width),(int)(0.851*height),(int)(0.156*width),(int)(0.0648*height));
        cancel.setBounds((int)(0.421*width),(int)(0.930*height),(int)(0.156*width),(int)(0.060*height));

        ability1icon.setBounds((int)(0.025*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));        
        ability2icon.setBounds((int)(0.12*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));
        ability3icon.setBounds((int)(0.22*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));
        ability4icon.setBounds((int)(0.3*width),(int)(0.737*height),(int)(0.064*width),(int)(0.114*height));

        gametext.setBounds((int)(0.403*width),(int)(0.055*height),(int)(0.192*width),(int)(0.779*height));
        gametext.setOpaque(false);
        gametext.setVisible(true);
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
        confirm.setOpaque(false);
        confirm.setContentAreaFilled(false);
        confirm.setBorderPainted(false);
        cancel.setOpaque(false);
        cancel.setContentAreaFilled(false);
        cancel.setBorderPainted(false);

        imagelabel.setBounds(0,0,width,height);
        
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
        for (int i = 0; i < 3; i++)
        {
        	stats[i] = new JLabel();
        	stats[i].setBounds(3*(width/4) - (int)(0.035 * width), 3*(height/4) - (int)(0.044 * height) + (i * (int)(0.072*height)), (int)(0.0694 * width), (int)(0.0444 * height));
        	stats[i].setOpaque(false);
        	stats[i].setVisible(true);
        	stats[i].setForeground(Color.WHITE);
        	stats[i].setFont(new Font("Georgia", Font.PLAIN, 10));
        	add(stats[i]);
        }
        for (int i = 3; i < 6; i ++)
        {
        	stats[i] = new JLabel();
        	stats[i].setBounds(3*(width/4) + (int)(0.174 * width), 3*(height/4) - (int)(0.044 * height) + ((i-3) * (int)(0.072*height)), (int)(0.0694 * width), (int)(0.0444 * height));
        	stats[i].setOpaque(false);
        	stats[i].setVisible(true);
        	stats[i].setForeground(Color.WHITE);
        	stats[i].setFont(new Font("Georgia", Font.PLAIN, 10));
        	add(stats[i]);
        }
        add(gametext);
        add(ability1icon);
        add(ability2icon);
        add(ability3icon);
        add(ability4icon);
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
        add(confirm);
        add(cancel);

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
                        for (int i = 0; i < 6; i++)
                        {
                        	if (i == 0)
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,0).selectSquare().attackValue);
                        	}
                        	else if (i == 1)
                        	{
                        		stats[i].setText("" + 0);
                        	}
                        	else if (i == 2)
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,0).selectSquare().speedValue);
                        	}
                        	else if (i == 3)
                        	{
                        		stats[i].setText("H LA LR LL RL C");
                        	}
                        	else if (i == 4)
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,0).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(0,0).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(0,0).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(0,0).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(0,0).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(0,0).selectSquare().getHealth(5));
                        	}
                        	else
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,0).selectSquare().dodgeValue);
                        	}
                        }
                        changeAbilityIcons(unitName);
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
                if(unitSelected == false){
                    if(instance.cruBoard.getSquare(0,1).selectSquare() != null){
                        unitSelected = true;
                        unitName = instance.cruBoard.getSquare(0,1).selectSquare().name;
                        for (int i = 0; i < 6; i++)
                        {
                        	if (i == 0)
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,1).selectSquare().attackValue);
                        	}
                        	else if (i == 1)
                        	{
                        		stats[i].setText("" + 0);
                        	}
                        	else if (i == 2)
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,1).selectSquare().speedValue);
                        	}
                        	else if (i == 3)
                        	{
                        		stats[i].setText("H LA LR LL RL C");
                        	}
                        	else if (i == 4)
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,1).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(0,1).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(0,1).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(0,1).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(0,1).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(0,1).selectSquare().getHealth(5));
                        	}
                        	else
                        	{
                        		stats[i].setText("" + instance.cruBoard.getSquare(0,1).selectSquare().dodgeValue);
                        	}
                        }
                        changeAbilityIcons(unitName);
                    }
                    else{
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
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(0,2).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(0,2).selectSquare().name;
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,2).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,2).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,2).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(0,2).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(0,2).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(0,2).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(0,2).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(0,2).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,2).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
            if(unitSelected == false){
                if(instance.cruBoard.getSquare(0,3).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(0,3).selectSquare().name;
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,3).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,3).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,3).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(0,3).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(0,3).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(0,3).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(0,3).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(0,3).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(0,3).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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

            if(unitSelected == false){
                if(instance.cruBoard.getSquare(1,0).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(1,0).selectSquare().name;
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,0).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,0).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,0).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(1,0).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(1,0).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(1,0).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(1,0).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(1,0).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,0).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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

            if(unitSelected == false){
                if(instance.cruBoard.getSquare(1,1).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(1,1).selectSquare().name;
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,1).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,1).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,1).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(1,1).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(1,1).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(1,1).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(1,1).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(1,1).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,1).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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

            if(unitSelected == false){
                if(instance.cruBoard.getSquare(1,2).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(1,2).selectSquare().name;
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,2).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,2).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,2).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(1,2).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(1,2).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(1,2).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(1,2).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(1,2).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,2).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,3).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,3).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,3).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(1,3).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(1,3).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(1,3).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(1,3).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(1,3).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(1,3).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);


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

            if(unitSelected == false){
                if(instance.cruBoard.getSquare(2,0).selectSquare() != null){
                    unitSelected = true;
                    unitName = instance.cruBoard.getSquare(2,0).selectSquare().name;
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,0).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,0).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,0).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(2,0).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(2,0).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(2,0).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(2,0).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(2,0).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,0).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,1).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,1).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,1).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(2,1).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(2,1).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(2,1).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(2,1).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(2,1).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,1).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,2).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,2).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,2).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(2,2).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(2,2).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(2,2).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(2,2).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(2,2).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,2).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,3).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,3).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,3).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(2,3).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(2,3).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(2,3).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(2,3).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(2,3).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(2,3).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,0).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,0).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,0).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(3,0).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(3,0).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(3,0).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(3,0).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(3,0).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,0).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,1).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,1).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,1).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(3,1).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(3,1).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(3,1).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(3,1).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(3,1).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,1).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,2).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,2).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,2).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(3,2).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(3,2).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(3,2).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(3,2).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(3,2).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,2).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                    for (int i = 0; i < 6; i++)
                    {
                    	if (i == 0)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,3).selectSquare().attackValue);
                    	}
                    	else if (i == 1)
                    	{
                    		stats[i].setText("" + 0);
                    	}
                    	else if (i == 2)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,3).selectSquare().speedValue);
                    	}
                    	else if (i == 3)
                    	{
                    		stats[i].setText("H LA LR LL RL C");
                    	}
                    	else if (i == 4)
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,3).selectSquare().getHealth(0)+" "+instance.cruBoard.getSquare(3,3).selectSquare().getHealth(1)+" "+instance.cruBoard.getSquare(3,3).selectSquare().getHealth(2)+" "+instance.cruBoard.getSquare(3,3).selectSquare().getHealth(3)+" "+instance.cruBoard.getSquare(3,3).selectSquare().getHealth(4)+" "+instance.cruBoard.getSquare(3,3).selectSquare().getHealth(5));
                    	}
                    	else
                    	{
                    		stats[i].setText("" + instance.cruBoard.getSquare(3,3).selectSquare().dodgeValue);
                    	}
                    }
                    changeAbilityIcons(unitName);

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
                ability1Selected = true;
                ability2Selected = false;
                ability3Selected = false;
                ability4Selected = false;         
           }
       });
        ability2.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            ability1Selected = false;
            ability2Selected = true;
            ability3Selected = false;
            ability4Selected = false;            
           }
       });
        ability3.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            ability1Selected = false;
            ability2Selected = false;
            ability3Selected = true;
            ability4Selected = false;            
           }
       });
        ability4.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
            ability1Selected = false;
            ability2Selected = false;
            ability3Selected = false;
            ability4Selected = true;
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
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                System.out.println("clicked");
                if(unitSelected && unitTargeted){
                    System.out.println("selected and targeted");
                    if(ability1Selected){
                        System.out.println(unitName);
                        System.out.println("ability1");
                            if(unitName == "cleric"){
                                System.out.println("heal");
                                gametext.setText("<html>Cleric used heal!");
                                result = party.getParty(1).heal(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() +"<br/>" + "The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The unit dodged the attack!</html>");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"Cleric missed the attack!</html>");
                                }
                            }
                            else if(unitName == "archer"){
                                System.out.println("snipe");
                                gametext.setText("<html>Archer used snipe!");

                                result = party.getParty(2).snipe(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() +  "<br/>" +"The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() +  "<br/>" +"The unit dodged the attack!</html>");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() +  "<br/>" +"Archer missed the attack!</html>");
                                }
                            }
                            else if(unitName == "swordandshield"){
                                System.out.println("sas hilt bash");
                                gametext.setText("<html>Marauder used hilt bash!");

                                result = party.getParty(0).sashiltdBash(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                System.out.println("result: " + result);
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" + "The unit dodged the attack!</html>");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"Marauder missed the attack!</html>");
                                }
                            }
                            else if(unitName == "swordsman"){
                                System.out.println("sword slash");
                                gametext.setText("<html>Swordsman used slash!");

                                result = party.getParty(3).swordsmanslash(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The unit dodged the attack!</html>");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() +"<br/>" + "Swordsman missed the attack!</html>");
                                }
                            }
                            int random=-1;
                            int random2=-1;
                            boolean hasAUnit=false;
                            for (int r=0;r<4;r++){
                                for (int t=0;t<4;t++){
                                    if (instance.alienBoard.getSquare(r, t)!=null){
                                        hasAUnit=true;
                                    }
                                }
                            }
                            do{
                                random = (int)(Math.random()*((4)));
                                random2 = (int)(Math.random()*((4)));
                            }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                           // System.out.println("Random nums");
                           // System.out.println(random);
                           // System.out.println(random2);
                           if(hasAUnit){
                            instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);}
                            //System.out.print("7 Attacking with: ");
                            //System.out.println(instance.alienBoard.getSquare(random, random2).selectSquare().name);
                            do{
                                random = (int)(Math.random()*((4)));
                                random2 = (int)(Math.random()*((4)));
                            }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                            if(hasAUnit){
                            instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);} 
                    }
                    else if(ability2Selected){
                        System.out.println(unitName);
                        System.out.println("ability2");
                            if(unitName == "cleric"){
                                System.out.println("cleric slash");
                                gametext.setText("<html>Cleric used slash!");

                                result = party.getParty(1).clericslash(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() +"<br/>" + "The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The unit dodged the attack</html>!");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() +"<br/>" + "Cleric missed the attack</html>!");
                                }
                            }
                            else if(unitName == "archer"){
                                System.out.println("archer shoot");
                                gametext.setText("<html>Archer used shoot!");

                                result = party.getParty(2).shoot(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() +  "<br/>" +"The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() +  "<br/>" +"The unit dodged the attack!</html>");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() +  "<br/>" +"Archer missed the attack!</html>");
                                }
                            }
                            else if(unitName == "swordandshield"){
                                System.out.println("sas slash");
                                gametext.setText("<html>Marauder used slash!");

                                result = party.getParty(0).slash(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" + "The unit dodged the attack!</html>");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"Marauder missed the attack!</html>");
                                }
                            }
                            else if(unitName == "swordsman"){
                                System.out.println("sword hilt bash");
                                gametext.setText("<html>Swordsman used hilt bash!");

                                result = party.getParty(3).hiltdBash(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                                if (result == 0)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The attack hit!</html>");
                                }
                                else if (result == 1)
                                {
                                	gametext.setText(gametext.getText() + "<br/>" +"The unit dodged the attack!</html>");
                                }
                                else
                                {
                                	gametext.setText(gametext.getText() +"<br/>" + "Swordsman missed the attack!</html>");
                                }
                            }
                            int random=-1;
                            int random2=-1;
                            boolean hasAUnit=false;
                            for (int r=0;r<4;r++){
                                for (int t=0;t<4;t++){
                                    if (instance.alienBoard.getSquare(r, t)!=null){
                                        hasAUnit=true;
                                    }
                                }
                            }
                            do{
                                random = (int)(Math.random()*((4)));
                                random2 = (int)(Math.random()*((4)));
                            }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                           // System.out.println("Random nums");
                           // System.out.println(random);
                           // System.out.println(random2);
                           if(hasAUnit){
                            instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);}
                            //System.out.print("7 Attacking with: ");
                            //System.out.println(instance.alienBoard.getSquare(random, random2).selectSquare().name);
                            do{
                                random = (int)(Math.random()*((4)));
                                random2 = (int)(Math.random()*((4)));
                            }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                            if(hasAUnit){
                            instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);} 
                    }
                    else if(ability3Selected){                 
                        System.out.println(unitName);
                        System.out.println("ability3");

                            if(unitName == "cleric"){
                                System.out.println("cleric block");
                                gametext.setText("<html>Cleric used block!</html>");

                                party.getParty(1).clericblock(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            }
                            else if(unitName == "archer"){
                                System.out.println("archer block");
                                gametext.setText("<html>Archer used block!</html>");

                                party.getParty(2).block(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            }
                            else if(unitName == "swordandshield"){
                                System.out.println("sas block");
                                gametext.setText("<html>Marauder used block!</html>");

                                party.getParty(0).sasblock(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            }
                            else if(unitName == "swordsman"){
                                System.out.println("sword block");
                                gametext.setText("<html>Swordsman used block!</html>");

                                party.getParty(3).swordsmanblock(instance.cruBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            }
                            int random=-1;
                            int random2=-1;
                            boolean hasAUnit=false;
                            for (int r=0;r<4;r++){
                                for (int t=0;t<4;t++){
                                    if (instance.alienBoard.getSquare(r, t)!=null){
                                        hasAUnit=true;
                                    }
                                }
                            }
                            do{
                                random = (int)(Math.random()*((4)));
                                random2 = (int)(Math.random()*((4)));
                            }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                           // System.out.println("Random nums");
                           // System.out.println(random);
                           // System.out.println(random2);
                           if(hasAUnit){
                            instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);}
                            //System.out.print("7 Attacking with: ");
                            //System.out.println(instance.alienBoard.getSquare(random, random2).selectSquare().name);
                            do{
                                random = (int)(Math.random()*((4)));
                                random2 = (int)(Math.random()*((4)));
                            }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                            if(hasAUnit){
                            instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);} 
                            //System.out.print("6 Attacking with: ");
                        //    System.out.println(instance.alienBoard.getSquare(random, random2).selectSquare().name);  
                    }
                    else if(ability4Selected){
                        System.out.println(unitName);
                        System.out.println("ability4");

                        if(unitName == "cleric"){
                            System.out.println("holy light");
                            gametext.setText("<html>Cleric used Holy Light!");

                            result = party.getParty(1).holy_light(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            if (result == 0)
                            {
                            	gametext.setText(gametext.getText() +"<br/>" + "The attack hit!</html>");
                            }
                            else if (result == 1)
                            {
                            	gametext.setText(gametext.getText() + "<br/>" +"The unit dodged the attack</html>!");
                            }
                            else
                            {
                            	gametext.setText(gametext.getText() +"<br/>" + "Cleric missed the attack</html>!");
                            }
                        }
                        else if(unitName == "archer"){
                            System.out.println("rain");
                            gametext.setText("<html>Archer used Arrow Rain!");

                            result = party.getParty(2).rain(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            if (result == 0)
                            {
                            	gametext.setText(gametext.getText() +  "<br/>" +"The attack hit!</html>");
                            }
                            else if (result == 1)
                            {
                            	gametext.setText(gametext.getText() +  "<br/>" +"The unit dodged the attack!</html>");
                            }
                            else
                            {
                            	gametext.setText(gametext.getText() +  "<br/>" +"Archer missed the attack!</html>");
                            }
                        }
                        else if(unitName == "swordandshield"){
                            System.out.println("sas slice");
                            gametext.setText("<html>Marauder used Decimate!");

                            result = party.getParty(0).sasslice(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            if (result == 0)
                            {
                            	gametext.setText(gametext.getText() + "<br/>" +"The attack hit!</html>");
                            }
                            else if (result == 1)
                            {
                            	gametext.setText(gametext.getText() + "<br/>" + "The unit dodged the attack!</html>");
                            }
                            else
                            {
                            	gametext.setText(gametext.getText() + "<br/>" +"Marauder missed the attack!</html>");
                            }
                        }
                        else if(unitName == "swordsman"){
                            System.out.println("sword slice");
                            gametext.setText("<html>Swordsman used Decapitate!");

                            result = party.getParty(3).slice(instance.alienBoard.getSquare(unitCoordinateX,unitCoordinateY));
                            if (result == 0)
                            {
                            	gametext.setText(gametext.getText() + "<br/>" +"The attack hit!</html>");
                            }
                            else if (result == 1)
                            {
                            	gametext.setText(gametext.getText() + "<br/>" +"The unit dodged the attack!</html>");
                            }
                            else
                            {
                            	gametext.setText(gametext.getText() +"<br/>" + "Swordsman missed the attack!</html>");
                            }
                        }
                    int random=-1;
                    int random2=-1;
                    boolean hasAUnit=false;
                    for (int r=0;r<4;r++){
                        for (int t=0;t<4;t++){
                            if (instance.alienBoard.getSquare(r, t)!=null){
                                hasAUnit=true;
                            }
                        }
                    }
                    do{
                        random = (int)(Math.random()*((4)));
                        random2 = (int)(Math.random()*((4)));
                    }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                   // System.out.println("Random nums");
                   // System.out.println(random);
                   // System.out.println(random2);
                   if(hasAUnit){
                    instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);}
                    //System.out.print("7 Attacking with: ");
                    //System.out.println(instance.alienBoard.getSquare(random, random2).selectSquare().name);
                    do{
                        random = (int)(Math.random()*((4)));
                        random2 = (int)(Math.random()*((4)));
                    }while (instance.alienBoard.getSquare(random, random2).selectSquare()==null&&hasAUnit);
                    if(hasAUnit){
                    instance.alienBoard.getSquare(random, random2).selectSquare().takeTurn(instance.alienBoard,instance.cruBoard);} 
                    //System.out.println("Random nums");
                    //System.out.println(random);
                    //System.out.println(random2);
                    }
                    
                }
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                        alienSquareLabels[i][j].setIcon(selectsquare);
                        alienSquareLabels[i][j].setVisible(false);
                    }
                }
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                        crusaderSquareLabels[i][j].setIcon(selectsquare);
                        crusaderSquareLabels[i][j].setVisible(false);
                    }
                }
                unitSelected = false;
                unitTargeted = false;
                ability1Selected = false;
                ability2Selected = false;
                ability3Selected = false;
                ability4Selected = false;
                    
                boolean victory=true;
                int nullCount=0;
                for (int r=0;r<4;r++){
                    for (int t=0;t<4;t++){
                        if (instance.alienBoard.getSquare(r, t)!=null){
                            victory=false;
                        }
                        if (instance.cruBoard.getSquare(r, t)==null){
                            nullCount++;
                        }
                    }
                }
                if (nullCount==16){
                    defeat=true;
                }
                 if(victory){
                    victoryCount++;
                    returnb = true;
                 }   
            }
        });
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                        alienSquareLabels[i][j].setIcon(selectsquare);
                        alienSquareLabels[i][j].setVisible(false);
                    }
                }
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                        crusaderSquareLabels[i][j].setIcon(selectsquare);
                        crusaderSquareLabels[i][j].setVisible(false);
                    }
                }
                unitSelected = false;
                unitTargeted = false;
                ability1Selected = false;
                ability2Selected = false;
                ability3Selected = false;
                ability4Selected = false;
            }
        });

    }
    public boolean getReturn(){
        return returnb;
    }

    public void setReturn(){
        returnb = false;
    }

    public void changeAbilityIcons(String unitName){
        if(unitName == "cleric"){
            ability1icon.setIcon(healicon);
            ability2icon.setIcon(slashicon);
            ability3icon.setIcon(blockicon);
            ability4icon.setIcon(holyicon);
        }
        else if(unitName == "swordandshield"){
            ability1icon.setIcon(hilticon);
            ability2icon.setIcon(slashicon);
            ability3icon.setIcon(blockicon);
            ability4icon.setIcon(sliceicon);
        }
        else if(unitName == "swordsman"){
            ability1icon.setIcon(slashicon);
            ability2icon.setIcon(hilticon);
            ability3icon.setIcon(blockicon);
            ability4icon.setIcon(sliceicon);
        }
        else if(unitName == "archer"){
            ability1icon.setIcon(snipeicon);
            ability2icon.setIcon(shooticon);
            ability3icon.setIcon(blockicon);
            ability4icon.setIcon(rainicon);
        }
    }

    public void refreshBoard(){
        for (int i = 0; i < 4; i++)
        {
        	for (int j = 0; j < 4; j++)
            {
            	if (instance.cruBoard.getSquare(i, j).selectSquare() != null)
            	{
            		crusaders[c_counter] = new JLabel();
            		crusaders[c_counter].setIcon(instance.cruBoard.getSquare(i, j).selectSquare().image);
            		crusaders[c_counter].setVisible(true);
            		crusaders[c_counter].setBounds((int)(0.0535 * width2) + (int)(j * (float)(width2/1440)) + (int)(j * (0.073 * width2)), 
            				(int)(0.075 * height2)+ (int)(i * (0.13 * height2)), 
            				instance.cruBoard.getSquare(i, j).selectSquare().image.getIconWidth(),
            				instance.cruBoard.getSquare(i, j).selectSquare().image.getIconHeight());
                            repaint();            		
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
            		aliens[a_counter].setBounds((int)(width2*(0.675))+ (int)(j * (float)(width2/1440)) + (int)(j * (0.07 * width2)), 
            				(int)(0.075 * height2)+ (int)(i * (0.13 * height2)), 
            				instance.alienBoard.getSquare(i, j).selectSquare().image.getIconWidth(),
            				instance.alienBoard.getSquare(i, j).selectSquare().image.getIconHeight());
                            repaint();
                    		a_counter++;
            	}
            }
        }
    }

    public boolean getDefeat(){
        return defeat;
    }
    public boolean winCount(){
        return victoryCount==4;
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