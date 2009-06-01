package com.bt.dso.demos.tdd_intro;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestDealer {
	@Test
	public void shouldDealTwoDifferentSetsOfCardsEachDeal() {
		Dealer dealer = new Dealer();
		Card[] cards = dealer.deal();
		assertEquals(2, cards.length);
		Card[] cards2 = dealer.deal();
		assertFalse(Arrays.equals(cards, cards2));
	}
	
	@Test
	public void shouldDealASingleCardEachTime() {
		Dealer dealer = new Dealer();
		assertFalse(dealer.twist().equals(dealer.twist()));
	}
	
	@Test
	public void shouldDeal52CardsThenThrownAnException() {
		Dealer dealer = new Dealer();
		for(int i=0; i< 52; i++) {
			dealer.twist();
		}
		try {
			dealer.twist();
			fail("Expected exception not thrown");
		}
		catch(IllegalStateException e) {
			// Expected
		}
	}
}
