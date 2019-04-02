public class Square {
	private Unit unitOnHere = null;
	public int result = 0;
	private int coordinates[];
	public Square(Unit un) {
		unitOnHere = un;
		coordinates= new int[2];
	}

	public int attacked(int damage, int armourValue, double accuracy) {
		if (!unitOnHere.testMiss(accuracy, 0)) {
			// Give testMiss the unit and any modifiers a specific attack has
			// Give test dodge only the unit
			if (!unitOnHere.testDodge()) {
				unitOnHere.damageTaken(damage, armourValue);
				if (unitOnHere.getHealth(armourValue) <= 0) {
					unitOnHere.somethingDied(armourValue, this);
					if (armourValue==5 || armourValue==-1){
						removeUnit();
					}
					System.out.println("armor hit??");
					result = 0;
				}
			} else {
				System.out.println("A dodge happened");
				result = 1;
			}
		} else {
			// The enemy missed, have it target a different square
			System.out.println("A miss happened");
			result = 2;
		}
		return result;
	}
	public void stunned() {
		unitOnHere.stunned=true;
	}
	public void blind() {
		unitOnHere.accuracyValue-=0.2;
	}
	public void protect() {
		unitOnHere.dodgeValue+=0.2;
	}
	public void buff(int which, int howMuch) {
		if(which==0){
			unitOnHere.attackValue+=howMuch;
		}
		else if(which==1){
			unitOnHere.accuracyValue+=howMuch;
		}
		else if(which==2){
			unitOnHere.speedValue+=howMuch;
		}
		else if(which==3){
			unitOnHere.dodgeValue+=howMuch;
		}
		else if(which==4){
			unitOnHere.sizeValue+=howMuch;
		}
	}
	public Unit selectSquare() {
		return unitOnHere;
	}

	public void hover() {
		// Highlight the square that is hovered
	}

	public void removeUnit() {
		//unitOnHere.somethingDied(armourValue);
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
