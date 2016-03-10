package week5;

import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard{
	public static String[][] niyaBoard = new String[4][4];
	ArrayList<Player> moves = new ArrayList<>();

	public static void initializeBoard() {
		ArrayList<String> permutations = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			int j = 0;
			while(j < 4) {
				Tile tile = new Tile();
				if(tile.getPicOne() != tile.getPicTwo() && combinationDoesNotExist(permutations, tile)) {
					niyaBoard[i][j] = tile.toString();
					j++;
				}
			}
		}
	}
	//checks for the pairs that cannot make up a tile
	private static boolean combinationDoesNotExist(ArrayList<String> permutations, Tile tile) {
		String pairOne = tile.getPicOne() + " " + tile.getPicTwo();
		String pairTwo = tile.getPicTwo() + " " + tile.getPicOne();
		if(permutations.contains(pairOne) || permutations.contains(pairTwo))
			return false;
		permutations.add(pairOne);
		return true;
	}

	public static void printBoard() {
		for(int row = 0; row < 4; row++) {
			for(int column = 0; column < 4; column++) {
				System.out.print(niyaBoard[row][column]);
				if(column != 3)
					System.out.print("  |  ");  
			}
			System.out.println();
			if (row != 3)
				System.out.println("--------------------------------------------------------------------------------");
		}
	}
	/*  
	 * We want a condition that tells the user whose turn it is
	 * After that we want to ask the player to choose a row and column to make a move 
	 * Warn the next player that its their turn and check if the tile they choose has at least one of the Icon types from the previous tile selection
	 * And finally add those moves the the ArrayList of Player moves 
	 * 
	 */
	public static String makeMove(Player player, Scanner input, String lastTile) {
		while(true) {	
			System.out.println(player + " choose row and column:");
			System.out.print("r: ");
			int x =input.nextInt();
			System.out.print("c: ");
			int y =input.nextInt();
			if(lastTile != null) {
				if(isValidMove(x,y, lastTile.toString())) {
					lastTile = niyaBoard[x][y];
					niyaBoard[x][y] = player.toString();
					printBoard();
					return lastTile;
				} else {
					System.out.println(player.toString()+" not a valid move either space taken or you need to find at least one of the this Icons on next tile: " + lastTile);
				}
			} else {
				lastTile = niyaBoard[x][y];
				niyaBoard[x][y] = player.toString();
				printBoard();
				return lastTile;
			}
		}
	}


	public static boolean isValidMove(int row, int column, String lastTile) {
		String tile = niyaBoard[row][column].toString();
		String[] a = tile.split("/");
		String [] b = lastTile.split("/");
		for(String c: a){
			if(c.equals(b[0]) || c.equals(b[1])){
				return true;
			}
		}
		return false;
	}
	//method that checks it the board contains diagonal, horizontal, vertical and 2x2 winner
	public static boolean checkWinner(Player player){
		//check diagonals
		if(niyaBoard[0][0].equals(niyaBoard[1][1]) && niyaBoard[2][2].equals(niyaBoard[3][3])) {
			return true;
		}
		else if(niyaBoard[0][3].equals(niyaBoard[1][2]) && niyaBoard[2][0].equals(niyaBoard[3][0])) {
			return true;
		}
		else{
			//check row
			for(int i = 0; i < 4; i++){
				if(niyaBoard[i][0].equals(niyaBoard[i][1]) && niyaBoard[i][2].equals(niyaBoard[i][3])){
					return true;
				}
			}//check column
			for(int i = 0; i < 4; i++){
				if(niyaBoard[0][i].equals(niyaBoard[1][i]) && niyaBoard[2][i].equals(niyaBoard[3][i])){
					return true;
				}
			}
			//check 2x2 winner
			for(int i = 0; i < 4; i++){
				if(niyaBoard[0][i].equals(niyaBoard[0][i]) && niyaBoard[1][i].equals(niyaBoard[1][i])){
					return true;
				}
			}
			for(int i = 0; i < 4; i++){
				if(niyaBoard[1][i].equals(niyaBoard[1][i]) && niyaBoard[2][i].equals(niyaBoard[2][i])){
					return true;
				}
			}
			for(int i = 0; i < 4; i++){
				if(niyaBoard[2][i].equals(niyaBoard[2][i]) && niyaBoard[3][i].equals(niyaBoard[3][i])){
					return true;
				}
			}
		}
		return false;
	}
}
