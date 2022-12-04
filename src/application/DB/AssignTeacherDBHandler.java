package application.DB;

import BusinessLogic.AssignTeacher;

import java.sql.*;
import java.util.ArrayList;

public class AssignTeacherDBHandler
{
    private AssignTeacherDBHandler() {
    }

    private static AssignTeacherDBHandler obj = new AssignTeacherDBHandler();


    public static AssignTeacherDBHandler getInstance(){

        return obj;
    }


    public int AssignTeachertoCourse(AssignTeacher assignTeacher) {
        int rowsInserted = 0;

        String sql = "INSERT INTO assignteacher ( Semid, BatchId, Department, CourseId, TeacherId) VALUES( ?,?,?,?, ?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, assignTeacher.getSemid());
            statement.setString(2, assignTeacher.getBatchId());
            statement.setString(3, assignTeacher.getDepartment());
            statement.setString(4, assignTeacher.getCourseId());
            statement.setString(5, assignTeacher.getTeacherId());
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

    public int unassignteachertoCourse(AssignTeacher assignTeacher) {  //passing object here, needs to be written in businesslogic function as well
        int rowsDeleted = 0;
        // TODO Auto-generated method stub
        String sql = "DELETE FROM assignteacher WHERE TeacherId= '" + assignTeacher.getTeacherId() + "' AND Semid= '" + assignTeacher.getSemid() + "' AND BatchId= '" + assignTeacher.getBatchId() + "'AND CourseId= '" + assignTeacher.getCourseId() + "'AND Department= '" + assignTeacher.getDepartment() +"'";
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
        else

        return -1;
    }

    public int SearchAsssignedTeacher(AssignTeacher assignTeacher) {

        ArrayList<AssignTeacher> assignteacherarr = new ArrayList<AssignTeacher>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();

            String sql = "Select * FROM assignteacher WHERE TeacherId= '" + assignTeacher.getTeacherId() + "' AND Semid= '" + assignTeacher.getSemid() + "' AND BatchId= '" + assignTeacher.getBatchId() + "'AND CourseId= '" + assignTeacher.getCourseId() + "'AND Department= '" + assignTeacher.getDepartment() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                assignteacherarr.add(new AssignTeacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            con.close();
        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (assignteacherarr.size() == 0) {

            return -1;
        }
        else

            return 1;
    }

    public ArrayList<AssignTeacher> DisplayAsssignedTeacher( String teacherId){
        ArrayList<AssignTeacher> assignteacherarr = new ArrayList<AssignTeacher>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();

            String sql = "Select * FROM assignteacher WHERE TeacherId= '" + teacherId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                assignteacherarr.add(new AssignTeacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            con.close();
        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        return assignteacherarr;

    }

}
