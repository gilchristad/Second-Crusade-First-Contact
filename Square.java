public class Square {
	private Unit unitOnHere = null;
	// Blocked would be used if an ability puts like spikes on a square so you cant
	// move to it
	private boolean blocked;
	private int coordinates[];
	public Square(Unit un) {
		unitOnHere = un;
		blocked = false;
		coordinates= new int[2];
	}

	public void attacked(int damage, int armourValue, double accuracy) {
		if (!unitOnHere.testMiss(accuracy, 0)) {
			// Give testMiss the unit and any modifiers a specific attack has
			// Give test dodge only the unit
			if (!unitOnHere.testDodge()) {
				unitOnHere.damageTaken(damage, armourValue);
				if (unitOnHere.getHealth(armourValue) <= 0) {
					removeUnit(armourValue);
					System.out.println("armor hit??");
				}
			} else {
				// move the unit to where it can be moved
				System.out.println("A dodge happened");
			}
		} else {
			// The enemy missed, have it target a different square
			System.out.println("A miss happened");
		}
	}
	public void stunned() {
		unitOnHere.stunned=true;
	}
	public void blind() {
		unitOnHere.accuracyValue-=0.2;
	}
	public Unit selectSquare() {
		return unitOnHere;
	}

	public void hover() {
		// Highlight the square that is hovered
	}

	public void removeUnit(int armourValue) {
		unitOnHere.somethingDied(armourValue);
		unitOnHere = null;
	}
	public void move(Unit unitToMove,Square orig){
		orig.unitOnHere=null;
		this.unitOnHere=unitToMove;
	}
	public void addUnit(Unit unitToAdd) {
		unitOnHere = unitToAdd;
	}
	public void setCoordinates(int x,int y){
		coordinates[0]=x;
		coordinates[1]=y;
	}
	public int[] getCoordinates(){
		return coordinates;
	}
}
