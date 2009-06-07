package com.bt.dso.demos.tdd_intro.blackjack;

public enum Card {
	HA(1), SA(1), DA(1), CA(1),
	H2(2), S2(2), D2(2), C2(2),
	H3(3), S3(3), D3(3), C3(3),
	H4(4), S4(4), D4(4), C4(4),
	H5(5), S5(5), D5(5), C5(5),
	H6(6), S6(6), D6(6), C6(6),
	H7(7), S7(7), D7(7), C7(7),
	H8(8), S8(8), D8(8), C8(8),
	H9(9), S9(9), D9(9), C9(9),
	H10(10), S10(10), D10(10), C10(10),
	HJ(10), SJ(10), DJ(10), CJ(10),
	HQ(10), SQ(10), DQ(10), CQ(10),
	HK(10), SK(10), DK(10), CK(10);

	private final int score;

	Card(int score) {
		this.score = score;
	}

	public int score() {
		return score;
	}
}
