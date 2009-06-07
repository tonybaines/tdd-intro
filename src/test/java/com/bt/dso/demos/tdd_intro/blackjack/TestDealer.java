package com.bt.dso.demos.tdd_intro.blackjack;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.bt.dso.demos.tdd_intro.blackjack.Dealer;

public class TestDealer {
	@Test
	public void shouldDealASingleCardEachTime() {
		Dealer dealer = new Dealer();
		assertFalse(dealer.nextCard().equals(dealer.nextCard()));
	}
	
	@Test
	public void shouldDeal52CardsThenThrownAnException() {
		Dealer dealer = new Dealer();
		for(int i=0; i< 52; i++) {
			dealer.nextCard();
		}
		try {
			dealer.nextCard();
			fail("Expected exception not thrown");
		}
		catch(IllegalStateException e) {
			// Expected
		}
	}
}
