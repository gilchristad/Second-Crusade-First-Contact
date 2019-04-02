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
	public void restoreHealth(int i, int j)
	{
		
	}

	@Override
	public void damageTaken(int damage, int armourValue) {
		health -= damage;
	}

	@Override
	public Square somethingDied(int armourValue, Square x) {
		return x;
	}
	public abstract void takeTurn(Board board, Board board2);	

	
}
