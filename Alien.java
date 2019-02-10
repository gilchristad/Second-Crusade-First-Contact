package game;

public class Alien extends Unit{

	public Alien(int atk, int acc, int spd, int dge, int sze, int hp) {
		super(atk, acc, spd, dge, sze);
		// TODO Auto-generated constructor stub
	}

	private int health;

	@Override
	public int getHealth(int armourValue) {
		return health;
	}

	@Override
	public void damageTaken(int damage, int armourValue) {
		health-=damage;
	}

	@Override
	public void somethingDied(int armourValue) {
		//Delete this thing lol
	}

}
