import javax.swing.ImageIcon;

public class enemySpitter extends Alien{

	static ImageIcon image = new ImageIcon("Images/Icons/alien1.png");
	public enemySpitter(int atk, double acc, double speed, double dodge, double sze, String name, int hp) {
		super(atk, acc, speed, dodge, sze, name, image, hp);
	}
	public void singleAttack(Square target)
	{
		this.attack((int)(this.attackValue*1.5),target,(int)Math.random()*6+1);
	}
	public void spray(Square [] targets) {
		for (int i =0;i<targets.length;i++)
		{
			this.attack((int)(this.getAttackValue()*.8), targets[i],(int)Math.random()*6+1);
		}
		
	}
	public void blindCrusaders(Square target) {
		this.blind(target);
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
			//Move to the front since tank
			if (y!=1){
				System.out.println("moving");
				Square[] list1=highlightMoveOptions(board.getSquare(x,y), board);
				for (int z=0;z<list1.length;z++){
					if (list1[z].getCoordinates()[0]==2){
						this.move(list1[z], board.getSquare(x, y));
						return;}
						
				}
				
			}
			Square[] list2=highlightOtherAttack(board.getSquare(x,y),1,1,board2);
			int moveToUse = (int)(Math.random()*((3)))+1;
			int target;
			System.out.println(moveToUse);
			if (moveToUse==1){
				do {
				target = (int)Math.random()*((list2.length-1));
				}while (list2[target]==null && list2.length>0);
				System.out.println("spitter single attack");
				this.singleAttack(list2[target]);
				
			}
			else if (moveToUse==2){
				do {
				target = (int)Math.random()*((list2.length-1));
				}while (list2[target]==null && list2.length>0);
				Square[] targets=new Square [3];
				targets[0]=list2[target];
				if (list2[target].getCoordinates()[1]>0 &&list2[target].getCoordinates()[1]<3){
				targets[1]=board2.getSquare(x, list2[target].getCoordinates()[1]+1);
				targets[2]=board2.getSquare(x, list2[target].getCoordinates()[1]-1);
				}
				else if (list2[target].getCoordinates()[1]==0){
					targets[1]=board2.getSquare(x, list2[target].getCoordinates()[1]+1);
				}
				else {
					targets[1]=board2.getSquare(x, list2[target].getCoordinates()[1]-1);
				}
				System.out.println("spraying");
				System.out.println(targets);
				this.spray(targets);
	
			}
			else if (moveToUse==3){
				do{
					
				target = (int)Math.random()*((list2.length-1));
				}while (list2[target]==null && list2.length>0);
				System.out.println("blinding");
				this.blindCrusaders(list2[target]);
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
		//This is for meele attacks 
		private static Square[] highlightOtherAttack(Square startSquare,int maxChangeY,int maxChangeX, Board attackedBoard){
			//Loop through enemyBoard and add a square if its a valid target 
			//add a new merhod for regular attacks that has maxchangeinY and x
			//this is for like rnaged stuff
			Square[] result=new Square[16];
			int count=0;
			int maxX=startSquare.getCoordinates()[0]+maxChangeX;
			int maxY=startSquare.getCoordinates()[1]+maxChangeX;
			if (maxX>3){
				maxX=3;
			}
			if (maxY>3){
				maxY=3;
			}
			int minX=startSquare.getCoordinates()[0]-maxChangeX;
			int minY=startSquare.getCoordinates()[1]-maxChangeX;
			if (minX<0){
				minX=0;
			}
			if (minY<0){
				minY=0;
			}
			for (int i = minX;i<=maxX;i++){
				for (int j = minY;j<=maxY;j++){
					//If no one is in the way
					if (i!=0){
						if (attackedBoard.getSquare(i-1, j).selectSquare()==null){
							if (attackedBoard.getSquare(i, j).selectSquare()!=null){
								result[count]=attackedBoard.getSquare(i, j);
								count++;
							}
						}
					}
					else{
						if (attackedBoard.getSquare(i, j).selectSquare()!=null){
							result[count]=attackedBoard.getSquare(i, j);
							count++;
						}
					}
				}
			}
			return result;
		}
}
