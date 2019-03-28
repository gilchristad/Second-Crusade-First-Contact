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
    int ONE_SECOND = 1000;
    ImageIcon crusadersprite1 = new ImageIcon("Images/crusader sprite.png");
    ImageIcon crusadersprite2 = new ImageIcon("Images/crusader sprite 2.png");
    JLabel sprite = new JLabel(crusadersprite1);
    

    public void OverworldFrame() throws IOException, InterruptedException {
        ImageIcon background = new ImageIcon("Images/jerusalempix.jpg");
        ImageIcon options = new ImageIcon("Images/jerusalemesc.jpg");
        ImageIcon house = new ImageIcon("Images/house.png");
        ImageIcon monastery = new ImageIcon("Images/monastery.png");
        ImageIcon ufo = new ImageIcon("Images/ufo.png");
        JLabel imagelabel = new JLabel(background);
        JLabel house1 = new JLabel(house);
        JLabel house2 = new JLabel(house);
        JLabel ufo1 = new JLabel(ufo);
        JLabel ufo2 = new JLabel(ufo);
        JLabel monastery1 = new JLabel(monastery);
        JLabel monastery2 = new JLabel(monastery);

        JButton h1 = new JButton();
        JButton h2 = new JButton();
        JButton u1 = new JButton();
        JButton u2 = new JButton();
        JButton m1 = new JButton();
        JButton m2 = new JButton();
        
        imagelabel.setBounds(0,0,1920,1080);
        sprite.setBounds(508,484, 40, 90);
        house1.setBounds(0,0,0,0);
        house2.setBounds(0,0,0,0);
        ufo1.setBounds(0,0,0,0);
        ufo2.setBounds(0,0,0,0);
        monastery1.setBounds(0,0,0,0);
        monastery2.setBounds(0,0,0,0);
        setLayout(null);
        add(sprite);
        add(imagelabel);
        add(house1);
        add(house2);
        add(ufo1);
        add(ufo2);
        add(monastery1);
        add(monastery2);
        add(h1);
        add(h2);
        add(u1);
        add(u2);
        add(m1);
        add(m2);
        
        // addKeyListener(new KeyAdapter() {
        //     public void keyPressed(KeyEvent ke){
        //         if(ke.getKeyCode() == KeyEvent.VK_ESCAPE){
        //             System.out.println("pressed");
        //             imagelabel.setIcon(options);
        //         }
        //     }
        // });
    
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
}
