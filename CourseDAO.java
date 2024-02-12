import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
	 private String dbUrl= "jdbc:mysql://localhost:3306/School";
	 private String username = "root";
     private String password = "";
     
     public CourseDAO() {
    	 
     }
     
     public void addCourse(StudentRegistration course) {
    	 try{
             Connection con = DriverManager.getConnection(dbUrl,username,password);                       
             String sql ="Insert into course (code,name) values(?,?)";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,course.getCode());
             pst.setString(2,course.getName());
             pst.executeUpdate();
             con.close();
              
         }
         catch(Exception ex){
             ex.printStackTrace();
             
         }
         
     }

  public List<StudentRegistration>getCourses() {
        List<StudentRegistration> courses = new ArrayList<>();
     try{
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        String sql ="Select * from course";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet resultset = pst.executeQuery();
        
        while (resultset.next()) {
            
            StudentRegistration crs = new StudentRegistration();
            
            crs.setCode(resultset.getString("code"));
            crs.setName(resultset.getString("name"));
            
           

            courses.add(crs);
        }

        resultset.close();
        pst.close();
        con.close();
    }catch(Exception ex){
        ex.printStackTrace();
        
    } 
        return courses;
     }

     public void updatecourse(StudentRegistration course) {
    	 
    	 try{
             Connection con = DriverManager.getConnection(dbUrl,username,password);                       
             String sql ="Update course set name = ? where code = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,course.getName());
             pst.setString(2,course.getCode());
             
             pst.executeUpdate();
             con.close();
             
         }
         catch(Exception ex){
             ex.printStackTrace();
           
         }
         
     }

     public void deletecourse(StudentRegistration course) {
    	 try{
    	        Connection con = DriverManager.getConnection(dbUrl,username,password);
    	        String sql = "Delete from course where code =?";
    	        PreparedStatement pst = con.prepareStatement(sql);
    	        pst.setString(1, course.getCode());
    	        pst.executeUpdate();
    	        con.close();
    	       
    	    }
    	    catch(Exception ex){
    	        ex.printStackTrace();
    	       
    	    }
     }
}
