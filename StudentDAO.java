import java.sql.*;
import java.util.*;

public class StudentDAO {
	 private String dbUrl= "jdbc:mysql://localhost:3306/School";
	 private String username = "root";
     private String password = "";
     
     public StudentDAO() {
    	 
     }
     
     public void addStudent(StudentRegistration student) {
    	 try{
             Connection con = DriverManager.getConnection(dbUrl,username,password);                       
             String sql ="Insert into student (first_name,last_name) values(?,?)";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,student.getFirstName());
             pst.setString(2,student.getLastName());
             pst.executeUpdate();
             con.close();
              
         }
         catch(Exception ex){
             ex.printStackTrace();
             
         }
         
     }

  public List<StudentRegistration>getStudents() {
        List<StudentRegistration> students = new ArrayList<>();
     try{
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        String sql ="Select * from student";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet resultset = pst.executeQuery();
        
        while (resultset.next()) {
            
            StudentRegistration studs = new StudentRegistration();
            studs.setId(resultset.getInt("id"));
            studs.setFirstName(resultset.getString("first_name"));
            studs.setLastName(resultset.getString("last_name"));
            
           

            students.add(studs);
        }

        resultset.close();
        pst.close();
        con.close();
    }catch(Exception ex){
        ex.printStackTrace();
        
    } 
        return students;
     }

     public void updateStudent(StudentRegistration student) {
    	 
    	 try{
             Connection con = DriverManager.getConnection(dbUrl,username,password);                       
             String sql ="Update student set first_name = ?, last_name = ? where id = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,student.getFirstName());
             pst.setString(2,student.getLastName());
             pst.setInt(3,student.getId());
             pst.executeUpdate();
             con.close();
             
         }
         catch(Exception ex){
             ex.printStackTrace();
           
         }
         
     }

     public void deleteStudent(StudentRegistration student) {
    	 try{
    	        Connection con = DriverManager.getConnection(dbUrl,username,password);
    	        String sql = "Delete from student where id =?";
    	        PreparedStatement pst = con.prepareStatement(sql);
    	        pst.setInt(1, student.getId());
    	        pst.executeUpdate();
    	        con.close();
    	       
    	    }
    	    catch(Exception ex){
    	        ex.printStackTrace();
    	       
    	    }
     }
}
