import javax.swing.ImageIcon;

public class Cleric extends Crusader {
	//ability methods should call the general attack method with the damage they calculate as well as any other effects they have
	//i.e call the blind method or the stun method, they should be implemented in Unit as well as have a method like attacked in Square
	
	static ImageIcon image = new ImageIcon("Images/Icons/cleric.png");
	public Cleric(int atk, double acc, double speed, double dodge, double size, String name, int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		super(atk, acc, speed, dodge, size, name, image,viHP, laHP, raHP, llHP, rlHP, chHP);
	}
	public void heal(Square target) {
		//Get attack value and modify it by -1 since its supposed to heal.  
		//Not sure if this is how you are supposed to heal crusaders
		this.attack((int) (this.getAttackValue()*(-1.0)), target, -1);
	}
	public void slash(Square target) {
		//Get attack value and modify it by 0.7 since this attack is suppose to be a healer primarily  
		this.attack((int) (this.getAttackValue()*0.7), target, -1);
	}
	public void block (Square target) {
		//Move unit to target square and then block self
		this.protect(target);
	}
	public void holy_light(Square[] targets) {
		for (int i =0; i<targets.length;i++)
		{
			this.attack((int) (this.getAttackValue()*.6), targets[i],-1);
			//Blinds target, lower damage
			this.blind(targets[i]);
		}
	}
}
