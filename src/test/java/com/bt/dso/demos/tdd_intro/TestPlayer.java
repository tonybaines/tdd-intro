package com.bt.dso.demos.tdd_intro;
import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.*;
public class TestPlayer {
	private Dealer dealer;
	private static final Card[] EXPECTED_HAND_SCORE_20 = new Card[] {Card.CJ, Card.C10};
	@Before
	public void setUp() {
		dealer = createNiceMock(Dealer.class);
		expect(dealer.deal()).andReturn(EXPECTED_HAND_SCORE_20);
		replay(dealer);
	}
	
	@After
	public void after() {
		verify(dealer);
	}

	@Test
	public void shouldHoldTheHandTheyAreDealt() {
		Player player = new Player(dealer);
		player.newGame();
		assertArrayEquals(EXPECTED_HAND_SCORE_20, player.getHand());
	}
	@Test
	public void shouldScoreTheirOwnHand() {
		Player player = new Player(dealer);
		player.newGame();
		assertEquals(20, player.score());
	}
	
}
