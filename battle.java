public class battle {
	private Square[][] board;

	public static void main(String args[]) {
        SwordAndShield guy1 = new SwordAndShield(10, .9, 0.9, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy2 = new Crusader(10, .9, 0.9, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy3= new Crusader(10, .9, 0.9, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy4 = new Crusader(10, .9, 0.9, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy5 = new Crusader(10, .9, 0.9, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Alien enemy1 = new Alien(5, 0.9, 0.7, 0.8, 0.7, 5);
        Alien enemy2 = new Alien(5, 0.9, 0.7, 0.8, 0.7, 5);
        Alien enemy3 = new Alien(5, 0.9, 0.7, 0.8, 0.7, 5);
        Alien enemy4 = new Alien(5, 0.9, 0.7, 0.8, 0.7, 5);
        Alien enemy5 = new Alien(5, 0.9, 0.7, 0.8, 0.7, 5);
        Board cruBoard= new Board(4,4);
        Board alienBoard= new Board(4,4);
        cruBoard.getSquare(1, 1).addUnit(guy1);
        alienBoard.getSquare(1, 1).addUnit(enemy1);
        System.out.println("Orig HP");
		System.out.println(enemy1.getHealth(-1));
        guy1.slash(alienBoard.getSquare(1,1));
        System.out.println("After HP");
		System.out.println(enemy1.getHealth(-1));
	}

}
