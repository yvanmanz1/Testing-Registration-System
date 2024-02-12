import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;
class StudentDAOTest {

	@Test
	 public void testAddStudent() {
        StudentDAO studentDAO = new StudentDAO();
        StudentRegistration student = new StudentRegistration();
        student.setFirstName("John");
        student.setLastName("Doe");

        // Add the student
        studentDAO.addStudent(student);

      
        List<StudentRegistration> students = studentDAO.getStudents();
        StudentRegistration retrievedStudent = students.get(students.size() - 1);

        assertEquals("John", retrievedStudent.getFirstName());
        assertEquals("Doe", retrievedStudent.getLastName());
    }
	 @Test
	    public void testGetStudents() {
	        StudentDAO studentDAO = new StudentDAO();

	        List<StudentRegistration> students = studentDAO.getStudents();

	        // Add assertions based on your data
	        assertFalse(students.isEmpty());
	    }
	 @Test
	    public void testUpdateStudent() {
	        StudentDAO studentDAO = new StudentDAO();

	        List<StudentRegistration> students = studentDAO.getStudents();
	        StudentRegistration existingStudent = students.get(0);

	        // Update the student
	        existingStudent.setFirstName("UpdatedFirstName");
	        existingStudent.setLastName("UpdatedLastName");

	        studentDAO.updateStudent(existingStudent);

	        List<StudentRegistration> updatedStudents = studentDAO.getStudents();
	        StudentRegistration updatedStudent = updatedStudents.get(0);

	        assertEquals("UpdatedFirstName", updatedStudent.getFirstName());
	        assertEquals("UpdatedLastName", updatedStudent.getLastName());
	    }
	 @Test
	    public void testDeleteStudent() {
	        StudentDAO studentDAO = new StudentDAO();

	        List<StudentRegistration> studentsBeforeDeletion = studentDAO.getStudents();
	        StudentRegistration studentToDelete = studentsBeforeDeletion.get(0);

	        // Delete the student
	        studentDAO.deleteStudent(studentToDelete);

	        List<StudentRegistration> studentsAfterDeletion = studentDAO.getStudents();

	        assertFalse(studentsAfterDeletion.contains(studentToDelete));
	    }
}
