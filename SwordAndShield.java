import javax.swing.ImageIcon;

public class SwordAndShield extends Crusader {
	static ImageIcon image = new ImageIcon("Images/Icons/axeboy.png");

	public SwordAndShield(int atk, double acc, double speed, double dodge, double size, String name, int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		
		super(atk, acc, speed, dodge, size, name, image, viHP, laHP, raHP, llHP, rlHP, chHP);
	}
}
