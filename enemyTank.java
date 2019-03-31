public class enemyTank extends Alien{

	public enemyTank(int atk, double acc, double speed, double dodge, double sze, int hp) {
		super(atk, acc, speed, dodge, sze, hp);
	}
	public void block(Square target)
	{
		this.protect(target);
	}
	public void knockback(Square [] targets) {
		//This will be damage plus moving, pick random part of crusader to attack
		for (int i =0;i<targets.length;i++)
		{
			this.attack((int)(this.getAttackValue()*.7), targets[i],(int)Math.random()*6+1);
		}
		
	}
	public void wack(Square target) {
		//https://imgur.com/gallery/6Hrxm
		//Pick a number from 1-6 to attack for the last value
		this.attack((int)(this.getAttackValue()*0.5), target, 4);
		this.stun(target);
	}


}
