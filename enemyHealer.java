import javax.swing.ImageIcon;

public class enemyHealer extends Alien{

	static ImageIcon image = new ImageIcon("Images/Icons/aliengross.png");
	public enemyHealer(int atk, double acc, double speed, double dodge, double sze, String name, int hp) {
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
	}

	public void takeTurn(Board board, Board board2) {
		//Find where we are on the board 
			int x=-1;
			int y=-1;
			for (int i=0;i<=3;i++){
				for (int j=0;j<=3;j++){
					
				if (board.getSquare(i, j).selectSquare()==this){
					x=i;
					y=j;
				}
				}
			}
			if (y<2){
				System.out.println("moving");
				Square[] list1=highlightMoveOptions(board.getSquare(x,y), board);
				for (int z=0;z<list1.length;z++){
					if (list1[z]!=null){
					if (list1[z].getCoordinates()[0]==3){
						this.move(list1[z], board.getSquare(x, y));
						return;}}
						
				}
				
			}
			Square[] list3=highlightBuffOptions(board);
			int moveToUse = (int)(Math.random()*((3)))+1;
			int target;
			System.out.println(moveToUse);
			if (moveToUse==1){
				do {
				target = (int)Math.random()*((list3.length-1));
				}while (list3[target]==null && list3.length>0);
				System.out.println("healing");
				this.heal(list3[target]);
				
			}
			else if (moveToUse==2){
				do {
				target = (int)Math.random()*((list3.length-1));
				}while (list3[target]==null && list3.length>0);
				System.out.println("healing");
				this.speed_up(list3[target]);
				
			}
	
			
			else if (moveToUse==3){
				do{
				target = (int)Math.random()*((list3.length-1));
				}while (list3[target]==null && list3.length>0);
				System.out.println("protecting");
				this.protect(list3[target]);
			}
		 }	
		private static Square[] highlightMoveOptions(Square startSquare, Board board){
			int x=startSquare.getCoordinates()[0];
			int y=startSquare.getCoordinates()[1];
			//Make an array of all squares that you can mvoe to with 3 move points
			Square[] result=new Square[11];
			int count=0;
			int [] directions={0,1,2,-1,-2};
			for (int i =0;i<directions.length;i++){
				for (int q =0;q<directions.length;q++){
					//We can move in those directions 
					if (Math.abs(directions[i])+Math.abs(directions[q])<=2){
						if (directions[i]+x>=0 &&directions[i]+x<=3){
							if (directions[q]+y>=0 &&directions[q]+y<=3){
								if (board.getSquare(directions[i]+x, directions[q]+y).selectSquare()==null){
									result[count]=board.getSquare(directions[i]+x, directions[q]+y);
									count++;
								}
							}
						}
					}
				}
			}
			return result;
		}
		//This is for buffs 
		private static Square[] highlightBuffOptions(Board teamBoard){
				//Loop through enemyBoard and add a square if its a valid target 
				//add a new merhod for regular attacks that has maxchangeinY and x
				//this is for like rnaged stuff
				Square[] result=new Square[16];
				int count=0;
				for (int i=0;i<=3;i++)
				{
					for (int j=0;j<=3;j++){
						//Someone is on it
						if (teamBoard.getSquare(i, j).selectSquare()!=null){
							result[count]=teamBoard.getSquare(i, j);
							count++;
						}
					}
				}
				return result;
			}

}
