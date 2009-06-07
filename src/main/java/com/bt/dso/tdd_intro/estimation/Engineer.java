package com.bt.dso.tdd_intro.estimation;

public class Engineer extends Estimator {
	private static final double SCALING_FACTOR = 1.2;
	private final double scaledEstimate;
	public Engineer(int estimate) {
		this.scaledEstimate = estimate*SCALING_FACTOR;
	}
	public double getEstimate() {
		return this.scaledEstimate;
	}

}
