import java.awt.BorderLayout;
import java.awt.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application {
    
    public static void main(String[] args) throws IOException, InterruptedException 
    { 
        MainMenu mainmenu = new MainMenu();
        Overworld overworld = new Overworld();
        Instructions instructions = new Instructions();
        RestArea restarea = new RestArea();
        BattleView battle = new BattleView();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainmenu.MainMenuFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        overworld.OverworldFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        instructions.InstructionsFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        restarea.RestAreaFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        battle.BattleViewFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(mainmenu);
        frame.setTitle("Second Crusade - First Contact");
        frame.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
            else if(overworld.getBoss()){

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
                frame.getContentPane().add(battle);
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
        }
    }
    public void switchPanels(JPanel panel){

    }
}