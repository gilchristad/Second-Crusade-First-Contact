import javax.swing.ImageIcon;
public abstract class Unit {
	public int result = 0;
	// Base strength used to calculate damage
	public int attackValue;
	// Base accuracy used to calculate misses
	public double accuracyValue;
	// Base speed used to calculate turn order
	public double speedValue;
	// Base dodge power to calculate dodges
	public double dodgeValue;
	// Base size used to calculate misses
	public double sizeValue;
	public boolean blinded=false;
	public boolean stunned=false;
	public int buff=0;
	public boolean turn=false;
	public boolean wasProtected=false;
	public String name;
	public ImageIcon image;
	public Unit(int atk, double acc, double speed, double dodge, double size, String unitClass, ImageIcon icon) {
		attackValue = atk;
		accuracyValue = acc;
		speedValue = speed;
		dodgeValue = dodge;
		sizeValue = size;
		name = unitClass;
		image = icon;
	}

	public void move(Square target, Square origSquare) {

		target.move(this,origSquare);
	}

	public int attack(int damage, Square target, int armourValue) {
		if (target.selectSquare() != null) {
			result = target.attacked(damage, armourValue, accuracyValue);
			return result;
		}
		return result;
	}

	public void stun(Square target) {
		if (target.selectSquare() != null) {
			target.stunned();
		}

	}
	//IDK maybe increase a teammates/ your own defense
	public void protect (Square target)
	{
		target.protect();
	}
	public void blind (Square target)
	{
		if (target.selectSquare() != null) {
			target.blind();
		}
	}
	public void blockSquare(Square target) {
		System.out.println("Cant use this tile anymroe sucker");
	}
	public void buff(Square target,int statToBuff,int howMuchToBuff) {
		target.buff(statToBuff,howMuchToBuff);
	}
	public boolean testMiss(double enemyAcc, int modifier) {
		// The bigger the character, the easier to hit
		double needToBeat = (enemyAcc - modifier) * sizeValue;
		double prob = Math.random();
		//System.out.println(needToBeat);
		//System.out.println(prob);
		if (prob > needToBeat) {
			return true;
		}
		return false;

	}

	public boolean testDodge() {
		// Take speed and dodge values, multiply them, higher number is more likely to
		// dodge
		double needToBeat = speedValue * dodgeValue;
		double prob = Math.random();
		//System.out.println(needToBeat);
		//System.out.println(prob);
		if (prob < needToBeat) {
			return true;
		}
		return false;
	}

	public int getAttackValue() {
		return attackValue;
	}
	public void startTurn(){
		turn=true;
	}
	public void endTurn(){
		turn=false;
		if (blinded)
		{
			this.accuracyValue+=0.2;
		}
		if (wasProtected)
		{
			this.dodgeValue-=0.2;
		}
		this.stunned=false;
	}
	public abstract void takeTurn(Board board, Board board2);
	public abstract int getHealth(int armourValue);
	
	public abstract void damageTaken(int damage, int armourValue);

	public abstract void somethingDied(int armourValue);

	public abstract void restoreHealth(int i, int j);
}
