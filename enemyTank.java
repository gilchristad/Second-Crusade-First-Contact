import javax.swing.ImageIcon;

public class enemyTank extends Alien{

	static ImageIcon image = new ImageIcon("Images/Icons/alien2.png");
	public enemyTank(int atk, double acc, double speed, double dodge, double sze, String name, int hp) {
		super(atk, acc, speed, dodge, sze, name, image, hp);
	}
	public void block(Square target)
	{
		this.protect(target);
	}
	public void knockback(Square [] targets) {
		//This will be damage plus moving, pick random part of crusader to attack
		for (int i =0;i<targets.length;i++)
		{
			this.attack((int)(this.getAttackValue()*.7), targets[i],(int)Math.random()*6+1);
		}
		
	}
	public void wack(Square target) {
		//https://imgur.com/gallery/6Hrxm
		//Pick a number from 1-6 to attack for the last value
		this.attack((int)(this.getAttackValue()*0.5), target, 4);
		this.stun(target);
	}
	public int evaluateBoard(Board board){
		int result=0;
		for (int i=0;i<=3;i++){
			for (int j=0;j<=3;j++){
				Square currentTile=board.getSquare(i, j);
				//Scoring based on position of units 
				if (currentTile.selectSquare()!=null){
					Unit currentUnit=currentTile.selectSquare();
					if (currentUnit.name=="swordandshield" || currentUnit.name=="tank"){
						result += i;
					}
					if (currentUnit.name=="archer" ||currentUnit.name=="boss"|| currentUnit.name=="healer"|| currentUnit.name=="cleric"){
						result -= i;
					}
					if (currentUnit.name=="spitter"){
						result -= i-1;
					}
					if (currentUnit.name=="swordandshield" || currentUnit.name=="archer" ||currentUnit.name=="cleric")
					{
						int health=0;
						for (int t=0;t<=5;t++){
							health +=currentUnit.getHealth(t);
						}
						health/=6;
						result -=health;
					}
					//Were on the alien board 
					else {
						result -=currentUnit.getHealth(-1);
					}
				}
			}
		}
		return result;
	}
	@Override
	public void takeTurn(Board board, Board board2) {
		int x=-1;
		int y=-1;
		Board testBoard=board;
		Board testBoard2=board2;
		//Find where we are on the board 
		for (int i=0;i<=3;i++){
			for (int j=0;j<=3;j++){
				if (board.getSquare(i, j).selectSquare()==this){
					x=i;
					y=j;
				}
			}
		}
		//Want low points
		int origScore=evaluateBoard(board);
		Square[] list1=highlightMoveOptions(testBoard.getSquare(x,y), testBoard);
		//He can only hit right in front of him
		Square[] list2=highlightOtherAttack(testBoard.getSquare(x,y),1,1,testBoard2);
		Square[] list3=highlightBuffOptions(testBoard);
		enemyTank testTank=this;
		//Loop through potential moves 
		int maxScore=1000000;
		int bestMove=-1;
		int bestTarget=-1;
		int moreSpecifically=-1;
		for (int i=0;i<=2;i++){
			if (i==0){
				for (int j=0;j<=list1.length;j++){
					testBoard=board;
					testTank=this;
					//MOVE TO A TILE
					testTank.move();
					int tryScore=evaluateBoard(testBoard);
					if (tryScore-origScore<maxScore){
						maxScore=tryScore-origScore;
						bestMove=i;
						bestTarget=j;
					}

				}
			}
			else if (i==1){
				for (int j=0;j<=list2.length;j++){
					testBoard2=board2;
					testTank=this;
					testTank.wack(list2[j]);
					int tryScore=evaluateBoard(testBoard2);
					if (tryScore-origScore<maxScore){
						maxScore=tryScore-origScore;
						bestMove=i;
						bestTarget=j;
						moreSpecifically=2;
					}

				}
				for (int j=0;j<=list1.length;j++){
					testBoard2=board;
					testTank=this;
					//MOVE TO A TILE
					Square[] targets=new Square [3];
					targets[0]=list2[j];
					if (list2[j].getCoordinates()[1]>0 &&list2[j].getCoordinates()[1]<3){
						targets[1]=testBoard2.getSquare(x, list2[j].getCoordinates()[1]+1);
						targets[2]=testBoard2.getSquare(x, list2[j].getCoordinates()[1]-1);
					}
					else if (list2[j].getCoordinates()[1]==0){
						targets[1]=testBoard2.getSquare(x, list2[j].getCoordinates()[1]+1);
					}
					else {
						targets[1]=testBoard2.getSquare(x, list2[j].getCoordinates()[1]-1);
					}
					testTank.knockback(targets);
					int tryScore=evaluateBoard(testBoard2);
					if (tryScore-origScore>maxScore){
						maxScore=tryScore-origScore;
						bestMove=i;
						bestTarget=j;
						moreSpecifically=1;
					}

				}
			}
			else{
				for (int j=0;j<=list3.length;j++){
					testBoard=board;
					testTank=this;
					testTank.block(list3[j]);
					int tryScore=evaluateBoard(testBoard);
					//Compensate since blocking isnt measured in evaluate
					tryScore-=2;
					if (tryScore-origScore<maxScore){
						maxScore=tryScore-origScore;
						bestMove=i;
						bestTarget=j;
					}

				}
			}

		}
		if (bestMove==0){
			//ADD TARGET SQUARE
			this.move();
		}
		else if (bestMove==1){
			if (moreSpecifically==1){
				Square[] targets=new Square [3];
				targets[0]=list2[bestTarget];
				if (list2[bestTarget].getCoordinates()[1]>0 &&list2[bestTarget].getCoordinates()[1]<3){
					targets[1]=board.getSquare(x, list2[bestTarget].getCoordinates()[1]+1);
					targets[2]=testBoard.getSquare(x, list2[bestTarget].getCoordinates()[1]-1);
				}
				else if (list2[bestTarget].getCoordinates()[1]==0){
					targets[1]=testBoard.getSquare(x, list2[bestTarget].getCoordinates()[1]+1);
				}
				else {
					targets[1]=testBoard.getSquare(x, list2[bestTarget].getCoordinates()[1]-1);
				}
				this.knockback(targets);
			}
			else {
				this.wack(list2[bestTarget]);
			}
		}
		else if (bestMove==2){
			this.protect(list3[bestTarget]);
		}
		System.out.print("Best move");
		System.out.print(bestMove);
		System.out.println();
		System.out.print("Best target");
		System.out.print(bestTarget);

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
    //This is for ranged attacks 
    private static Square[] highlightAttackOptions(int upperRangeY,int lowerRangeY,int upperRangeX,int lowerRangeX, Board attackedBoard){
        //Loop through enemyBoard and add a square if its a valid target 
        //add a new merhod for regular attacks that has maxchangeinY and x
        //this is for like rnaged stuff
        Square[] result=new Square[16];
        int count=0;
        for (int i=lowerRangeX;i<=upperRangeX;i++)
        {
            for (int j=lowerRangeY;j<=upperRangeY;j++){
                //Someone is on it
                if (attackedBoard.getSquare(i, j).selectSquare()!=null){
                    result[count]=attackedBoard.getSquare(i, j);
                    count++;
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
                if (attackedBoard.getSquare(i-1, j).selectSquare()==null){
                    if (attackedBoard.getSquare(i, j).selectSquare()!=null){
                        result[count]=attackedBoard.getSquare(i, j);
                        count++;
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
