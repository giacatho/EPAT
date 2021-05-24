package sg.nus.iss.tdd.junit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MoneyTest {
	@Test
	public void testEquals() {
		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
	
	@Test
	public void testSimpleAdd() {
		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money m26CHF = new Money(26, "CHF");
		
		assertTrue("Test simple add", m26CHF.equals(m12CHF.add(m14CHF)));
	}
	
}
