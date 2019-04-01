import javax.swing.*;

public class Archer extends Crusader {
	//ability methods should call the general attack method with the damage they calculate as well as any other effects they have
	//i.e call the blind method or the stun method, they should be implemented in Unit as well as have a method like attacked in Square
	
	static ImageIcon image = new ImageIcon("Images/Icons/archer.png");
	public Archer(int atk, double acc, double speed, double dodge, double size, String name,int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		super(atk, acc, speed, dodge, size, name, image, viHP, laHP, raHP, llHP, rlHP, chHP);
	}
	public void snipe(Square target) {
		//Get attack value and modify it by 2.0 since this attack is suppose to DPS  
		this.attack((int) (this.getAttackValue()*2.0), target, -1);
	}
	public void shoot(Square target) {
		//Get attack value and modify it by 1.2 since this attack is suppose to be damage primarily  
		this.attack((int) (this.getAttackValue()*1.2), target, -1);
	}
	public void block (Square target) {
		//Move unit to target square and then block self
		this.protect(target);
	}
	public void rain(Square[] targets) {
		for (int i =0; i<targets.length;i++)
		{
			this.attack((int) (this.getAttackValue()*.9), targets[i],-1);
		}
	}
}
