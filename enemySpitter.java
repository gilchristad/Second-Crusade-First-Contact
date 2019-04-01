public class enemySpitter extends Alien{

	public enemySpitter(int atk, double acc, double speed, double dodge, double sze, int hp) {
		super(atk, acc, speed, dodge, sze, hp);
	}
	public void block(Square target)
	{
		this.protect(target);
	}
	public void spray(Square [] targets) {
		for (int i =0;i<targets.length;i++)
		{
			this.attack((int)(this.getAttackValue()*.8), targets[i],(int)Math.random()*6+1);
		}
		
	}
	public void blind(Square target) {
		//https://imgur.com/gallery/6Hrxm
		//Pick a number from 1-6 to attack for the last value
		
		//this.attack((int)(this.getAttackValue()*0.5), target, 4);
		//blind multiple squares?
		this.blind(target);
	}

	@Override
	public void takeTurn() {
		//Want to be in the middle, close enough to hit but not get hit by everything 
		//blind is good when enemies are clumped 
		//spray is good when enemies are lined up
		//add a general attack that does a shitton
	}


}
