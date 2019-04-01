    import java.lang.Math;
    public class battle {

    Unit[] characters;
    Board cruBoard;
    Board alienBoard;
    public battle(int type, Party party) {
        int counter = 0;
        characters = new Unit[32];
        
        cruBoard= new Board(4,4);
        cruBoard.getSquare(1, 3).addUnit(party.getParty(0));
        cruBoard.getSquare(1, 2).addUnit(party.getParty(2));
        cruBoard.getSquare(1, 1).addUnit(party.getParty(1));
        alienBoard= new Board(4,4);
        if (type == 1)
        {
            enemyHealer enemy1 = new enemyHealer(5, 0.9, 0.6, 0.8, 0.7, "healer", 5);
            enemySpitter enemy2 = new enemySpitter(5, 0.9, 0.7, 0.8, 0.7, "spitter", 5);
            enemyTank enemy3 = new enemyTank(5, 0.9, 0.8, 0.8, 0.7, "tank", 5);
        	alienBoard.getSquare(3, 3).addUnit(enemy1);
        	alienBoard.getSquare(2, 2).addUnit(enemy2);
        	alienBoard.getSquare(1, 1).addUnit(enemy3);
            alienBoard.getSquare(0, 0).addUnit(enemy3);
            enemy3.takeTurn(alienBoard,cruBoard);
            highlightAttackOptions(3, 3, 3, 0, alienBoard);
        }
        else
        {
            enemyHealer enemy1 = new enemyHealer(5, 0.9, 0.6, 0.8, 0.7, "healer", 5);
            enemySpitter enemy2 = new enemySpitter(5, 0.9, 0.7, 0.8, 0.7, "spitter", 5);
            enemyTank enemy3 = new enemyTank(5, 0.9, 0.8, 0.8, 0.7, "tank", 5);
            enemyBoss enemy4 = new  enemyBoss(5, 0.9, 0.8, 0.8, 0.7, "boss", 5);
        	alienBoard.getSquare(3, 3).addUnit(enemy1);
        	alienBoard.getSquare(2, 2).addUnit(enemy2);
        	alienBoard.getSquare(1, 1).addUnit(enemy3);
        	//cruBoard.getSquare(0, 0).addUnit(guy3);
            alienBoard.getSquare(0, 0).addUnit(enemy4);
        	alienBoard.getSquare(0, 0).addUnit(enemy4);
        }
        highlightMoveOptions(cruBoard.getSquare(1, 1), cruBoard);
        //https://www.youtube.com/watch?v=UOxkGD8qRB4
        for (int i =0;i<4;i++){
            for (int j =0;j<4;j++){
                Unit x = cruBoard.getSquare(i, j).selectSquare();
                if (x != null)
                {
                    characters[counter] = x;
                    counter++;
                }
                Unit y = alienBoard.getSquare(i, j).selectSquare();
                if (y != null)
                {

                    characters[counter] = y;
                    counter++;
                }
            }
        }
    }
    
    public void turn()
    {
    	 characters = sort_speed(characters);
         
         for (int j = 0; j < 32; j++)
         {
             if (characters[j]!=null)
             {
                 System.out.println(j + ": " + "speed: " + characters[j].speedValue);
                 characters[j].startTurn();
                 //Wait until the turn is over
                 //Do stuff here :)
                 characters[j].endTurn();
             }   
         }
    }
    
    //Works 
    private static Unit[] sort_speed(Unit characters[])
    {
    	for (int i = (31 - 1); i >= 0; i--)
    	   {
    	      for (int j = 1; j <= i; j++)
    	      {
    	    	  if (characters[j-1] != null && characters[j]!=null)
    	    	  {
    	    		  if (characters[j-1].speedValue > characters[j].speedValue)
    	    		  {
    	    			  Unit temp = characters[j-1];
    	    			  characters[j-1] = characters[j];
    	    			  characters[j] = temp;
    	    		  }
    	    	  }
    	      }
    	   }
    	   return characters;
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

