package game;

public class Square {
	private Unit unitOnHere;
	//Blocked would be used if an ability puts like spikes on a square so you cant move to it
	private boolean blocked;
	public Square(Unit un){
		unitOnHere=un;
		blocked=false;
	}
	public void attacked(int damage,int armourValue){
		unitOnHere.damageTaken(damage, armourValue);
		if (unitOnHere.getHealth(armourValue)<=0) {
			removeUnit(armourValue);
		}
	}
	public Unit selectSquare() {
		return unitOnHere;
	}
	public void hover() {
		//Highlight the square that is hovered
	}
	public void removeUnit(int armourValue) {
		unitOnHere.somethingDied(armourValue);
		unitOnHere=null;
	}
	public void addUnit(Unit unitToAdd) {
		unitOnHere=unitToAdd;
	}
}
