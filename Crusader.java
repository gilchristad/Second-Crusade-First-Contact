import javax.swing.ImageIcon;

public class Crusader extends Unit {
	private int[] armourValues;

	public Crusader(int atk, double acc, double speed, double dodge, double size, String name, ImageIcon image, int viHP, int laHP, int raHP,
			int llHP, int rlHP, int chHP) {
		super(atk, acc, speed, dodge, size, name, image);
		int[] armourValues = new int[6];
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

	@Override
	public void damageTaken(int damage, int armourValue) {
		armourValues[armourValue] -= damage;
	}

	@Override
	public void somethingDied(int armourValue) {
		// Delete the armour that was destroyed, if that type of armour was already
		// destroyed, delete the limb

	}
}
