import javax.swing.ImageIcon;

public class enemyBoss extends Alien{
	static ImageIcon image = new ImageIcon("Images/Icons/alienboss.png");
	public enemyBoss(int atk, double acc, double speed, double dodge, double sze, String name, int hp) {
		super(atk, acc, speed, dodge, sze, name, image, hp);
	}
	public void block(Square target)
	{
		this.protect(target);
	}
	public void speed_up(Square target) {
		//This will be damage plus moving, pick random part of crusader to attack
		
//		for (int i =0;i<targets.length;i++)
//		{
//			this.attack((int)(this.getAttackValue()*0.7), targets[i],(int)Math.random()*6+1);
//		}
		
		//If i enumerate all the stats in the unit class, speed is 2.
		this.buff(target, 2, 5);
		
	}
	public void heal(Square target) {
		//https://imgur.com/gallery/6Hrxm
		//Pick a number from 1-6 to attack for the last value
		
		//Not sure if this is the correct way to heal an alien
		this.attack((int)(this.getAttackValue()*(-0.8)), target,-1);
		
		
		this.stun(target);
	}
	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeTurn() {
		//Do something lol
	}


}
