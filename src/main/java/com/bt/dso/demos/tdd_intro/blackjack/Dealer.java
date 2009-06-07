package com.bt.dso.demos.tdd_intro.blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Dealer {
	private static final String[] HEARTS= new String[] {
		"AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", 
		"10H", "JH", "QH", "KH"};
	private static final String[] SPADES= new String[] {
		"AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", 
		"10S", "JS", "QS", "KS"};
	private static final String[] DIAMONDS= new String[] {
		"AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", 
		"10H", "JH", "QH", "KH"};
	private static final String[] CLUBS= new String[] {
		"AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", 
		"10C", "JC", "QC", "KC"};

	private List<Card> deck;
	
	public Dealer() {
		newGame();
	}
	
	public void newGame() {
		shuffle();
	}

	private void shuffle() {
		deck = new LinkedList<Card>();
		deck.addAll(Arrays.asList(Card.values()));
		Collections.shuffle(deck);
	}

	public Card nextCard() {
		if (deck.size() ==0) throw new IllegalStateException("No cards left");
		return deck.remove(0);
	}
}
