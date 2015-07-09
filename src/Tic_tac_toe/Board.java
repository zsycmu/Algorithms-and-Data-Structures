package Tic_tac_toe;

public class Board {
	public static final int ROW = 3;
	public static final int COL = 3;
	
	Cell[][] cells;
	int currentRow, currentCol;
	
	public Board() {
		cells = new Cell[ROW][COL];
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
	
	public void init() {
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				cells[row][col].clear();
			}
		} 
	}
	
	public boolean isDraw() {
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				if (cells[row][col].content == Seed.EMPTY) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean hasWon(Seed theSeed) {
		return (cells[currentRow][0].content == theSeed         // 3-in-the-row
                && cells[currentRow][1].content == theSeed
                && cells[currentRow][2].content == theSeed
           || cells[0][currentCol].content == theSeed      // 3-in-the-column
                && cells[1][currentCol].content == theSeed
                && cells[2][currentCol].content == theSeed
           || currentRow == currentCol            // 3-in-the-diagonal
                && cells[0][0].content == theSeed
                && cells[1][1].content == theSeed
                && cells[2][2].content == theSeed
           || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && cells[0][2].content == theSeed
                && cells[1][1].content == theSeed
                && cells[2][0].content == theSeed);
	}
	
	public void paint() {
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				cells[row][col].paint();
				if (col < COL - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (row < ROW - 1) {
				System.out.println("------------");
			}
		}
	}
}
