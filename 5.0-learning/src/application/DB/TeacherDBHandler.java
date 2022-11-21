package application.DB;

import BusinessLogic.Admin;
import BusinessLogic.AssignTeacher;
import BusinessLogic.Teacher;
import BusinessLogic.TeacherBacklog;

import java.sql.*;
import java.util.ArrayList;


public class TeacherDBHandler {

	
	private TeacherDBHandler() {
		super();
	}


	private static TeacherDBHandler obj = new TeacherDBHandler();


    public static TeacherDBHandler getInstance(){
    	
        return obj;
    }
	
	
	
	

    public void connectDB() {
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            if (con == null) {
                System.out.println("DB connection failed");
            } else
                System.out.println("DB connection successful");

        } catch (Exception e) {
            System.out.println("exception: "
                    + e);
        }
    }

 
   //  
    
    
    
    public ArrayList<Teacher> displayoneTeacher(String teacherId) {

        ArrayList<Teacher> teacher = new ArrayList<Teacher>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
             String sql = "Select * from teacher where TeacherId = '" + teacherId + "'"; 
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                teacher.add(new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            con.close();
        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        return teacher;


    }
    public ArrayList<Teacher> displayTeacher() {

        ArrayList<Teacher> teacher = new ArrayList<Teacher>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from teacher";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                teacher.add(new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            con.close();
        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        return teacher;


    }

    public int SearchTeacher(String teacherId) { //return 1 if teacher found, -1 if not found

        ArrayList<Teacher> teacher = new ArrayList<Teacher>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from teacher where TeacherId = '" + teacherId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                teacher.add(new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (teacher.isEmpty()) {

            return -1;
        }
        else {
            return 1;
        }

    }


    public int addTeacher( Teacher teacher1) {
        int rowsInserted = 0;

        String sql = "INSERT INTO Teacher ( Name, Password, TeacherId, Salary, PhoneNumber) VALUES( ?,?,?,?, ?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql) ;
            statement.setString(1, teacher1.getName());
            statement.setString(2, teacher1.getPassword());
            statement.setString(3,teacher1.getTeacherId());
            statement.setString(4,teacher1.getSalary());
            statement.setString(5,teacher1.getPhoneNo());
             rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {

               con.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (rowsInserted > 0) {

            return 1;

        }
        else

            return -1;

    }

    public int deleteRecord(String Teacherid) {
        int rowsDeleted = 0;
        // TODO Auto-generated method stub
        String sql = "DELETE FROM Teacher WHERE TeacherId= '"+Teacherid+"'";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (rowsDeleted > 0) {

            return 1;
        }
       else

           return -1;
    }




    public int verifyTeacher(String teacherId, String password) { // Verify teacher

        String Matchpassword = "Nothing";

        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select Password from Teacher where TeacherId = '" + teacherId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

              Matchpassword = rs.getString(1);

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (Matchpassword.equals(password)) {

            return 1;
        }
        else {


            return -1;
        }

    }

    public int updateTeacher(Teacher updatedTeacher, int choice) {

        int rowsInserted = 0;
        if (choice == 1) {

            String sql = "UPDATE Teacher SET PhoneNumber= '" + updatedTeacher.getPhoneNo() + "' WHERE TeacherId= '" + updatedTeacher.getTeacherId() + "' AND Name= '" + updatedTeacher.getName() + "' AND Password= '" + updatedTeacher.getPassword() + "'AND Salary= '" + updatedTeacher.getSalary() + "'";


            PreparedStatement statement;
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
                statement = con.prepareStatement(sql);
                rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0){
                    con.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            String sql = "UPDATE Teacher SET Salary= '" + updatedTeacher.getSalary() + "' WHERE TeacherId= '" + updatedTeacher.getTeacherId() + "' AND Name= '" + updatedTeacher.getName() + "' AND Password= '" + updatedTeacher.getPassword() + "'AND PhoneNumber= '" + updatedTeacher.getPhoneNo() + "'";
            PreparedStatement statement;
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
                statement = con.prepareStatement(sql);
                rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0){
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (rowsInserted > 0) {

            return 1;
        }
        else{

            return -1;
        }
    }


}
