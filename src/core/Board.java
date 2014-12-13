package core;

public class Board {
	
	public int[][] board;
	public Board(int[][] board) {
		this.board = board;
	}
	public int depth = 0;
	public Board() {
		generatePuzzle();
	}
	
	public Board generatePuzzle() {
		board = new int[][] {
			{0, 0, 0, 0, 5, 0, 4, 0, 0}, 
			{6, 0, 0, 8, 0, 0, 0, 9, 0},
			{0, 1, 7, 0, 0, 0, 0, 0, 2},
			{0, 0, 0, 0, 0, 1, 0, 0, 8},
			{0, 8, 0, 0, 7, 0, 0, 6, 0},
			{5, 0, 0, 4, 0, 0, 0, 0, 0},
			{2, 0, 0, 0, 0, 0, 8, 3, 0},
			{0, 7, 0, 0, 0, 2, 0, 0, 6},
			{0, 0, 6, 0, 3, 0, 0, 0, 0}};
		
		return this;
	}
	
	public int getValue(int x, int y) {
		return board[y][x];
	}
	
	public String printBoard() {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (int[] row : board) {
		
			int count = 1;
			for (int col : row) {
				
				if (col == 0) {
					sb.append(". ");
				}
				else{
				sb.append(col + " ");
				}
				if (count % 3 == 0) {
					sb.append("| ");
				}
				count++;
			}
			if(counter % 3 == 0) {
				sb.append("\n- - - - - - - - - - - -");
			}
			counter++;
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public boolean noConflict(int val, int x, int y) {
		 for (int i = 0; i < 9; i++) {
	            if (board[y][i] == val) {
	                return false;
	            }
	            if (board[i][x] == val) {
	                return false;
	            }
	        }
		 
		 int gridRow = y - (y % 3);
	        int gridColumn = x - (x % 3);
	        for (int p = gridRow; p < gridRow + 3; p++) {
	            for (int q = gridColumn; q < gridColumn + 3; q++) {
	                if (board[p][q] == val) {
	                    return false;
	                }
	            }
	        }
		 
		 return true;
	}

	public void makeMove(int val, int x, int y) {
		board[y][x] = val;
		
	}
	
	public void removeMove(int x, int y) {
		board[y][x] = 0;
	}
	
	public boolean boardSolve() {
		
		
		if(isSolved()) {
			return true;
		}
		Board copy = new Board(this.board);
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y] == 0) {
					for(int i = 1; i < 10; i++) {
						
						if(copy.noConflict(i, y, x)) {
						
							copy.makeMove(i, y, x);
							copy.depth = depth + 1;
							
							copy.boardSolve();
							if(copy.isSolved()) {
								board = copy.board;
								return true;
								
							}
						}
						
						copy.removeMove(y, x);
						
					}
					return false;
					
					
				}
			}
		}
		return false;
	}
	
	public boolean isSolved() {
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[y][x] == 0)
					return false;
			}
		}
		return true;
	}
	

}
