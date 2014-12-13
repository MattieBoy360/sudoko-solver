package core;

public class Sudoku {

	public Board board;
	
	public Sudoku() {
		board = new Board();
		
	}
	
	public void makeMove(int val, int x, int y) {
		if(board.noConflict(val, x, y)) {
			board.makeMove(val, x, y);
		}
	}
	
	public String toString() {
		return board.printBoard();
	}


	
	public static void main(String[] args) {
	
		Sudoku puz = new Sudoku();
		System.out.println(puz);
		puz.makeMove(6, 1, 3);
		System.out.println(puz);
	}
	

}
