package sg.nus.iss.tdd.junit5;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sg.nus.iss.tdd.junit5.MyStringStack;

public class MyStringStackTest2 {
  private String s1, s2;

  @BeforeEach
  public void setUp() {
    s1 = "Hello";
    s2 = "there";
  }

  @AfterEach
  public void tearDown() {
    System.out.println("tearDown");
  }

  @Test
  public void new_stack_is_empty() {
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void push_1_element_make_stack_not_empty() {
    MyStringStack stack = new MyStringStack();

    stack.push(s1);

    assertFalse(stack.isEmpty());
  }

  @Test
  public void push_multi_elements_make_stack_not_empty() {
    MyStringStack stack = new MyStringStack();

    stack.push(s1);
    stack.push(s2);

    assertFalse(stack.isEmpty());
  }

  @Test
  public void popped_is_same_as_last_pushed() {
    MyStringStack stack = new MyStringStack();

    stack.push(s1);
    stack.push(s2);

    assertSame(stack.pop(), s2);
  }

  @Test
  public void popping_empty_stack_generate_IndexOutOfBoundException() {
    MyStringStack stack = new MyStringStack();

    assertThrows(IndexOutOfBoundsException.class, () -> stack.pop());
  }

  @Test
  public void popping_non_empty_stack_not_generate_IndexOutOfBoundException() {
    MyStringStack stack = new MyStringStack();
    stack.push(s1);

    assertDoesNotThrow(() -> stack.pop());
  }

  @Test
  public void pushing_null_element_is_still_empty() {
    MyStringStack stack = new MyStringStack();

    stack.push(null);

    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushing_null_element_pop_last_element() {
    MyStringStack stack = new MyStringStack();
    stack.push(s1);

    stack.push(null);

    assertSame(s1, stack.pop());
  }

  @Test
  public void reverse_order_popping() {
    MyStringStack stack = new MyStringStack();

    stack.push(s1);
    stack.push(s2);

    assertSame(s2, stack.pop());
    assertSame(s1, stack.pop());
  }

  @Test
  public void clear_stack_make_it_empty() {
    MyStringStack stack = new MyStringStack();
    stack.push(s1);
    stack.push(s2);

    stack.clear();

    assertTrue(stack.isEmpty());
  }

}
