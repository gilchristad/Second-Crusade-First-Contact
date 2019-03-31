import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    

    public void OverworldFrame() throws IOException, InterruptedException {
        ImageIcon background = new ImageIcon("Images/Backgrounds/jerusalempix.jpg");
        ImageIcon hover = new ImageIcon("Images/Backgrounds/jerusalemhover.jpg");
        ImageIcon options = new ImageIcon("Images/Backgrounds/jerusalemesc.jpg");
        ImageIcon house = new ImageIcon("Images/Icons/house.png");
        ImageIcon monastery = new ImageIcon("Images/Icons/monastery.png");
        ImageIcon ufo = new ImageIcon("Images/Icons/ufo.png");
        ImageIcon monasterybig = new ImageIcon("Images/Icons/monastery2.png");

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
        
        imagelabel.setBounds(0,0,1920,1080);
        sprite.setBounds(508,484, 40, 90);
        house1.setBounds(1172,160,58,59);
        house2.setBounds(968,425,58,59);
        house3.setBounds(664,801,58,59);
        ufo1.setBounds(969,641,59,60);
        ufo2.setBounds(816,402,60,60);
        ufo3.setBounds(688,644,60,60);
        monastery1.setBounds(995,254,82,69);
        monastery2.setBounds(1165,541,160,128);

        h1.setBounds(1172,160,58,59);
        h2.setBounds(968,425,58,59);
        h3.setBounds(664,801,58,59);
        u1.setBounds(969,641,59,60);
        u2.setBounds(816,402,60,60);
        u3.setBounds(688,644,60,60);
        m1.setBounds(995,254,82,69);
        m2.setBounds(1165,541,160,128);

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
                System.out.println("h1 clicked");
            }
        });

        h2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newrest = true;
                System.out.println("h2 clicked");
            }
        });

        h3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newrest = true;
                System.out.println("h3 clicked");
            }
        });

        u1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newbattle = true;
                System.out.println("u1 clicked");
            }
        });

        u2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newbattle = true;
                System.out.println("u2 clicked");
            }
        });

        u3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newbattle = true;
                System.out.println("u3 clicked");
            }
        });

        m1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newboss = true;
                System.out.println("m1 clicked");
            }
        });

        m2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                newboss = true;
                System.out.println("m2 clicked");
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
}
