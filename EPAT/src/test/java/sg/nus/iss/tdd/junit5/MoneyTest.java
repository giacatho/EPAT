package sg.nus.iss.tdd.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import sg.nus.iss.tdd.junit5.Money;

public class MoneyTest {
  @Test
  public void same_currency_and_amount_is_equal() {
    Money m1 = new Money(12, "SGD");
    Money m2 = new Money(12, "SGD");

    assertEquals(m1, m2);
  }
  
  @Test
  public void different_amount_is_not_equal() {
    Money m1 = new Money(12, "SGD");
    Money m2 = new Money(14, "SGD");

    assertFalse(m1.equals(m2));
  }

  @Test
  public void different_currency_is_not_equal() {
    Money m1 = new Money(12, "SGD");
    Money m2 = new Money(12, "USD");

    assertFalse(m1.equals(m2));
  }

  

  @Test
  public void adding_same_currency_return_amount_added_up() {
    Money m1 = new Money(12, "SGD");
    Money m2 = new Money(14, "SGD");

    Money sum = m1.add(m2);

    assertEquals(new Money(26, "SGD"), sum);
  }
}
