    import java.lang.Math;
    public class battle {

    public static void main(String[] args) {
        Unit[] characters = new Unit[32];
        int counter = 0;
        characters = new Unit[32];
        SwordAndShield guy1 = new SwordAndShield(10, .9, 0.1, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy2 = new Crusader(10, .9, 0.2, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy3= new Crusader(10, .9, 0.3, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy4 = new Crusader(10, .9, 0.4, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Crusader guy5 = new Crusader(10, .9, 0.5, 0.8, 0.8, 10, 10, 10, 10, 10, 10);
        Alien enemy1 = new Alien(5, 0.9, 0.6, 0.8, 0.7, 5);
        Alien enemy2 = new Alien(5, 0.9, 0.7, 0.8, 0.7, 5);
        Alien enemy3 = new Alien(5, 0.9, 0.8, 0.8, 0.7, 5);
        Alien enemy4 = new Alien(5, 0.9, 0.9, 0.8, 0.7, 5);
        Alien enemy5 = new Alien(5, 0.9, 0.99, 0.8, 0.7, 5);
        Board cruBoard= new Board(4,4);
        Board alienBoard= new Board(4,4);
        cruBoard.getSquare(1, 1).addUnit(guy1);
        alienBoard.getSquare(1, 1).addUnit(enemy1);
        cruBoard.getSquare(1, 2).addUnit(guy2);
        alienBoard.getSquare(1, 2).addUnit(enemy2);
        cruBoard.getSquare(1, 3).addUnit(guy3);
        alienBoard.getSquare(1, 3).addUnit(enemy3);
        cruBoard.getSquare(1, 0).addUnit(guy3);
        alienBoard.getSquare(1, 0).addUnit(enemy3);
        cruBoard.getSquare(2,1).addUnit(guy4);
        alienBoard.getSquare(2, 1).addUnit(enemy4);
        cruBoard.getSquare(2,2).addUnit(guy5);
        alienBoard.getSquare(2, 2).addUnit(enemy5);
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
}

