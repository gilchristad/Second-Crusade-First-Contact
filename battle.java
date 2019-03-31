    import java.lang.Math;
    public class battle {
    private static Unit[] characters;

    public static void main(String[] args) {
        System.out.println("HELLO");
        int counter = 0;
        characters = new Unit[32];
        for (int i = 0; i < 32; i++)
        {
            characters[i] = null;
        }
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
        cruBoard.getSquare(2,1).addUnit(guy5);
        alienBoard.getSquare(2, 1).addUnit(enemy5);
        //https://www.youtube.com/watch?v=UOxkGD8qRB4
        System.out.println("1\n");  
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
                
                    characters[counter] = y;
                    counter++;
                }
            }
        System.out.println("2\n");  
        characters = sort_speed(characters);
        System.out.println("3\n");  
        for (int i = 0; i < 32; i++)
        {
            if (characters[i]!=null)
            {
                //System.out.println("speed: " + characters[i].speedValue);
                characters[i].startTurn();
                //Wait until the turn is over
                //Do stuff here :)
                characters[i].endTurn();
            }   
        }
    }
    //This doesnt work :)
    private static Unit[] sort_speed(Unit characters[])
    {
        for (int i = 0; i < 31; i++)
        {
            for (int j = 0; j < 31-i; j++)
            {
                if (characters[j]!= null && characters[j+1]!=null)
                {
                    if (characters[j].speedValue < characters[j+1].speedValue)
                    {
                        // swap(characters[j], characters[j+1]); 
                        Unit temp = characters[j];
                        characters[j] = characters[j+1];
                        characters[j+1] = temp;
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
                            result[count]=board.getSquare(directions[i]+x, directions[q]+y);
                            count++;
                        }
                    }
                }
            }
        }
        return result;
    }
}

