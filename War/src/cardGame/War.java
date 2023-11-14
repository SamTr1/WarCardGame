/*
 * Name: Samuel Trujillo 
 * Date: 3/7
 * Description: Plays the Card Game War
 * Sources Cited: None
 */
package cardGame;
import java.io.*;

public class War {

	public static void main(String[] args) {
		
		// =================================================================
		//Intialize the Deck and Shuffle it
		Deck d = new Deck();
		
		System.out.println("Deck is shuffling...");
		d.shuffle();
		
		// =================================================================
		// Intialize variables for Player 1
		Card player1;
		int cardCounter1 = 0; // Counts Number of Cards Player 1 has
		
		// =================================================================
		//Intialize variables for Player 2
		Card player2;
		int cardCounter2 = 0; // Counts Number of Cards Player 2 has
		
		// =================================================================
		// Game goes until the deck is empty
		while(!d.isEmpty()) {
			
			// ---------------------------------------------------------------
			//Prompts User and has players draw cards
			System.out.println("Press Enter To Draw Cards");
			promptEnterKey();
			
			player1 = d.draw();
			player2 = d.draw();
			
			// ---------------------------------------------------------------
			// Dialouge for User 
			System.out.println("=========================================");
			System.out.println("Beginning of Round");
			System.out.println("\nPlayer1 drew a " + player1.getRank() + " of " + player1.getSuit() + "\n");
			System.out.println("\nPlayer2 drew a " + player2.getRank() + " of " + player2.getSuit() + "\n");
			
			// ---------------------------------------------------------------
			// Checks if Player 1 wins
			if (player1.getRank() > player2.getRank()) {
				
				System.out.println("Player 1 Wins the Round");
				cardCounter1 += 2;
			}
			
			// ---------------------------------------------------------------
			// Checks if Player 2 Wins
			else if (player1.getRank() < player2.getRank()) {
				
				System.out.println("Player 2 Wins the Round");
				cardCounter2 += 2;
			}
			
			// ---------------------------------------------------------------
			// There is a draw and War Round 1 Begins
			else {
				
				// ---------------------------------------------------------------
				//Prompts User and has players draw cards
				System.out.println("WAR!");
				System.out.println("Press Enter To Draw Cards");
				promptEnterKey();
				
				player1 = d.draw();
				player2 = d.draw();
				
				// ---------------------------------------------------------------
				// User Dialouge
				System.out.println("=========================================");
				System.out.println("Beginning of War");
				System.out.println("\nPlayer1 drew a " + player1.getRank() + " of " + player1.getSuit() + "\n");
				System.out.println("\nPlayer2 drew a " + player2.getRank() + " of " + player2.getSuit() + "\n");
				
				// ---------------------------------------------------------------
				// Checks if Player 1 Wins
				if (player1.getRank() > player2.getRank()) {
					
					System.out.println("Player 1 Wins the War!");
					cardCounter1 += 6;
					
					//---------------------------
					// Throws away the 1 card for each player that would have been drawn
					d.draw();
					d.draw();
				}
				
				// ---------------------------------------------------------------
				// Checks if Player 2 Wins
				else if (player1.getRank() < player2.getRank()) {
					
					System.out.println("Player 2 Wins the War!");
					cardCounter2 += 6;
					
					//---------------------------
					// Throws away the 1 card for each player that would have been drawn
					d.draw();
					d.draw();
				}
				
				// ---------------------------------------------------------------
				else { // Draw and War Round 2 Starts
					
					// ---------------------------------------------------------------
					// Prompts User to Draw Cards
					System.out.println("WAR! Round 2");
					System.out.println("Press Enter To Draw Cards");
					promptEnterKey();
					
					player1 = d.draw();
					player2 = d.draw();
					
					// ---------------------------------------------------------------
					// User Dialouge
					System.out.println("=========================================");
					System.out.println("Beginning of War Round 2");
					System.out.println("\nPlayer1 drew a " + player1.getRank() + " of " + player1.getSuit() + "\n");
					System.out.println("\nPlayer2 drew a " + player2.getRank() + " of " + player2.getSuit() + "\n");
					
					// ---------------------------------------------------------------
					// Checks if Player 1 Wins
					if (player1.getRank() > player2.getRank()) {
						
						System.out.println("Player 1 Wins the War!");
						cardCounter1 += 6;
						
					}
					
					// ---------------------------------------------------------------
					// Checks if Player 2 Wins
					else if (player1.getRank() < player2.getRank()) {
						
						System.out.println("Player 2 Wins the War!");
						cardCounter2 += 6;
					}
					
					// ---------------------------------------------------------------
					// The War is a Draw
					else {
						
						System.out.println("The War is a Draw!");
						cardCounter1 += 3;
						cardCounter2 += 3;
						
					}
				}	
			}
		} // End of While Loop
		
		// =================================================================
		// Checks if Player 1 Wins the Game
		if (cardCounter1 > cardCounter2) {
			
			System.out.println("Player 1 Wins!\n");
			System.out.println("Player 1 has " + cardCounter1 + " cards");
			System.out.println("Player 2 has " + cardCounter2 + " cards");
		}
		
		// =================================================================
		// Checks if Player 2 Wins the Game
		else if(cardCounter1 > cardCounter2) {
			
			System.out.println("Player 2 Wins!\n");
			System.out.println("Player 1 has " + cardCounter1 + " cards");
			System.out.println("Player 2 has " + cardCounter2 + " cards");
		}
		
		// =================================================================
		// The Game is a Draw
		else {
			
			System.out.println("The Game is a Draw!");
			System.out.println("Player 1 has " + cardCounter1 + " cards");
			System.out.println("Player 2 has " + cardCounter2 + " cards");
		}

	}

	public static void promptEnterKey(){try {System.in.read(new byte[2]);}catch (IOException e) {e.printStackTrace();}}
	
	
	
}
