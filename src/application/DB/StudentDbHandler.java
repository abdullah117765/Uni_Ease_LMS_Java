package application.DB;
import BusinessLogic.*;

import java.sql.*;
import java.util.ArrayList;

public class StudentDbHandler {

    private StudentDbHandler() {
    }

    private static StudentDbHandler obj = new StudentDbHandler();


    public static StudentDbHandler getInstance() {

        return obj;
    }



    public ArrayList<Student> DisplayStudent(String RollNo) { //return 1 if teacher found, -1 if not found

        ArrayList<Student> students = new ArrayList<Student>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from student where RollNumber = '" + RollNo + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                students.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (students.size() == 0) {

            return students;
        } else {

            return students;
        }

    }

    public int addStudent(Student student) {
        int rowsInserted = 0;

        String sql = "INSERT INTO student (Name,Password,RollNumber,Section,Department,PhoneNumber,Semester) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getPassword());
            statement.setString(3, student.getRollNo());
            statement.setString(4, student.getSection());
            statement.setString(5, student.getDepartment());
            statement.setString(6, student.getPhoneNo());
            statement.setString(7, student.getSemester());


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

        } else

            return -1;

    }

    public int deleteStudent(String RollNo) {
        int rowsDeleted = 0;
        // TODO Auto-generated method stub
        String sql = "DELETE FROM student WHERE RollNumber= '" + RollNo + "'";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                con.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (rowsDeleted > 0) {

            return 1;
        } else

            return -1;
    }


    public int verifyStudent(String RollNo, String password) { // Verify teacher

        String Matchpassword = "Nothing";

        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select Password from student where RollNumber = '" + RollNo + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                Matchpassword = rs.getString(1);

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (Matchpassword.equals(password)) {
            System.out.println("Yes");
            return 1;

        } else {
            System.out.println("No");

            return -1;
        }

    }


    public int updateStudent(Student updatedStudent, int choice) {

        int rowsInserted = 0;
        if (choice == 1) {

            String sql = "UPDATE student SET PhoneNumber= '" + updatedStudent.getPhoneNo() + "' WHERE RollNumber= '" + updatedStudent.getRollNo() + "' AND Password= '" + updatedStudent.getPassword() + "' AND Department= '" + updatedStudent.getDepartment() + "'AND Section= '" + updatedStudent.getSection() + "'AND Semester= '" + updatedStudent.getSemester() +"'AND Name= '" + updatedStudent.getName() +"'";


            PreparedStatement statement;
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
                statement = con.prepareStatement(sql);
                rowsInserted = statement.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            String sql = "UPDATE student SET Section= '" + updatedStudent.getSection() + "' WHERE RollNumber= '" + updatedStudent.getRollNo() + "' AND Password= '" + updatedStudent.getPassword() + "' AND Department= '" + updatedStudent.getDepartment() + "'AND PhoneNumber= '" + updatedStudent.getPhoneNo() + "'AND Semester= '" + updatedStudent.getSemester() +"'AND Name= '" + updatedStudent.getName() +"'";
            PreparedStatement statement;
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
                statement = con.prepareStatement(sql);
                rowsInserted = statement.executeUpdate();

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


    public int SearchStudent(String RollNo) { //return 1 if teacher found, -1 if not found

        ArrayList<Student> students = new ArrayList<Student>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from student where RollNumber = '" + RollNo + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                students.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (students.size() == 0) {

            return -1;
        } else {

            return 1;
        }

    }
}


