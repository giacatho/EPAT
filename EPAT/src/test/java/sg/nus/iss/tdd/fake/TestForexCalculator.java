package sg.nus.iss.tdd.fake;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestForexCalculator {
	@Test
	public void testForexCalculator() {
		ForexCalculator f = new ForexCalculator(new FakeRateProvider());
		double expected = 140;
		double delta = 0.001;
		
		assertEquals(expected, f.calc("SGD", 100, "USD"), delta);
	}
	
}
