package week5;
import java.util.Scanner;

import week5.Player.PlayerColor;

public class Niya {
	public static void main(String[] args) {
		int choice;
		
		System.out.println("Welcome to Niya!\nPress 1 to Play Niya\nPress 2 to View Replay");
		Scanner input = new Scanner(System.in);
		do {
			while(!input.hasNextInt()) {
				String notValid = input.nextLine();
				System.out.println(notValid + " is not a valid choice only 1 and 2 are valid choices");
			}
			choice = input.nextInt();

			switch(choice){
			default:
				System.out.println("You have exited Niya");
				System.exit(0);
			case 1:
				playNiya(input);
				break;
			case 2:
				//viewReplay();
				break;	
			}
		} while(choice !=0);
	}

	public static void playNiya(Scanner input){
		System.out.println("Welcome to Niya\nPlayer One is red checker and goes first, Player two is black checker");
		System.out.println("Game start!");
		GameBoard.initializeBoard();
		GameBoard.printBoard();
		
		Player playerOne = new Player(PlayerColor.RED);
		Player playerTwo = new Player(PlayerColor.BLACK);

		String lastTile = GameBoard.makeMove(playerOne, input, null);
		lastTile = GameBoard.makeMove(playerTwo, input, lastTile);
        //keeps tarck of the number of moves that both player have
		for(int i = 0; i < 7; i++) {
			lastTile = GameBoard.makeMove(playerOne, input, lastTile);
			lastTile = GameBoard.makeMove(playerTwo, input, lastTile);
		}
	
	}
	
}