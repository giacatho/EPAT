package sg.nus.iss.tdd.fake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestForexCalculatorUsingMock {
	private ExchangeRateProvider erp;
	
	@BeforeEach
	public void setUp() {
		erp = mock(ExchangeRateProvider.class);
	}
	
	@Test
	public void testUsingMock() {
		when(erp.getRate(anyString(), anyString()))
			.thenReturn(1.4);
		
		ForexCalculator f = new ForexCalculator(erp);
		double expectd = 140;
		double delta = 0.001;
		
		assertEquals(expectd, f.calc("SGD", 100, "USD"), delta);
		verify(erp, times(1)).getRate("SGD", "USD");
		
	}
}
