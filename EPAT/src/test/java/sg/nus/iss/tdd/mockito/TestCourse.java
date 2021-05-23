package sg.nus.iss.tdd.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCourse {
	private INameList mockedList;
	private Course course;
	
	@BeforeEach
	public void setUp() {
		mockedList = mock(INameList.class);
		course = new Course(mockedList);
	}
	
	@Test
	public void testAddAttendee() {
		course.addAttendee("Jennifer");
		
		verify(mockedList).addName("Jennifer");
	}
	
	@Test
	public void testClearAttendee() {
		course.clearAttendeesList();
		
		verify(mockedList).clear();
	}
	
	@Test
	public void testGetAttendee() {
		when(mockedList.getName(0))
			.thenReturn("Alice");
		when(mockedList.getName(1))
			.thenReturn("Bob");
		when(mockedList.getName(-1))
			.thenThrow(new RuntimeException());
		
		assertEquals("Bob", course.getAttendee(1));
		assertThrows(RuntimeException.class, 
					() -> course.getAttendee(-1));
	}
}
