package sg.nus.iss.workshop.tdd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToDoListTest {
	// Define Test Fixtures
	String desc1 = "TDD workshop";
	String desc2 = "Refactoring workshop";
	String desc3 = "Agile architecture";
	
	Task task1; 
	Task task2;
	Task task3;
	
	ToDoList todos;
	
	public ToDoListTest() {
		super();
	}
	
	@BeforeEach
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		task1 = new Task(desc1);
		task2 = new Task(desc2);
		task3 = new Task(desc3);
		
		todos = new ToDoList();
		todos.addTask(task1);
		todos.addTask(task2);
		todos.addTask(task3);
	}
	
	@AfterEach
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
	}

	@Test
	public void testAddTask() {
		assertSame(todos.getTask(desc1), task1);
		assertSame(todos.getTask(desc2), task2);
		assertEquals(todos.getTask("Not exists"), null);
	}
	
	@Test
	public void testGetStatus() {
		assertTrue(todos.getStatus(desc1) == false);
	}
	
	@Test
	public void testRemoveTask() {
		todos.removeTask(desc1);
		assertNotSame(todos.getTask(desc1), task1);
		assertSame(todos.getTask(desc2), task2);
	}
	
	@Test
	public void testCompleteTasks() {
		assertTrue(todos.getStatus(desc1) == false);
		assertTrue(todos.getStatus(desc2) == false);
		
		todos.completeTask(desc1);
		assertTrue(todos.getStatus(desc1) == true);
		assertTrue(todos.getStatus(desc2) == false);
	}
	
	@Test
	public void testGetCompletedTasks() {
		assertTrue(todos.getCompletedTasks().isEmpty());
		todos.completeTask(desc1);
		todos.completeTask(desc3);
		
		Collection<Task> expected = Arrays.asList(task1, task3);
		Collection<Task> actual = todos.getCompletedTasks();
				
		assertEquals(expected.size(), actual.size());
		assertTrue(expected.containsAll(actual));
		assertTrue(actual.containsAll(expected));
	}
}
