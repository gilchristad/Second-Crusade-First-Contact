import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.IOException; 
import java.io.*;

public class MainMenu extends JPanel {

    private static final long serialVersionUID = 1L;
    Clip menuclip;
    boolean newgame = false;

    public void MainMenuFrame(int width, int height) throws IOException{

        ImageIcon image = new ImageIcon("Images/Backgrounds/mainmenu.jpg");
        image.setImage(getScaledImage(image.getImage(), width, height));

        ImageIcon newgamehover = new ImageIcon("Images/Backgrounds/newgamehover.jpg");
        newgamehover.setImage(getScaledImage(newgamehover.getImage(), width, height));

        ImageIcon continuegamehover = new ImageIcon("Images/Backgrounds/continuehover.jpg");
        continuegamehover.setImage(getScaledImage(continuegamehover.getImage(), width, height));

        ImageIcon loadgamehover = new ImageIcon("Images/Backgrounds/loadgamehover.jpg");
        loadgamehover.setImage(getScaledImage(loadgamehover.getImage(), width, height));

        ImageIcon optionshover = new ImageIcon("Images/Backgrounds/optionshover.jpg");
        optionshover.setImage(getScaledImage(optionshover.getImage(), width, height));

        ImageIcon exithover = new ImageIcon("Images/Backgrounds/exithover.jpg");
        exithover.setImage(getScaledImage(exithover.getImage(), width, height));

        ImageIcon loadgamescreen = new ImageIcon("Images/Backgrounds/loadgamescreen.jpg");
        loadgamescreen.setImage(getScaledImage(loadgamescreen.getImage(), width, height));

        ImageIcon optionsscreen = new ImageIcon("Images/Backgrounds/optionsscreen.jpg");
        optionsscreen.setImage(getScaledImage(optionsscreen.getImage(), width, height));

        ImageIcon optionsbackhover = new ImageIcon("Images/Backgrounds/optionsbackhover.jpg");
        optionsbackhover.setImage(getScaledImage(optionsbackhover.getImage(), width, height));

        ImageIcon loadgamebackhover = new ImageIcon("Images/Backgrounds/loadgamebackhover.jpg");
        loadgamebackhover.setImage(getScaledImage(loadgamebackhover.getImage(), width, height));

        JLabel imagelabel = new JLabel(image);
        JButton ngb = new JButton();
        JButton cgb = new JButton();
        JButton lgb = new JButton();
        JButton ob = new JButton();
        JButton exitb = new JButton();
        JButton loadbackb = new JButton();
        JButton optionsbackb = new JButton();

        ngb.setBounds((int) (0.789*(width)), (int)(0.334 * height),(int)(0.196 * width), (int)(0.051 * height));
        cgb.setBounds((int) (0.820*(width)), (int)(0.413 * height),(int)(0.164 * width), (int)(0.051 * height));
        lgb.setBounds((int) (0.783*(width)), (int)(0.495 * height),(int)(0.201 * width), (int)(0.051 * height));
        ob.setBounds((int) (0.840*(width)), (int)(0.575 * height),(int)(0.144 * width), (int)(0.051 * height));
        exitb.setBounds((int) (0.916*(width)), (int)(0.656 * height),(int)(0.07 * width), (int)(0.046 * height));
        loadbackb.setBounds((int) (0.192*(width)), (int)(0.129 * height),(int)(0.06 * width), (int)(0.032 * height));
        optionsbackb.setBounds((int) (0.192*(width)), (int)(0.129 * height),(int)(0.06 * width), (int)(0.032 * height));
        imagelabel.setBounds(0,0,width,height);

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Themes/TITLE.wav").getAbsoluteFile());
            menuclip = AudioSystem.getClip();
            menuclip.open(audioInputStream);
            while(menuclip.isRunning()){
                menuclip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }   

        setLayout(null);
        add(ngb);
        add(cgb);
        add(lgb);
        add(ob);
        add(exitb);
        add(optionsbackb);
        add(loadbackb);
        add(imagelabel);
        setVisible(true);

        ngb.setOpaque(false);
        ngb.setContentAreaFilled(false);
        ngb.setBorderPainted(false);
        ngb.setVisible(true);

        cgb.setOpaque(false);
        cgb.setContentAreaFilled(false);
        cgb.setBorderPainted(false);

        lgb.setOpaque(false);
        lgb.setContentAreaFilled(false);
        lgb.setBorderPainted(false);

        ob.setOpaque(false);
        ob.setContentAreaFilled(false);
        ob.setBorderPainted(false);

        exitb.setOpaque(false);
        exitb.setContentAreaFilled(false);
        exitb.setBorderPainted(false);

        loadbackb.setOpaque(false);
        loadbackb.setContentAreaFilled(false);
        loadbackb.setBorderPainted(false);
        loadbackb.setVisible(false);
        
        optionsbackb.setOpaque(false);
        optionsbackb.setContentAreaFilled(false);
        optionsbackb.setBorderPainted(false);
        optionsbackb.setVisible(false);
        
        ngb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newgame = true;
            }
        });

        lgb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                ngb.setVisible(false);
                cgb.setVisible(false);
                lgb.removeMouseListener(lgb.getMouseListeners()[1]);
                ob.setVisible(false);
                exitb.setVisible(false);
                loadbackb.setVisible(true);
                imagelabel.setIcon(loadgamescreen);
                loadbackb.addMouseListener(new java.awt.event.MouseAdapter(){
                    public void mouseEntered(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(loadgamebackhover);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(loadgamescreen);
                    }
                });
            }
        });

        ob.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                ngb.setVisible(false);
                cgb.setVisible(false);
                lgb.setVisible(false);
                ob.removeMouseListener(ob.getMouseListeners()[1]);
                exitb.setVisible(false); 
                optionsbackb.setVisible(true);
                imagelabel.setIcon(optionsscreen);  
                optionsbackb.addMouseListener(new java.awt.event.MouseAdapter(){
                    public void mouseEntered(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(optionsbackhover);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(optionsscreen);
                    }
                });
            }
        });
        
        exitb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                System.exit(1);
            }
        });

        loadbackb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                imagelabel.setIcon(image); 
                ngb.setVisible(true);
                cgb.setVisible(true);
                lgb.setVisible(true);
                ob.setVisible(true);
                exitb.setVisible(true); 
                loadbackb.setVisible(false);
                lgb.addMouseListener(new java.awt.event.MouseAdapter(){
                    public void mouseEntered(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(loadgamehover);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(image);
                    }
                });
                loadbackb.removeMouseListener(loadbackb.getMouseListeners()[1]);
            }
        });

        optionsbackb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                imagelabel.setIcon(image); 
                ngb.setVisible(true);
                cgb.setVisible(true);
                lgb.setVisible(true);
                ob.setVisible(true);
                exitb.setVisible(true); 
                optionsbackb.setVisible(false);
                ob.addMouseListener(new java.awt.event.MouseAdapter(){
                    public void mouseEntered(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(optionshover);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt){
                        imagelabel.setIcon(image);
                    }
                });
                optionsbackb.removeMouseListener(optionsbackb.getMouseListeners()[1]);
            }
        });

        ngb.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(newgamehover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(image);
            }
        });

        cgb.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(continuegamehover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(image);
            }
        });
        
        lgb.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(loadgamehover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(image);
            }
        });

        ob.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(optionshover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(image);
            }
        });

        exitb.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(exithover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                imagelabel.setIcon(image);
            }
        });

    }
    public boolean getNewGame(){
        return newgame;
    }

    public void setNewGame(){
        newgame = false;
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