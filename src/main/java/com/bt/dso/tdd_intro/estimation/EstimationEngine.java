package com.bt.dso.tdd_intro.estimation;

public class EstimationEngine {
	public enum Estimate {
		ENGINEER, CUSTOMER
	};

	private int estimates = 0;
	private int estimateCount = 0;

	public void addEstimate(int i, Estimate type) {
		if (i<0) {
			throw new IllegalArgumentException("Negative estimates not allowed");
		}
		this.estimateCount++;
		switch (type) {
		case ENGINEER:
			this.estimates += (i * (1.2));
			break;
		case CUSTOMER:
			this.estimates += (i * (1.8));
			break;
		}

	}

	public double correctedEstimate() {
		return this.estimates/this.estimateCount;
	}

	public void addEstimate(int points, int velocity, Estimate type) {
		this.estimateCount++;
		switch (type) {
		case ENGINEER:
			this.estimates += (velocity/10*points);
			break;
		}
	}

}
