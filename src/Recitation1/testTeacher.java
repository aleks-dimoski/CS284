package Recitation1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testTeacher {
	
	Teacher teacher = new Teacher();
	
	@Test
	void getTenure() {
		assertEquals(true, teacher.getTenure());
	}
	@Test
	void getName() {
		assertEquals("John", teacher.getName());
	}
	@Test
	void getDepartment() {
		assertEquals("Math", teacher.getDepartment());
	}

}
