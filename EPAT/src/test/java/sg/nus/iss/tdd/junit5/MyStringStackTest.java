package sg.nus.iss.tdd.junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sg.nus.iss.tdd.junit5.MyStringStack;

public class MyStringStackTest {
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
	public void testPush() {
		MyStringStack stack = new MyStringStack();
		assertTrue(stack.isEmpty());
		stack.push(s1);
		stack.push(s2);
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testPop() {
		String o1 = null;
		MyStringStack stack = new MyStringStack();
		assertTrue(stack.isEmpty(), "Initial stack state");
		
		try {
			o1 = stack.pop();
			fail("Failed pop()");
		} catch (IndexOutOfBoundsException e) {}
		
		stack.push(s1);
		assertFalse(stack.isEmpty(), "Stack should not be empty after push()");
		
		try {
			o1 = stack.pop();
		} catch (IndexOutOfBoundsException e) { fail(); }
		
		assertSame(s1, o1);
		assertTrue(stack.isEmpty(), "Stack should be empty after poping all elements");
	}
	
	@Test
	public void testIsEmpty() {
		String s3 = null;
		MyStringStack stack = new MyStringStack();
		assertTrue(stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());
		
		stack.push(s1);
		assertFalse(stack.isEmpty());;
		
		try {
			s3 = stack.pop();
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
		
		assertSame (s1, s3);
	}
	
	@Test
	public void testStackNull() {
		String o1 = null;
		MyStringStack stack = new MyStringStack();
		
		stack.push(null);
		assertTrue(stack.isEmpty());
		
		stack.push(null);
		stack.push(s1);
		stack.push(null);
		try {
			o1 = stack.pop();
			assertSame(o1, s1);
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testStackSequence() {
		String o1 = null;
		MyStringStack stack = new MyStringStack();
		stack.push(s1);
		
		o1 = stack.pop();
		assertSame(s1, o1);
		
		stack.push(s1);
		stack.push(s2);
		assertSame(stack.pop(), s2);
		assertSame(stack.pop(), s1);
		
		assertTrue(stack.isEmpty());
	}
	
}
