package sg.nus.iss.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest2 {
	@Test
	public void money_with_difference_amount_is_not_equal() {
		Money m1 = new Money(12, "SGD");
		Money m2 = new Money(14, "SGD");
		
		assertFalse(m1.equals(m2));
	}
	
	@Test
	public void money_with_difference_currency_is_not_equal() {
		Money m1 = new Money(12, "SGD");
		Money m2 = new Money(12, "USD");
		
		assertFalse(m1.equals(m2));
	}
	
	@Test
	public void money_with_same_currency_and_amount_is_equal() {
		Money m1 = new Money(12, "SGD");
		Money m2 = new Money(12, "SGD");
		
		assertTrue(m1.equals(m2));
	}
	
	@Test
	public void adding_same_currency_return_amount_added_up() {
		Money m1 = new Money(12, "SGD");
		Money m2 = new Money(14, "SGD");
		
		Money sum = m1.add(m2);
		
		assertEquals(new Money(26, "SGD"), sum);
	}
}
