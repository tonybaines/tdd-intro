package com.bt.dso.demos.tdd_intro;

public class Player {

	private final Dealer dealer;
	private Card[] hand;

	public Player(Dealer dealer) {
		this.dealer = dealer;
	}

	public void newGame() {
		dealer.newGame();
		this.hand = dealer.deal();
	}

	public Card[] getHand() {
		return this.hand;
	}

	public int score() {
		int score = 0;
		for (Card card : this.hand) {
			score += card.score();
		}
		return score;
	}

}
