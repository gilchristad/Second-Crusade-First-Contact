import java.awt.BorderLayout;
import java.awt.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application {
    
    public static void main(String[] args) throws IOException, InterruptedException 
    { 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        MainMenu mainmenu = new MainMenu();
        Overworld overworld = new Overworld();
        Instructions instructions = new Instructions();
        RestArea restarea = new RestArea();
        BattleView battleview = new BattleView();
        BattleView bossbattle = new BattleView();

//        mainmenu.MainMenuFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
//        overworld.OverworldFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
//        instructions.InstructionsFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
//        restarea.RestAreaFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
//        battleview.BattleViewFrame((int)screenSize.getWidth(), (int)screenSize.getHeight(), 1);
//        bossbattle.BattleViewFrame((int)screenSize.getWidth(), (int)screenSize.getHeight(), 2);

        
        mainmenu.MainMenuFrame(1280, 720);
        overworld.OverworldFrame(1280, 720);
        instructions.InstructionsFrame(1280, 720);
        restarea.RestAreaFrame(1280, 720);
        battleview.BattleViewFrame(1280, 720, 1);
        bossbattle.BattleViewFrame(1280, 720, 2);
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(mainmenu);
        frame.setTitle("Second Crusade - First Contact");
        //frame.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        frame.setSize(1280, 720);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while(true){
            Thread.sleep(10);
            if(mainmenu.getNewGame()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(instructions);
                frame.repaint();
                frame.revalidate();
                mainmenu.setNewGame();
            }
            else if(instructions.getContinue()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                instructions.setContinue();
            }
            else if(overworld.getMainMenu()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(mainmenu);
                frame.repaint();
                frame.revalidate();
                overworld.setMainMenu();
            }
            else if(overworld.getBoss()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(bossbattle);
                frame.repaint();
                frame.revalidate();
                overworld.setBoss();
            }
            else if(overworld.getRest()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(restarea);
                frame.repaint();
                frame.revalidate();
                overworld.setRest();
            }
            else if(overworld.getBattle()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(battleview);
                frame.repaint();
                frame.revalidate();
                overworld.setBattle();
            }
            else if(restarea.getReturn()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                restarea.setReturn();
            }
            else if(battleview.getReturn()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                battleview.setReturn();
            }
            else if(bossbattle.getReturn()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                bossbattle.setReturn();
            }
        }
    }
}