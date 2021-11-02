package sg.nus.iss.tdd.junit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStringStackTest2 {
  private String s1, s2;

  @Before
  public void setUp() throws Exception {
    s1 = "Hello";
    s2 = "there";
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("tearDown");
  }

  @Test
  public void new_stack_is_empty() {
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void push_elements_make_stack_not_empty() {
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

    assertSame("Pop should return the last pushed object", stack.pop(), s2);
  }

  @Test
  public void popping_empty_stack_generate_IndexOutOfBoundException() {
    MyStringStack stack = new MyStringStack();

    try {
      stack.pop();
      fail();
    } catch (IndexOutOfBoundsException ex) {}
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
