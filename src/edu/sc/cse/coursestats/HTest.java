package edu.sc.cse.coursestats;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

public class HTest {

	@Test
	public void testCourseFail() {
		Course c1 = new Course("CSCE", 747, "Matthews");
		Course c2 = new Course("CSCE", 330, "Buell");
		
		assertThat(c1, hasToString(c2.toString()));
		
	}
	
	@Test
	public void testCoursePass() {
		Course c1 = new Course("CSCE", 330, "Buell");
		
		assertThat(c1, hasToString(c1.toString()));
		
	}
	
	@Test
	public void testMeetingFail() {
		Course c1 = new Course("CSCE", 747, "Matthews");
		Course c2 = new Course("CSCE", 330, "Buell");
		CourseMeeting meeting1 = new CourseMeeting("SWGN 3A01", "TR", "8:30-9:45", c1);
		CourseMeeting meeting2 = new CourseMeeting("SWGN 3A02", "TR", "8:30-9:45", c2);
		
		assertThat(meeting1.toString(), equalTo(meeting2.toString()));
	}
	
	@Test
	public void testMeetingPass() {
		Course c1 = new Course("CSCE", 747, "Matthews");
		Course c2 = new Course("CSCE", 747, "Matthews");
		CourseMeeting meeting1 = new CourseMeeting("SWGN 3A01", "TR", "8:30-9:45", c1);
		CourseMeeting meeting2 = new CourseMeeting("SWGN 3A01", "TR", "8:30-9:45", c2);
		
		assertThat(meeting1.toString(), equalTo(meeting2.toString()));
	}
	
	@Test
	public void weekTimeFail(){
		Course c1 = new Course("CSCE", 747, "Matthews");
		Course c2 = new Course("CSCE", 330, "Buell");
		WeekTime w1 = new WeekTime("Monday", "9:00", "AM", c1);
		WeekTime w2 = new WeekTime("Monday", "10:00", "AM", c2);
		
		assertThat(w1, hasToString(w2.toString()));
		
	}
	
	@Test
	public void weekTimePass(){
		Course c1 = new Course("CSCE", 330, "Matthews");
		Course c2 = new Course("CSCE", 330, "Matthews");
		WeekTime w1 = new WeekTime("Monday", "9:00", "AM", c1);
		WeekTime w2 = new WeekTime("Monday", "9:00", "AM", c2);
		
		assertThat(w1, hasToString(w1.toString()));
	}
	
	@Test
	public void weekTimeIsNot(){
		WeekTime w1 = new WeekTime("Monday", "9:00", "AM");
		WeekTime w2 = new WeekTime("Tuesday", "9:00", "AM");
		
		assertThat(w1.toString(), is(not(w2.toString())));
	}
	
	@Test
	public void weekTimeEitherOr(){
		WeekTime w1 = new WeekTime("Monday", "9:00", "AM");
		
		assertThat(w1.toString(), either(containsString("Monday")).or(containsString("9:00")));
	}
	
	@Test
	public void compareWeekTimeLess(){
		Course c1 = new Course("CSCE", 330, "Matthews");
		Course c2 = new Course("CSCE", 330, "Matthews");
		WeekTime w1 = new WeekTime("Monday", "10:00", "AM", c1);
		WeekTime w2 = new WeekTime("Monday", "9:00", "AM", c2);
		//System.out.println(w1.compareTime(w2));
		
		assertThat(w1.compareTime(w2), equalTo(-1));
	}
	
	@Test
	public void compareWeekTimeGreater(){
		Course c1 = new Course("CSCE", 330, "Matthews");
		Course c2 = new Course("CSCE", 330, "Matthews");
		WeekTime w1 = new WeekTime("Monday", "9:00", "AM", c1);
		WeekTime w2 = new WeekTime("Monday", "10:00", "AM", c2);
		//System.out.println(w1.compareTime(w2));
		
		assertThat(w1.compareTime(w2), equalTo(1));
	}
	
	@Test
	public void compareWeekTimeEqual(){
		Course c1 = new Course("CSCE", 330, "Matthews");
		Course c2 = new Course("CSCE", 330, "Matthews");
		WeekTime w1 = new WeekTime("Monday", "9:00", "AM", c1);
		WeekTime w2 = new WeekTime("Monday", "9:00", "AM", c2);
		//System.out.println(w1.compareTime(w2));
		
		assertThat(w1.compareTime(w2), equalTo(0));
	}

	@Test
	public void testNewCourseFail(){
		Course c1 = new Course("CSCE", 747, "Matthews", "8:00AM", "9:00AM");
		Course c2 = new Course("CSCE", 330, "Buell", "8:00AM", "9:00AM");
		
		assertThat(c1.toString(), equalTo(c2.toString()));
	}
	
	@Test
	public void testNewCoursePass(){
		Course c1 = new Course("CSCE", 330, "Matthews", "8:00AM", "9:00AM");
		Course c2 = new Course("CSCE", 330, "Matthews", "8:00AM", "9:00AM");
		
		assertThat(c1.toString(), equalTo(c2.toString()));
	}
	
	@Test
	public void courseCompareTimeLess(){
		Course c1 = new Course("CSCE", 747, "Matthews", "8:00AM", "10:00AM");
		Course c2 = new Course("CSCE", 330, "Buell", "8:00AM", "9:00AM");
		
		assertThat(c1.compareTime(c2), equalTo(-1));
		
	}
	
	@Test
	public void courseCompareTimeGreater(){
		Course c1 = new Course("CSCE", 747, "Matthews", "8:00AM", "9:00AM");
		Course c2 = new Course("CSCE", 330, "Buell", "8:00AM", "10:00AM");
		
		assertThat(c1.compareTime(c2), equalTo(1));
		
	}
	
	@Test
	public void courseCompareTimeEqual(){
		Course c1 = new Course("CSCE", 747, "Matthews", "8:00AM", "9:00AM");
		Course c2 = new Course("CSCE", 330, "Buell", "8:00AM", "9:00AM");
		
		assertThat(c1.compareTime(c2), equalTo(0));
		
	}
	
	
	@Test
	public void scheduleDBtestPassHC(){
		Course c1 = new Course("CSCE 330");
		
		assertThat(c1.getInstructor().trim(), equalTo("Marco Valtorta (P)"));
		
	}
	
	
	private Course testCourse = mock(Course.class);
	
	@Test
	public void MockitoTest(){
			assertTrue(testCourse instanceof Course);
	}
	
}
