package application.DB;

import BusinessLogic.Attendance;
import BusinessLogic.Teacher;

import java.sql.*;
import java.util.ArrayList;


public class AttendanceDBHandler {
    private AttendanceDBHandler() {
    }

    private static AttendanceDBHandler obj = new AttendanceDBHandler();


    public static AttendanceDBHandler getInstance() {

        return obj;
    }

    public int AddAttendence(Attendance attendance) {
        int rowsInserted = 0;

        String sql = "INSERT INTO Attendance ( Date, flagAttendance, Semid, BatchId, Department, CourseId, StudentId) VALUES( ?,?,?,?, ?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, attendance.getDate());
            statement.setString(2, attendance.isFlagAttendance());
            statement.setString(3, attendance.getSemid());
            statement.setString(4, attendance.getBatchId());
            statement.setString(5, attendance.getDepartment());
            statement.setString(6, attendance.getCourseId());
            statement.setString(7, attendance.getStudentId());
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

    public int updateAttendance(Attendance attendance, int choice) {

        int rowsInserted = 0;
        if (choice == 2) {

            String sql = "UPDATE Attendance SET flagAttendance= 'No' WHERE BatchId= '" + attendance.getBatchId() + "' AND Date= '" + attendance.getDate() + "' AND CourseId= '" + attendance.getCourseId() + "'AND Department= '" + attendance.getDepartment() + "'AND Semid= '" + attendance.getSemid() + "'AND StudentId= '" + attendance.getStudentId() + "'";


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
        } else if (choice == 1) {
            String sql = "UPDATE Attendance SET flagAttendance= 'yes' WHERE BatchId= '" + attendance.getBatchId() + "' AND Date= '" + attendance.getDate() + "' AND CourseId= '" + attendance.getCourseId() + "'AND Department= '" + attendance.getDepartment() + "'AND Semid= '" + attendance.getSemid() + "'AND StudentId= '" + attendance.getStudentId() + "'";
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
        } else {

            return -1;
        }
    }

    public ArrayList<Attendance> SearchAttendance(String semid, String batchId, String department, String courseId, String studentId,String Date)
    {
        ArrayList<Attendance> Attendencelist = new ArrayList<Attendance>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from attendance where courseId = '" + courseId + "'AND BatchId = '"+ batchId + "' AND Semid= '" + semid + "'AND Department= '" + department +"'AND StudentId= '" + studentId +"'AND Date= '" + Date +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                Attendencelist.add(new Attendance(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (Attendencelist.size() == 0) {


            return Attendencelist;
        } else {
            for (int i=0;i<Attendencelist.size();i++){
                System.out.println(Attendencelist.get(i).isFlagAttendance());
            }
            return Attendencelist;
        }

    }

    public ArrayList<Attendance> ViewAttendance(String semid, String batchId, String department, String courseId, String studentId)
    {
        ArrayList<Attendance> Attendencelist = new ArrayList<Attendance>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from attendance where courseId = '" + courseId + "'AND BatchId = '"+ batchId + "' AND Semid= '" + semid + "'AND Department= '" + department +"'AND StudentId= '" + studentId +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                Attendencelist.add(new Attendance(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (Attendencelist.size() == 0) {


            return null;
        } else {

            return Attendencelist;
        }

    }




}