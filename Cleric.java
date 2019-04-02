import javax.swing.ImageIcon;

public class Cleric extends Crusader {
	//ability methods should call the general attack method with the damage they calculate as well as any other effects they have
	//i.e call the blind method or the stun method, they should be implemented in Unit as well as have a method like attacked in Square
	
	static ImageIcon image = new ImageIcon("Images/Icons/cleric.png");
	public Cleric(int atk, double acc, double speed, double dodge, double size, String name, int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		super(atk, acc, speed, dodge, size, name, image,viHP, laHP, raHP, llHP, rlHP, chHP);
	}
}
