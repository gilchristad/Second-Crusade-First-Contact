import javax.swing.ImageIcon;

public class Swordsman extends Crusader {
	static ImageIcon image = new ImageIcon("Images/Icons/crusaderbattle.png");

	public Swordsman(int atk, double acc, double speed, double dodge, double size, String name, int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		
		super(atk, acc, speed, dodge, size, name, image, viHP, laHP, raHP, llHP, rlHP, chHP);
	}
}
