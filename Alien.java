import javax.swing.ImageIcon;

public abstract class Alien extends Unit {
	private int health;

	public Alien(int atk, double acc, double speed, double dodge, double sze, String name, ImageIcon image,int hp) {
		super(atk, acc, speed, dodge, sze, name, image);
		health = hp;
	}

	@Override
	public int getHealth(int armourValue) {
		return health;
	}

	@Override
	public void damageTaken(int damage, int armourValue) {
		health -= damage;
	}

	@Override
	public void somethingDied(int armourValue) {
		// Delete this thing lol
	}
	public abstract void takeTurn();	
		//Pick a move and a target basically
		//To make it a good AI
		//want to target weak things in range 
		//have a scoring system
		//bonus points for tanks in front, supports in back

	
}
