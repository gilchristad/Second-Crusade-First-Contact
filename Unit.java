package game;

public abstract class Unit {
	//Base strength used to calculate damage
	private int attackValue;
	//Base accuracy used to calculate misses
	private int accuracyValue;
	//Base speed used to calculate turn order
	private int speedValue;
	//Base dodge power to calculate dodges
	private int dodgeValue;
	//Base size used to calculate misses
	private int sizeValue;
	public Unit(int atk,int acc,int spd, int dge, int sze){
		attackValue=atk;
		accuracyValue=acc;
		speedValue=spd;
		dodgeValue=dge;
		sizeValue=sze;
	}
	
	public void move() {
		//IDK Dijkstra or a* or something 
	}
	public void attack(int damage, Square target, int armourValue) {
		target.attacked(damage,armourValue);
	}
	public boolean testMiss() {
		return false;
	}
	public boolean testDodge() {
		return false;
	}
	public abstract int getHealth(int armourValue);
	public abstract void damageTaken(int damage, int armourValue);
	public abstract void somethingDied(int armourValue);
}
