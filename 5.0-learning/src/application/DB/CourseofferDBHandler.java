package application.DB;

import BusinessLogic.Course;
import BusinessLogic.Courseoffer;
import BusinessLogic.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class CourseofferDBHandler
{
    private CourseofferDBHandler() {
    }

    private static CourseofferDBHandler obj = new CourseofferDBHandler();


    public static CourseofferDBHandler getInstance(){

        return obj;
    }

    public int OfferCourse(Courseoffer courseoffer){
        int rowsInserted = 0;

        String sql = "INSERT INTO courseoffer (semid, BatchId,courseId, Department ) VALUES(?, ?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, courseoffer.getSemId());
            statement.setString(2, courseoffer.getBatchId());
            statement.setString(3, courseoffer.getCourseId());
            statement.setString(4, courseoffer.getDepartment());

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

    public ArrayList<Courseoffer> DisplayOfferCourse(Courseoffer courseoffer){
        ArrayList<Courseoffer> courseofferarr = new ArrayList<Courseoffer>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from Courseoffer where Department = '" + courseoffer.getDepartment() + "'AND BatchId = '"+ courseoffer.getBatchId() + "' AND Semid= '" + courseoffer.getSemId() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                courseofferarr.add(new Courseoffer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (courseofferarr.size() == 0) {


            return null;
        } else {

            return courseofferarr;
        }

    }
    public int unofferCourse(Courseoffer courseoffer){
        int rowsDeleted = 0;
        // TODO Auto-generated method stub
        String sql = "DELETE FROM courseoffer WHERE semid= '" + courseoffer.getSemId() + "' AND Department= '" + courseoffer.getDepartment() + "' AND BatchId= '" + courseoffer.getBatchId() + "'AND courseId= '" + courseoffer.getCourseId() + "'";
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

            return -1;}
    }

    public int SearchofferCourse(Courseoffer courseoffer){
        int rowsInserted = 0;



        ArrayList<Courseoffer> courseofferarr = new ArrayList<Courseoffer>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * FROM courseoffer WHERE semid= '" + courseoffer.getSemId() + "' AND Department= '" + courseoffer.getDepartment() + "' AND BatchId= '" + courseoffer.getBatchId() + "'AND courseId= '" + courseoffer.getCourseId() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                courseofferarr.add(new Courseoffer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (courseofferarr.size() == 0) {
            System.out.println("yes");
            return -1;
        } else {
            System.out.println("No");
            return 1;
        }



    }

}
