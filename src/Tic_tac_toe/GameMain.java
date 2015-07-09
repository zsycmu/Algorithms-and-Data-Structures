package Tic_tac_toe;

import java.util.Scanner;

public class GameMain {
	private Board board;
	private GameState gameStat;
	private Seed currentPlayer;
	
	private static Scanner in = new Scanner(System.in);
	
	public GameMain() {
		board = new Board();
		
		initGame();
		
		do {
			playerMove(currentPlayer);
			board.paint();
			updateGame(currentPlayer);
			if (gameStat == GameState.CROSS_WON) {
	            System.out.println("'X' won! Bye!");
	         } else if (gameStat == GameState.NOUGHT_WON) {
	            System.out.println("'O' won! Bye!");
	         } else if (gameStat == GameState.DRAW) {
	            System.out.println("It's Draw! Bye!");
	         }
	         // Switch player
	         currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
	      } while (gameStat == GameState.PLAYING); 
		
	}
	
	public void initGame() {
		board.init();
		gameStat = GameState.PLAYING;
		currentPlayer = Seed.CROSS;
	}
	
	public void playerMove(Seed theSeed) {
		boolean validInput = false;
		do {
			if (theSeed == Seed.CROSS) {
	            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
	         } else {
	            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
	         }
	         int row = in.nextInt() - 1;
	         int col = in.nextInt() - 1;
	         if (row >= 0 && row < Board.ROW && col >= 0 && col < Board.COL
	               && board.cells[row][col].content == Seed.EMPTY) {
	            board.cells[row][col].content = theSeed;
	            board.currentRow = row;
	            board.currentCol = col;
	            validInput = true; // input okay, exit loop
	         } else {
	            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
	                  + ") is not valid. Try again...");
	         }
	      } while (!validInput);
	}
	
	public void updateGame(Seed theSeed) {
		if (board.hasWon(theSeed)) {  // check for win
	    	  gameStat = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
	      } else if (board.isDraw()) {  // check for draw
	    	  gameStat = GameState.DRAW;
	      }
	      // Otherwise, no change to current state (still GameState.PLAYING).
	}
	
	public static void main(String[] args) {
		new GameMain();
	}
}
