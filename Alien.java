package game;

public class Alien extends Unit {
	private int health;

	public Alien(int atk, double acc, double speed, double dodge, double sze, int hp) {
		super(atk, acc, speed, dodge, sze);
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

}
