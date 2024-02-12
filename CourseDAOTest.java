import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseDAOTest {

    private CourseDAO courseDAO;

    @BeforeEach
    public void setUp() {
        courseDAO = new CourseDAO();
    }

   

    @Test
    public void testAddCourse() {
    
        StudentRegistration course = new StudentRegistration();
        course.setCode("INSY000");
        course.setName("Software Engineering");

        
        courseDAO.addCourse(course);

        
     
    }

    @Test
    public void testGetCourses() {
        
        List<StudentRegistration> courses = courseDAO.getCourses();


        assertNotNull(courses);
        assertFalse(courses.isEmpty());
    }

    @Test
    public void testUpdateCourse() {
        
        StudentRegistration existingCourse = new StudentRegistration();
        existingCourse.setCode("INSY111");
      

      
        existingCourse.setName("Advanced Mathematics");
        courseDAO.updatecourse(existingCourse);

        
        List<StudentRegistration> courses = courseDAO.getCourses();
        assertTrue(courses.stream().anyMatch(c -> c.getCode().equals(existingCourse.getCode()) && c.getName().equals(existingCourse.getName())));
    }

    @Test
    public void testDeleteCourse() {
        
        StudentRegistration courseToDelete = new StudentRegistration();
        courseToDelete.setCode("C003");
        courseToDelete.setName("Physics");

      
        courseDAO.addCourse(courseToDelete);

    
        courseDAO.deletecourse(courseToDelete);

        
        List<StudentRegistration> courses = courseDAO.getCourses();
        assertFalse(courses.contains(courseToDelete));
    }
}
