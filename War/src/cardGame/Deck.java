/*
 * Name: Samuel Trujillo 
 * Date: 3/7
 * Description: Creates a deck of cards with the methods shuffle(), draw(), isEmpty(), swap()
 * Sources Cited: Rollbar (I didn't understand an error)
 */

package cardGame;

import java.util.Random;

public class Deck {
	private Card[] deck = new Card[52];
	private int top = 0;
	
	// ================================================================================
	// Constructor: Creates a Deck of Cards(Object)
	public Deck()
	{
		char[] tempSuit = {'C', 'D', 'S', 'H'};
		int[] tempNums = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		int counter = 0;
		
		for (int suitIndex = 0; suitIndex < tempSuit.length; suitIndex++) { // Loops through tempSuits
			for (int numsIndex = 0; numsIndex < tempNums.length; numsIndex++) { //Loops through tempNums
				
				deck[counter] = new Card(tempNums[numsIndex], tempSuit[suitIndex]); // Adds Card to deck 
				counter++;
			}
		}
	}
	
	// ================================================================================
	// Shuffle: swaps cards randomly to shuffle deck
	public void shuffle()
	{
		Random randomRange = new Random();
		
		for (int index = 0; index < deck.length; index++) { // Loops through deck list
			swap(index, randomRange.nextInt(deck.length)); 
		}
		
	}
	
	// ================================================================================
	public Card draw()
	{
		Card returnCard = deck[top]; // Gets Card at the top
		top++; // Moves to the next card
		
		return returnCard;
	}
	
	// ================================================================================
	public boolean isEmpty()
	{
		if (top < deck.length) {
			return false;
		}
		return true;
	}
	
	// ================================================================================
	// Swap: swaps cards in the deck list at two given index
	private void swap(int i, int j)
	{
		Card tempCard = deck[i];
		deck[i] = deck[j];
		deck[j] = tempCard;
		
	}
	
}