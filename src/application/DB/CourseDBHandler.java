package application.DB;

import BusinessLogic.Course;
import BusinessLogic.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class CourseDBHandler
{


    private CourseDBHandler() {
    }

    private static CourseDBHandler obj = new CourseDBHandler();


    public static CourseDBHandler getInstance(){

        return obj;
    }

    public int addCourse(Course course){
        int rowsInserted = 0;

        String sql = "INSERT INTO Course (CourseName, CreditHour, CourseId) VALUES( ?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, course.getCourseName());
            statement.setString(2, course.getCredithour());
            statement.setString(3, course.getCourseId());

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

        } else{
            return -1;}
    }

    public ArrayList<Course> SearchCourse(String courseid) {

        ArrayList<Course> course = new ArrayList<Course>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from Course where CourseId = '" + courseid + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                course.add(new Course(rs.getString(1), rs.getString(2), rs.getString(3)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }


            return course;

    }

    public ArrayList<Course> displayCourse() {

        ArrayList<Course> course = new ArrayList<Course>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from course";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                course.add(new Course(rs.getString(1), rs.getString(2), rs.getString(3)));

            }

            con.close();
        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        return course;


    }
    public int DeleteCourse(String CourseId){

        int rowsDeleted = 0;
        // TODO Auto-generated method stub
        String sql = "DELETE FROM Course WHERE CourseId= '" + CourseId + "'";
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

}
