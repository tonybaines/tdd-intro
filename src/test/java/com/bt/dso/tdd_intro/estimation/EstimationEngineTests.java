package com.bt.dso.tdd_intro.estimation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.bt.dso.tdd_intro.estimation.EstimationEngine.Estimate.*;


public class EstimationEngineTests {
	private EstimationEngine engine;

	@Before
	public void shouldBeAbleToCreateAnEstimationEngine() {
		engine = new EstimationEngine();
		assertNotNull(engine);
	}
	
	@Test
	public void shouldTakeAnEngineerEstimateAndAdd20percent() {
		engine.addEstimate(10, ENGINEER);
		assertEquals(12, engine.correctedEstimate(), 0);
	}

	@Test
	public void shouldTakeAnotherEngineerEstimateAndAdd20percent() {
		engine.addEstimate(20, ENGINEER);
		assertEquals(24, engine.correctedEstimate(), 0);
	}

	@Test
	public void shouldTakeACustomerEstimateAndAdd80percent() {
		engine.addEstimate(10, CUSTOMER);
		assertEquals(18, engine.correctedEstimate(), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldFailWithAnExceptionIfANegativeEstimateIsGiven() {
		engine.addEstimate(-1, ENGINEER);
	}
	
	@Test
	public void shouldProduceACombinedEstimateFromTwoEngineerEstimates() {
		engine.addEstimate(10, ENGINEER);
		engine.addEstimate(20, ENGINEER);
		assertEquals(((12+24)/2), engine.correctedEstimate(), 0);
	}

	@Test
	public void shouldProduceACombinedEstimateFromACustomerAndEngineerEstimate() {
		engine.addEstimate(10, ENGINEER);
		engine.addEstimate(20, CUSTOMER);
		assertEquals(((12+36)/2), engine.correctedEstimate(), 0);
	}
	
	@Test
	public void shouldAcceptAnEngineerEstimateInStoryPointsWithATwoWeekSprintVelocityAsBeingExact(){
		engine.addEstimate(5, 20, ENGINEER);
		assertEquals(20/10*5, engine.correctedEstimate(), 0);
	}
}
