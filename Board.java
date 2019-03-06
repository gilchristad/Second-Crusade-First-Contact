package game;

public class Board {
	private Square[][] board;

	public static void main(String args[]) {
		Crusader guy = new Crusader(10, .9, 0.9, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
		Alien enemy = new Alien(5, 0.9, 0.7, 0.8, 0.7, 5);
		Square goodGuy = new Square(guy);
		Square badGuy = new Square(enemy);
		System.out.println(enemy.getHealth(-1));
		guy.attack(guy.getAttackValue(), badGuy, -1);
		System.out.println(enemy.getHealth(-1));
	}

}
