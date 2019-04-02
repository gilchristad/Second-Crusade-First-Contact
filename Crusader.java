import javax.swing.ImageIcon;

public class Crusader extends Unit {
	private int[] armourValues= new int[6];

	public Crusader(int atk, double acc, double speed, double dodge, double size, String name, ImageIcon image, int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		super(atk, acc, speed, dodge, size, name, image);
		armourValues[0] = viHP;
		armourValues[1] = laHP;
		armourValues[2] = raHP;
		armourValues[3] = llHP;
		armourValues[4] = rlHP;
		armourValues[5] = chHP;
		
	}
	// 0=visor,1=LA, 2=RA, 3=LL,4=RL,5=Chest,-1=alien

	@Override
	public int getHealth(int armourValue) {
		return armourValues[armourValue];
	}
	
	public void restoreHealth(int armourValue, int heal)
	{
		armourValues[armourValue]+=(10-armourValues[armourValue]);
	}

	@Override
	public void damageTaken(int damage, int armourValue) {
		armourValues[armourValue] -= damage;
	}

	@Override
	public void somethingDied(int armourValue) {
		//If armour already destroyed 
		if (armourValues[armourValue]==-1){
			if (armourValue==0){
				this.accuracyValue-=0.4;
			}
			else if (armourValue==1){
				this.attackValue-=2;
			}
			else if (armourValue==2){
				this.attackValue-=2;
			}
			else if (armourValue==3){
				this.dodgeValue-=0.3;
			}
			else if (armourValue==4){
				this.dodgeValue-=0.3;
			}
		}
		else {
			armourValues[armourValue]=-1;
		}

	}

	//Cleric
	public int heal(Square target) {
		//Get attack value and modify it by -1 since its supposed to heal.  
		//Not sure if this is how you are supposed to heal crusaders
		return this.attack((int) (this.getAttackValue()*(-1.0)), target, -1);
	}
	public int clericslash(Square target) {
		//Get attack value and modify it by 0.7 since this attack is suppose to be a healer primarily  
		return this.attack((int) (this.getAttackValue()*0.7), target, -1);
	}
	public void clericblock (Square target) {
		//Move unit to target square and then block self
		this.protect(target);
	}
	public int holy_light(Square target) {
		this.blind(target);
		return this.attack((int) (this.getAttackValue()*.6), target,-1);
			//Blinds target, lower damage
		
	}
	//Swordsman
	public int hiltdBash(Square target) { 
		this.stun(target);

		return this.attack((int) (this.getAttackValue()*0.5), target, -1);
	}
	public int swordsmanslash(Square target) {
		//Get attack value and modify it by 1.2 since this attack is suppose to be damage primarily  
		return this.attack((int) (this.getAttackValue()*1.2), target, -1);
	}
	public void swordsmanblock (Square target) {
		//Move unit to target square and then block self
		this.protect(target);
	}
	public int slice(Square target) {
		
		return this.attack((int) (this.getAttackValue()*.9), target,-1);
		
	}
	//Sword and Shield
	public int sashiltdBash(Square target) {
		//Then call the stun method
				//Maybe only call if the attack hit
				//FOR NOW IT ALWAYS STUNS
		this.stun(target);
		//Get attack value and modify it by 0.5 since this attack is suppose to be a stun primarily  
		return this.attack((int) (this.getAttackValue()*0.5), target, -1);
	}
	public int slash(Square target) {
		//Get attack value and modify it by 1.2 since this attack is suppose to be damage primarily  
		return this.attack((int) (this.getAttackValue()*1.2), target, -1);
	}
	public void sasblock (Square target) {
		//Move unit to target square and then block self
		this.protect(target);
	}
	public int sasslice(Square target) {
		return this.attack((int) (this.getAttackValue()*.9), target,-1);
	}
	//Archer
	public int snipe(Square target) {
		//Get attack value and modify it by 2.0 since this attack is suppose to DPS  
		return this.attack((int) (this.getAttackValue()*2.0), target, -1);
	}
	public int shoot(Square target) {
		//Get attack value and modify it by 1.2 since this attack is suppose to be damage primarily  
		return this.attack((int) (this.getAttackValue()*1.2), target, -1);
	}
	public void block (Square target) {
		//Move unit to target square and then block self
		this.protect(target);
	}
	public int rain(Square target) {
		
		return this.attack((int) (this.getAttackValue()*.9), target,-1);
		
	}

	@Override
	public void takeTurn(Board board, Board board2) {
		//just wait until the player has picked a move basically
	}
}
