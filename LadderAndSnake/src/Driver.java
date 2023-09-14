//------------------------------------------------------------------------------------
// Written by: Ruven Minciotti 40252872 and Nektarios Zampetoulakis 40211948
// COMP 249
// Assignment #1
// Due Date: 06/02/2023
//------------------------------------------------------------------------------------

import java.util.Scanner;



/** Main driver class to run Snakes and ladder game and initialize players.
 * 
 * @author Ruven and Nektarios
 *
 */
public class Driver {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the Number of Players");
		int players = scan.nextInt();
		
		LadderAndSnake game = new LadderAndSnake(players);
		
		
		game.play();

		scan.close();
	
	}		

}
