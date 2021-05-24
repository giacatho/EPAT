package sg.nus.iss.tdd.junit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStringStackTest {
  private String s1, s2;

  @Before
  public void setUp() {
    s1 = "Hello";
    s2 = "there";
  }

  @After
  public void tearDown() {
    System.out.println("tearDown");
  }

  @Test
  public void testPush() {
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());

    stack.push(s1);
    stack.push(s2);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void testPop() {
    String o1;
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());

    try {
      o1 = stack.pop();
      fail();
    } catch (IndexOutOfBoundsException e) {
    }

    stack.push(s1);
    assertFalse(stack.isEmpty());

    o1 = stack.pop();
    assertSame(s1, o1);
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testPop2() {
    String o1;
    MyStringStack stack = new MyStringStack();
    assertTrue("Initial Stack state", stack.isEmpty());
    try {
      o1 = stack.pop();
      fail("Failed pop()");
    } catch (IndexOutOfBoundsException e) {
    }

    stack.push(s1);
    assertFalse("Stack should not be empty after push()", stack.isEmpty());

    o1 = stack.pop();
    assertSame(s1, o1);
    assertTrue("Stack should be empty after popping all elements", stack.isEmpty());
  }

  @Test
  public void testIsEmpty() {
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());

    stack.push(s1);
    assertFalse(stack.isEmpty());

    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testStackNull() {
    String o1;
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());

    stack.push(null);
    assertTrue(stack.isEmpty());

    stack.push(null);
    stack.push(s1);
    stack.push(null);

    o1 = stack.pop();
    assertSame(o1, s1);

    assertTrue(stack.isEmpty());
  }

  @Test
  public void testStackSequence() {
    String o1;
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());

    stack.push(s1);
    o1 = stack.pop();
    assertSame(s1, o1);

    stack.push(s1);
    stack.push(s2);
    o1 = stack.pop();
    assertSame(s2, o1);
    o1 = stack.pop();
    assertSame(s1, o1);

    assertTrue(stack.isEmpty());
  }

  @Test
  public void testClear() {
    MyStringStack stack = new MyStringStack();
    assertTrue(stack.isEmpty());

    stack.push(s1);
    stack.push(s2);
    assertFalse(stack.isEmpty());
    stack.clear();
    assertTrue(stack.isEmpty());
  }

}
