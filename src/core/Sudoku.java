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
	
	public String solve() {
		board.boardSolve();
		return board.printBoard();
	}


	
	public static void main(String[] args) {
		
		int[][] board = new int[][] {
				{4, 0, 0, 0, 0, 3, 0, 0, 6},
				{0, 0, 0, 0, 0, 2, 1, 0, 0},
				{0, 0, 6, 1, 0, 0, 0, 2, 0},
				{0, 0, 9, 2, 0, 0, 0, 6, 3},
				{0, 0, 0, 0, 8, 0, 0, 0, 0},
				{5, 4, 0, 0, 0, 6, 7, 0, 0},
				{0, 8, 0, 0, 0, 4, 6, 0, 0},
				{0, 0, 3, 8, 0, 0, 0, 0, 0},
				{9, 0, 0, 3, 0, 0, 0, 0, 2}};
		
		int[][] board2 = new int[9][9];
		for(int i = 0; i <9; i++) {
			for(int j=0; j < 9; j++) {
				board2[i][j] = 0;
			}
		}
				
		
	
		Board b1 = new Board(board);
		b1.boardSolve();
		System.out.println(b1.printBoard());
		System.out.println(b1.isSolved());
	}
	

}
