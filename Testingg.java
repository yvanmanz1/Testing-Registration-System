import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testingg {

	@Test
	public void test() {
		StudentRegistration student =new StudentRegistration();
		student.setFirstName("Manishimwe");
		student.setLastName("Brenda Boo");
		
		int addnumber= student.addtwonumbers(3, 3);
		assertEquals(6, addnumber);
	}


}
