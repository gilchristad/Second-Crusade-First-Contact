import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException 
    { 
        MainMenu mainmenu = new MainMenu();
        Overworld overworld = new Overworld();
        Instructions instructions = new Instructions();

        mainmenu.MainMenuFrame();
        overworld.OverworldFrame();
        instructions.InstructionsFrame();

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(mainmenu);
        frame.setTitle("Second Crusade - First Contact");
        frame.setSize(1920, 1080);
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
        }
    }
    public void switchPanels(JPanel panel){

    }
}