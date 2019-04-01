import java.awt.BorderLayout;
import java.awt.*;
import java.io.IOException;
import javax.swing.JFrame;

public class Application {

    public static void main(String[] args)
            throws IOException, InterruptedException 
    { 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        Party party = new Party(3);
        
        for (int i = 0; i < 3; i++)
        {
        	Unit y;
        	if (i == 0)
        	{
        		y = new SwordAndShield(10, .9, 0.1, 0.8, 0.8, "swordandshield", 10, 10, 10, 10, 10, 10);
        	}
        	else if (i== 1)
        	{
                y = new Cleric(10, .9, 0.2, 0.8, 0.8, "cleric", 10, 10, 10, 10, 10, 10);
        	}
        	else
        	{
                y= new Archer(10, .9, 0.3, 0.8, 0.8, "archer",10, 10, 10, 10, 10, 10);
        	}
			party.setParty(i, y);
        }
        
        MainMenu mainmenu = new MainMenu();
        Overworld overworld = new Overworld();
        Instructions instructions = new Instructions();
        RestArea restarea = new RestArea();
        BattleView battleview = new BattleView();
        BattleView bossbattle = new BattleView();

        mainmenu.MainMenuFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        overworld.OverworldFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        instructions.InstructionsFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        restarea.RestAreaFrame((int)screenSize.getWidth(), (int)screenSize.getHeight());
        battleview.BattleViewFrame((int)screenSize.getWidth(), (int)screenSize.getHeight(), 1, party);
        bossbattle.BattleViewFrame((int)screenSize.getWidth(), (int)screenSize.getHeight(), 2, party);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(mainmenu);
        frame.setTitle("Second Crusade - First Contact");
        frame.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        mainmenu.menuclip.start();

        while(true){
            Thread.sleep(10);
            if(mainmenu.getNewGame()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(instructions);
                frame.repaint();
                frame.revalidate();
                mainmenu.setNewGame();
                mainmenu.menuclip.stop();

            }
            else if(instructions.getContinue()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                instructions.setContinue();
                overworld.overworldclip.start();
            }
            else if(overworld.getMainMenu()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(mainmenu);
                frame.repaint();
                frame.revalidate();
                overworld.setMainMenu();
                mainmenu.menuclip.start();
                overworld.overworldclip.stop();
            }
            else if(overworld.getBoss()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(bossbattle);
                frame.repaint();
                frame.revalidate();
                overworld.setBoss();
                bossbattle.bossclip.start();
                overworld.overworldclip.stop();
            }
            else if(overworld.getRest()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(restarea);
                frame.repaint();
                frame.revalidate();
                overworld.setRest();
                restarea.restclip.start();
                overworld.overworldclip.stop();
            }
            else if(overworld.getBattle()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(battleview);
                frame.repaint();
                frame.revalidate();
                overworld.setBattle();
                battleview.battleclip.start();
                overworld.overworldclip.stop();

            }
            else if(restarea.getReturn()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                restarea.setReturn();
                restarea.restclip.stop();
                overworld.overworldclip.start();
            }
            else if(battleview.getReturn()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                battleview.setReturn();
                overworld.overworldclip.start();
                battleview.battleclip.stop();
            }
            else if(bossbattle.getReturn()){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(overworld);
                frame.repaint();
                frame.revalidate();
                bossbattle.setReturn();
                overworld.overworldclip.start();
                bossbattle.bossclip.stop();
            }
        }
        
    }
}