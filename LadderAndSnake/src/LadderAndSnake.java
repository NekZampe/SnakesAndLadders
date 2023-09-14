//------------------------------------------------------------------------------------
// Written by: Ruven Minciotti 40252872 and Nektarios Zampetoulakis 40211948
// COMP 249
// Assignment #1
// Due Date: 06/02/2023
//------------------------------------------------------------------------------------


import java.util.Random;
import java.util.Scanner;


/** Snakes and ladders game. Two players roll a die to move forward on a 10x10 board falling down snakes and climbing up ladders.
 * Rules: both players start at 0. If one lands on the space of the other, the player who was previously on the space is sent back to the start.
 * Landing on the bottom of a ladder allows a player to move up whereas landing on the head of a snake makes the player fall lower.
 * A player wins when they reach exactly the highest space marked by 100, if they roll a value higher than 100, they are placed an amount equal to the number they exceeded 100 by.
 * 
 * @author Ruven & Nektarios
 */

public class LadderAndSnake {
	
	int[][] board = new int[10][10];
	int[] players = new int[2];
	Random dice = new Random();
	Scanner sc = new Scanner(System.in);
	int currentPlayer;

/**Method to Construct and initialize a 10x10 board and set location of snakes and ladders. 
 * @author Ruven & Nektarios
 */
	public void InitializeBoard() {	
		 for (int i = 9; i >= 0; i--) {
	         for (int j = 0; j < 10; j++) {
	           board[i][j] = 10 * i + j + 1;
			}
		}
		
		//Ladders	    
			board [7][0]= 100 ;
			board [7][9] = 91 ;
			board [5][9] = 67 ;
			board [0][8] = 31 ;
			board [2][7] = 84 ;
			board [2][0] = 42;
			board [3][4] = 44;
			board [0][0] = 38 ;
			board [0][3] = 14 ;
		//Snakes
			board [9][3] = 76 ;
			board [9][2] = 78 ;
			board [9][5] = 24 ;
			board [9][7] = 68 ;
			board [7][1] = 19;
			board [6][3] = 60;
			board [4][7] = 30;
			board [1][4] = 6;
	}
			
	
/**Parameterized constructor to see if acceptable player limit of 2 is selected. If lower than 2, system exits. If greater than 2, players is automatically set to 2.
 * 
 * @param players
 * 
 * @author Ruven & Nektarios
 */
				LadderAndSnake(int players){				
				
			if (players > 2) {
				System.out.println("Initialization was attempted for " + players + " players.");
				System.out.println("However, this is only expected for an extended version the game.");
				System.out.println("Value will be set to 2");
				players = 2;
			}

			if (players < 2) {
				System.out.println("Error: Cannot execute the game with less than 2 players! Will exit");
				System.exit(0);
			}
		}
	
/**Flip Dice method, generates random integer between 1-6 to simulate dice throw.
 * 
 * @return dice
 * @author Ruven & Nektarios
 */
		int flipDice() {
			return dice.nextInt(6) + 1;	
}
/**Print board method, displays board and player positions.
 * 
 * @author Ruven & Nektarios
 */
 void printBoard() {
	        System.out.println("\n------------SNAKES AND LADDERS-------------");
	        System.out.println("-------------------------------------------");
	        for (int i = 9; i >= 0; i--) {
	          for (int j = 0; j < 10; j++) {
	            int square = 10 * i + j + 1;
	            if (players[0] == square) {
	                System.out.print(" >P1");
	            } else if (players[1] == square) {
	              System.out.print(" >P2");
	            } else {
	          System.out.format("%4d",square); 
	            }
	          }
	          System.out.println("\n");
	        }
	        System.out.println("-------------------------------------------");
	      }
	
/**Main play method that holds Snakes and Ladders game. 
 * Check who starts by rolling the die, the higher number roll is set as current player which switches between 0-1 at the end of the loop.
 * Play method exists in a single while loop that plays until a player reaches 100.	
 * 10x10 board is initialized within the play method.	
 * If a player reaches above 100, they are set back the number of spaces they exceeded 100 by.
 * If the players land on the same square, the one who was there first is placed back to the starting position.
 * A player wins when they reach exactly position 100, loop then terminates.
 *@author Ruven & Nektarios 
 */
			void play() {
//System print introduction screen				
				System.out.println("                  WELCOME TO SNAKES AND LADDERS");
				System.out.println("                     __    __    __    __\r\n"
						+ "                     /  \\  /  \\  /  \\  /  \\\r\n"
						+ "____________________/  __\\/  __\\/  __\\/  __\\_____________________________\r\n"
						+ "___________________/  /__/  /__/  /__/  /________________________________\r\n"
						+ "                   | / \\   / \\   / \\   / \\  \\____\r\n"
						+ "                   |/   \\_/   \\_/   \\_/   \\    o \\\r\n"
						+ "                                           \\_____/--<                       Drawing by: Jennifer E. Swofford");
				System.out.println("                     GAME BY RUVEN & NEKTARIOS\n");

				InitializeBoard();
//Check who starts by rolling the die, the higher number roll is set as current player				
				int firstPlayer = -1;
				int	secondPlayer = -1;
				System.out.println("Rolling the die to see who goes first...");
				while (firstPlayer == secondPlayer) {
					System.out.println("Player 1 roll: ");
					firstPlayer = flipDice();
					System.out.println(firstPlayer);
					System.out.println("Player 2 roll: ");
					secondPlayer = flipDice();
					System.out.println(secondPlayer);
				}
					int currentPlayer = (firstPlayer > secondPlayer) ? 0 : 1;//Ternary: if(Fp>Sp), Cp=0 else Cp=1.
					System.out.println("Player "+ (currentPlayer+1) +" has the higher roll. They start First. Press enter to begin \n");
					sc.nextLine();
			
//Play method exists in a single while loop that plays until a player reaches 100.
				while (players[currentPlayer] < 100) {
					System.out.println("Player " + (currentPlayer + 1) + " turn: ");
					int roll = flipDice();
					System.out.println("Roll: " + roll);
					players[currentPlayer] += roll;
//System out Print if ladder is hit		
					if(players[currentPlayer] == 1) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 4) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 2) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 9) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 21) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 28) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 36) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 51) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 71) { System.out.println("a ladder! going up..." );}
					if(players[currentPlayer] == 80) { System.out.println("a ladder! going up..." );}
//System out Print if Snake is hit
					if(players[currentPlayer] == 16) { System.out.println("Oh no a Snake! ahhhh..." );}
					if(players[currentPlayer] == 48) { System.out.println("Oh no a Snake! ahhhh..." );}
					if(players[currentPlayer] == 79) { System.out.println("Oh no a Snake! ahhhh..." );}
					if(players[currentPlayer] == 64) { System.out.println("Oh no a Snake! ahhhh..." );}
					if(players[currentPlayer] == 93) { System.out.println("Oh no a Snake! ahhhh..." );}
					if(players[currentPlayer] == 95) { System.out.println("Oh no a Snake! ahhhh..." );}
					if(players[currentPlayer] == 97) { System.out.println("Oh no a Snake! ahhhh..." );}
					if(players[currentPlayer] == 98) { System.out.println("Oh no a Snake! ahhhh..." );}

					if (players[currentPlayer] > 100) {
						players[currentPlayer] = 200 - players[currentPlayer];
					}
//To set the position of P1/P2 in the 2D array
					int row = (players[currentPlayer] - 1) / 10;   // Integer division of current player position gives row number and
					int col = (players[currentPlayer] - 1) % 10;   // remainder gives column number
					if (board[row][col] != 0) {
						players[currentPlayer] = board[row][col];
					}
//If players land on same square, the one who was there first is placed back to starting position.
					if (players[0] == players[1]) {
						if (currentPlayer == 0) {
							players[1] = 0;
						}
						if (currentPlayer == 1) {
							players[0] = 0;
						}
					}
					
//Call the print board method within the loop to display current player position.
					printBoard();
//To show player position using text as-well.					
					System.out.println("Player 1 position: " + players[0]);
					System.out.println("Player 2 position: " + players[1]);
//Scanner entry to pause while loop to view current board and then to continue game.
					System.out.println("Press enter to continue");
					sc.nextLine();
				
//To change player turns.
					currentPlayer = currentPlayer == 0 ? 1 : 0; //Ternary: if current player = 0, current player = 1, if not it equals zero.
				}
//End game message to show winner.		  
			       System.out.println("!!! Player " + (currentPlayer + 1) + " wins !!!");
			       System.out.println("\nTERMINATING PROGRAM. THANK YOU FOR PLAYING.");
}			
			
		
}
			
	

