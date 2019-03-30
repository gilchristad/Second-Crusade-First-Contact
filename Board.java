public class Board {
	Square[][] board;
	public Board(int x, int y){
		 board= new Square[x][y];
		 for(int i=0;i<board.length;i++){
			 for (int q=0;q<board[0].length;q++){
				 board[i][q]=new Square(null);
			 }
		 }
	}
	public Square getSquare(int x,int y){
		return board[x][y];
	
	}
}
