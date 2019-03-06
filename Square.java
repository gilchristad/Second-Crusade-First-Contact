package game;

public class Square {
	private Unit unitOnHere;
	// Blocked would be used if an ability puts like spikes on a square so you cant
	// move to it
	private boolean blocked;

	public Square(Unit un) {
		unitOnHere = un;
		blocked = false;
	}

	public void attacked(int damage, int armourValue, double accuracy) {
		if (!unitOnHere.testMiss(accuracy, 0)) {
			// Give testMiss the unit and any modifiers a specific attack has
			// Give test dodge only the unit
			if (!unitOnHere.testDodge()) {
				unitOnHere.damageTaken(damage, armourValue);
				if (unitOnHere.getHealth(armourValue) <= 0) {
					removeUnit(armourValue);
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
		System.out.println("This unit is stunned!!!!!");
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

	public void addUnit(Unit unitToAdd) {
		unitOnHere = unitToAdd;
	}
}
