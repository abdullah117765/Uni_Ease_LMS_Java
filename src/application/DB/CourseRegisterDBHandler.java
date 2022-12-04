package application.DB;

import BusinessLogic.CourseRegister;
import BusinessLogic.Courseoffer;

import java.sql.*;
import java.util.ArrayList;

public class CourseRegisterDBHandler {

    private CourseRegisterDBHandler() {
    }

    private static CourseRegisterDBHandler obj = new CourseRegisterDBHandler();


    public static CourseRegisterDBHandler getInstance(){

        return obj;
    }
    public int  RegisterCourse(CourseRegister courseRegister){
        int rowsInserted = 0;

        String sql = "INSERT INTO courseregister (Semid, BatchId,Department,CourseId,StudentId ) VALUES(?,?, ?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, courseRegister.getSemid());
            statement.setString(2, courseRegister.getBatchId());
            statement.setString(3, courseRegister.getDepartment());

            statement.setString(4, courseRegister.getCourseId());
            statement.setString(5, courseRegister.getStudentId());


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

    public ArrayList<CourseRegister> DisplayRegisterCourse(CourseRegister courseRegister){
        ArrayList<CourseRegister> courseregarr = new ArrayList<CourseRegister>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from courseregister where CourseId = '" + courseRegister.getCourseId() + "'AND BatchId = '"+ courseRegister.getBatchId() + "' AND Semid= '" + courseRegister.getSemid() + "'AND Department= '" + courseRegister.getDepartment() +"'AND StudentId= '" + courseRegister.getStudentId() +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                courseregarr.add(new CourseRegister(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (courseregarr.size() == 0) {


            return null;
        } else {

            return courseregarr;
        }
    }

    public ArrayList<CourseRegister> DisplayallcoursesRegisterbystudent(String studentid1){
        ArrayList<CourseRegister> courseregarr = new ArrayList<CourseRegister>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();

            String sql = "Select * from courseregister where StudentId = '" + studentid1 + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                courseregarr.add(new CourseRegister(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (courseregarr.size() == 0) {


            return null;
        } else {

            return courseregarr;
        }
    }
    public int SearchRegisterCourse(CourseRegister courseRegister){
        ArrayList<CourseRegister> courseregarr = new ArrayList<CourseRegister>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from courseregister where CourseId = '" + courseRegister.getCourseId() + "'AND BatchId = '"+ courseRegister.getBatchId() + "' AND Semid= '" + courseRegister.getSemid() + "'AND Department= '" + courseRegister.getDepartment() +"'AND StudentId= '" + courseRegister.getStudentId() +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                courseregarr.add(new CourseRegister(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (courseregarr.size() == 0) {


            return -1;
        } else {

            return 1;
        }

    }

    public int unregisterCourse(CourseRegister coursereg){
        int rowsDeleted = 0;
        // TODO Auto-generated method stub
        String sql = "DELETE FROM courseregister WHERE Semid= '" + coursereg.getSemid() + "' AND Department= '" + coursereg.getDepartment() + "' AND BatchId= '" + coursereg.getBatchId() + "'AND CourseId= '" + coursereg.getCourseId() + "'AND StudentId= '" + coursereg.getStudentId() + "'";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            rowsDeleted = statement.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (rowsDeleted > 0) {

            return 1;
        }
        else{

            return -1;
        }



    }
    public ArrayList<CourseRegister> DisplayallREgcoursesforattendence(String semid, String batchId, String department, String courseId){
        ArrayList<CourseRegister> courseregarr = new ArrayList<CourseRegister>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from courseregister where CourseId = '" + courseId + "'AND BatchId = '"+ batchId + "' AND Semid= '" + semid+ "'AND Department= '" + department   +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                courseregarr.add(new CourseRegister(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (courseregarr.size() == 0) {


            return null;
        } else {

            return courseregarr;

        }
    }
}
