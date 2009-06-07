package com.bt.dso.demos.tdd_intro.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private static final int MAX_SCORE = 21;
	private final Dealer dealer;
	private final List<Card> hand = new ArrayList<Card>();

	public Player(Dealer dealer) {
		this.dealer = dealer;
	}

	public void newGame() {
		dealer.newGame();
		twist();
		twist();
	}

	public List<Card> getHand() {
		return this.hand;
	}

	public int score() {
		int score = 0;
		for (Card card : this.hand) {
			score += card.score();
		}
		return score;
	}

	public void twist() {
		this.hand.add(dealer.nextCard());
		if (this.score() > MAX_SCORE) throw new BlackjackBustException();
	}

}
