import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.*;

public class MainMenu extends JPanel{

    private static final long serialVersionUID = 1L;
    boolean newgame = false;

    public void MainMenuFrame() throws IOException {

        ImageIcon image = new ImageIcon("Images/Backgrounds/mainmenu.jpg");
        ImageIcon newgamehover = new ImageIcon("Images/Backgrounds/newgamehover.jpg");
        ImageIcon continuegamehover = new ImageIcon("Images/Backgrounds/continuehover.jpg");
        ImageIcon loadgamehover = new ImageIcon("Images/Backgrounds/loadgamehover.jpg");
        ImageIcon optionshover = new ImageIcon("Images/Backgrounds/optionshover.jpg");
        ImageIcon exithover = new ImageIcon("Images/Backgrounds/exithover.jpg");
        ImageIcon loadgamescreen = new ImageIcon("Images/Backgrounds/loadgamescreen.jpg");
        ImageIcon optionsscreen = new ImageIcon("Images/Backgrounds/optionsscreen.jpg");
        ImageIcon optionsbackhover = new ImageIcon("Images/Backgrounds/optionsbackhover.jpg");
        ImageIcon loadgamebackhover = new ImageIcon("Images/Backgrounds/loadgamebackhover.jpg");

        JLabel imagelabel = new JLabel(image);
        JButton ngb = new JButton();
        JButton cgb = new JButton();
        JButton lgb = new JButton();
        JButton ob = new JButton();
        JButton exitb = new JButton();
        JButton loadbackb = new JButton();
        JButton optionsbackb = new JButton();

        //File music = new File("Music/mainmusic.wav");
        //InputStream in = new FileInputStream(music);
        //AudioStream as = new AudioStream(in);         
        //AudioPlayer.player.start(as);
        
        ngb.setBounds(1514, 361,376, 55);
        cgb.setBounds(1575, 446, 315, 55);
        lgb.setBounds(1504, 535, 386, 55);
        ob.setBounds(1613, 621, 277, 55);
        exitb.setBounds(1759,709, 134, 50);
        loadbackb.setBounds(368,139, 111, 35);
        optionsbackb.setBounds(368,139, 111, 35);
        imagelabel.setBounds(0,0,1920,1080);

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
                //AudioPlayer.player.stop(as);
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
}