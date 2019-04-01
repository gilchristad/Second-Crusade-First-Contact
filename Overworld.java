import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class Overworld extends JPanel{

    private static final long serialVersionUID = 1L;
    boolean mainmenu = false;
    boolean newbattle = false;
    boolean newrest = false;
    boolean newboss = false;
    int ONE_SECOND = 1000;
    ImageIcon crusadersprite1 = new ImageIcon("Images/Icons/crusader sprite.png");
    ImageIcon crusadersprite2 = new ImageIcon("Images/Icons/crusader sprite 2.png");
    JLabel sprite = new JLabel(crusadersprite1);
    

    public void OverworldFrame(int width, int height) throws IOException, InterruptedException {
        ImageIcon background = new ImageIcon("Images/Backgrounds/jerusalempix.jpg");
        background.setImage(getScaledImage(background.getImage(), width, height));
    	
        ImageIcon hover = new ImageIcon("Images/Backgrounds/jerusalemhover.jpg");
        hover.setImage(getScaledImage(hover.getImage(),  width, height));
        
        ImageIcon options = new ImageIcon("Images/Backgrounds/jerusalemesc.jpg");
        options.setImage(getScaledImage(options.getImage(), width, height));

        ImageIcon house = new ImageIcon("Images/Icons/house.png");
        //System.out.println(house.getIconWidth() + ", " + house.getIconHeight()+ ", " + ((float)width/(float)1920) * (float)house.getIconWidth()+ ", " +((float)height/(float)1080) * (float)house.getIconHeight());
        house.setImage(getScaledImage(house.getImage(), (int)(((float)width/(float)1920) * (float)house.getIconWidth()), (int)(((float)height/(float)1080) * (float)house.getIconHeight())));

        ImageIcon monastery = new ImageIcon("Images/Icons/monastery.png");
        monastery.setImage(getScaledImage(monastery.getImage(), (int)(((float)width/(float)1920) * (float)monastery.getIconWidth()), (int)(((float)height/(float)1080) * (float)monastery.getIconHeight())));

        ImageIcon ufo = new ImageIcon("Images/Icons/ufo.png");
        ufo.setImage(getScaledImage(ufo.getImage(), (int)(((float)width/(float)1920) * (float)ufo.getIconWidth()), (int)(((float)height/(float)1080) * (float)ufo.getIconHeight())));

        ImageIcon monasterybig = new ImageIcon("Images/Icons/monastery2.png");
        monasterybig.setImage(getScaledImage(monasterybig.getImage(), (int)(((float)width/(float)1920) * (float)monasterybig.getIconWidth()), (int)(((float)height/(float)1080) * (float)monasterybig.getIconHeight())));

        JLabel imagelabel = new JLabel();
        JLabel house1 = new JLabel();
        JLabel house2 = new JLabel();
        JLabel house3 = new JLabel();
        JLabel ufo1 = new JLabel();
        JLabel ufo2 = new JLabel();        
        JLabel ufo3 = new JLabel();
        JLabel monastery1 = new JLabel();
        JLabel monastery2 = new JLabel();

        imagelabel.setIcon(background);
        house1.setIcon(house);
        house2.setIcon(house);
        house3.setIcon(house);
        ufo1.setIcon(ufo);
        ufo2.setIcon(ufo);
        ufo3.setIcon(ufo);
        monastery1.setIcon(monastery);
        monastery2.setIcon(monasterybig);

        house1.setVisible(true);
        house2.setVisible(true);
        house3.setVisible(true);
        ufo1.setVisible(true);
        ufo2.setVisible(true);
        ufo3.setVisible(true);
        monastery1.setVisible(true);
        monastery2.setVisible(true);

        JButton h1 = new JButton();
        JButton h2 = new JButton();
        JButton h3 = new JButton();
        JButton u1 = new JButton();
        JButton u2 = new JButton();
        JButton u3 = new JButton();
        JButton m1 = new JButton();
        JButton m2 = new JButton();
        JButton menu = new JButton();
        
        imagelabel.setBounds(0,0,width,height);
        
        sprite.setBounds((int)(0.265*width),(int)(0.448*height),40,90);

        house1.setBounds((int)(0.610*width),(int)(0.148*height),house.getIconWidth(),house.getIconHeight());
        house2.setBounds((int)(0.504*width),(int)(0.394*height),house.getIconWidth(),house.getIconHeight());
        house3.setBounds((int)(0.346*width),(int)(0.742*height),house.getIconWidth(),house.getIconHeight());
        ufo1.setBounds((int)(0.505*width),(int)(0.594*height),ufo.getIconWidth(),ufo.getIconHeight());
        ufo2.setBounds((int)(0.425*width),(int)(0.372*height),ufo.getIconWidth(),ufo.getIconHeight());
        ufo3.setBounds((int)(0.358*width),(int)(0.596*height),ufo.getIconWidth(),ufo.getIconHeight());
        monastery1.setBounds((int)(0.518*width),(int)(0.235*height),monastery.getIconWidth(),monastery.getIconHeight());
        monastery2.setBounds((int)(0.607*width),(int)(0.501*height),monasterybig.getIconWidth(),monasterybig.getIconHeight());

        h1.setBounds((int)(0.610*width),(int)(0.148*height),house.getIconWidth(),house.getIconHeight());
        h2.setBounds((int)(0.504*width),(int)(0.394*height),house.getIconWidth(),house.getIconHeight());
        h3.setBounds((int)(0.346*width),(int)(0.742*height),house.getIconWidth(),house.getIconHeight());
        u1.setBounds((int)(0.505*width),(int)(0.594*height),ufo.getIconWidth(),ufo.getIconHeight());
        u2.setBounds((int)(0.425*width),(int)(0.372*height),ufo.getIconWidth(),ufo.getIconHeight());
        u3.setBounds((int)(0.358*width),(int)(0.596*height),ufo.getIconWidth(),ufo.getIconHeight());
        m1.setBounds((int)(0.518*width),(int)(0.235*height),monastery.getIconWidth(),monastery.getIconHeight());
        m2.setBounds((int)(0.607*width),(int)(0.501*height),monasterybig.getIconWidth(),monasterybig.getIconHeight());
        menu.setBounds((int)(0.008*width),(int)(0.015*height),132,34); 

        setLayout(null);
        add(sprite);
        add(house1);
        add(house2);
        add(house3);
        add(ufo1);
        add(ufo2);
        add(ufo3);
        add(monastery1);
        add(monastery2);
        add(h1);
        add(h2);
        add(h3);
        add(u1);
        add(u2);
        add(u3);
        add(m1);
        add(m2);
        add(imagelabel);
        add(menu);

        menu.setOpaque(false);
        menu.setContentAreaFilled(false);
        menu.setBorderPainted(false);

        h1.setOpaque(false);
        h1.setContentAreaFilled(false);
        h1.setBorderPainted(false);

        h2.setOpaque(false);
        h2.setContentAreaFilled(false);
        h2.setBorderPainted(false);

        h3.setOpaque(false);
        h3.setContentAreaFilled(false);
        h3.setBorderPainted(false);

        u1.setOpaque(false);
        u1.setContentAreaFilled(false);
        u1.setBorderPainted(false);

        u2.setOpaque(false);
        u2.setContentAreaFilled(false);
        u2.setBorderPainted(false);

        u3.setOpaque(false);
        u3.setContentAreaFilled(false);
        u3.setBorderPainted(false);

        m1.setOpaque(false);
        m1.setContentAreaFilled(false);
        m1.setBorderPainted(false);

        m2.setOpaque(false);
        m2.setContentAreaFilled(false);
        m2.setBorderPainted(false);
    
        h1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newrest = true;
            }
        });

        h2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newrest = true;
            }
        });

        h3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newrest = true;
            }
        });

        u1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newbattle = true;
            }
        });

        u2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newbattle = true;
            }
        });

        u3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newbattle = true;
            }
        });

        m1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newboss = true;
                System.out.println("m1");
            }
        });

        m2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newboss = true;
                System.out.println("m2");
            }
        });

        menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                mainmenu = true;
            }
        });

        Timer timer = new Timer(ONE_SECOND, new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                spriteCycle();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public boolean getMainMenu(){
        return mainmenu;
    }

    public void setMainMenu(){
        mainmenu = false;
    }

    public void spriteCycle(){
        if(sprite.getIcon() == crusadersprite1){
            sprite.setIcon(crusadersprite2);
        }
        else{
            sprite.setIcon(crusadersprite1);
        }
    }

    public boolean getBattle(){
        return newbattle;
    }

    public boolean getBoss(){
        return newboss;
    }

    public boolean getRest(){
        return newrest;
    }

    public void setBattle(){
        newbattle = false;
    }

    public void setBoss(){
        newboss = false;
    }

    public void setRest(){
        newrest = false;
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