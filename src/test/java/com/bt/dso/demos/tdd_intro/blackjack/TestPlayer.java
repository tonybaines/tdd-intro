package com.bt.dso.demos.tdd_intro.blackjack;
import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.bt.dso.demos.tdd_intro.blackjack.BlackjackBustException;
import com.bt.dso.demos.tdd_intro.blackjack.Card;
import com.bt.dso.demos.tdd_intro.blackjack.Dealer;
import com.bt.dso.demos.tdd_intro.blackjack.Player;
public class TestPlayer {
	private Dealer dealer;
	private static final Card[] EXPECTED_HAND_SCORE_20 = new Card[] {Card.CJ, Card.C10};
	@Before
	public void setUp() {
		dealer = createNiceMock(Dealer.class);
		expect(dealer.nextCard()).andReturn(Card.CJ);
		expect(dealer.nextCard()).andReturn(Card.C10);
	}
	
	@After
	public void after() {
		verify(dealer);
	}

	@Test
	public void shouldHoldTheHandTheyAreDealt() {
		replay(dealer);
		Player player = new Player(dealer);
		player.newGame();
		assertArrayEquals(EXPECTED_HAND_SCORE_20, player.getHand().toArray());
	}
	@Test
	public void shouldScoreTheirOwnHand() {
		replay(dealer);
		Player player = new Player(dealer);
		player.newGame();
		assertEquals(20, player.score());
	}
	@Test
	public void shouldBeAbleToCallTwistToGetAnotherCard() {
		expect(dealer.nextCard()).andReturn(Card.CA);
		replay(dealer);
		Player player = new Player(dealer);
		player.newGame();
		assertEquals(20, player.score());
		player.twist();
		assertEquals(21, player.score());
	}
	@Test(expected=BlackjackBustException.class)
	public void shouldThrowAnExceptionIfTheScoreIsGreaterThan21AfterTwisting() {
		expect(dealer.nextCard()).andReturn(Card.C2);
		replay(dealer);
		Player player = new Player(dealer);
		player.newGame();
		assertEquals(20, player.score());
		player.twist();
	}
	
}
