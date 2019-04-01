import javax.swing.ImageIcon;

public class SwordAndShield extends Crusader {
	//ability methods should call the general attack method with the damage they calculate as well as any other effects they have
	//i.e call the blind method or the stun method, they should be implemented in Unit as well as have a method like attacked in Square
	static ImageIcon image = new ImageIcon("Images/Icons/axeboy.png");

	public SwordAndShield(int atk, double acc, double speed, double dodge, double size, String name, int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		
		super(atk, acc, speed, dodge, size, name, image, viHP, laHP, raHP, llHP, rlHP, chHP);
	}
	public void shieldBash(Square target) {
		//Get attack value and modify it by 0.5 since this attack is suppose to be a stun primarily  
		this.attack((int) (this.getAttackValue()*0.5), target, -1);
		//Then call the stun method
		//Maybe only call if the attack hit
		//FOR NOW IT ALWAYS STUNS
		this.stun(target);
	}
	public void slash(Square target) {
		//Get attack value and modify it by 1.2 since this attack is suppose to be damage primarily  
		this.attack((int) (this.getAttackValue()*1.2), target, -1);
	}
	public void block (Square target) {
		//Move unit to target square and then block self
		this.protect(target);
	}
	public void slice(Square[] targets) {
		for (int i =0; i<targets.length;i++)
		{
			this.attack((int) (this.getAttackValue()*.9), targets[i],-1);
		}
	}
}
