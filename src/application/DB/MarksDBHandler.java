package application.DB;


import BusinessLogic.AdminBacklog;
import BusinessLogic.CourseRegister;
import BusinessLogic.Marks;

import java.sql.*;
import java.util.ArrayList;

public class MarksDBHandler
{
    private MarksDBHandler() {
    }

    private static MarksDBHandler obj = new MarksDBHandler();


    public static MarksDBHandler getInstance(){

        return obj;
    }

    public int  AddMarks(Marks marks){
        int rowsInserted = 0;

        String sql = "INSERT INTO Marks ( Semid, BatchId, Department, CourseId, StudentId,Type, TMarks,OMarks) VALUES( ?,?,?,?, ?,?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, marks.getSemid());
            statement.setString(2, marks.getBatchId());
            statement.setString(3, marks.getDepartment());
            statement.setString(4, marks.getCourseId());
            statement.setString(5, marks.getStudentId());
            statement.setString(6, marks.getType());
            statement.setString(7, marks.getTMarks());
            statement.setString(8, marks.getOMarks());
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
    public int updateMarks(Marks marks) {

        int rowsInserted = 0;


            String sql = "UPDATE marks SET OMarks= '" + marks.getOMarks() + "' WHERE BatchId= '" + marks.getBatchId() + "' AND Type= '" +  marks.getType() + "' AND CourseId= '" + marks.getCourseId() + "'AND Department= '" +  marks.getDepartment() + "'AND Semid= '" +  marks.getSemid() + "'AND StudentId= '" +  marks.getStudentId() + "'AND TMarks= '" +  marks.getTMarks() + "'";


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

        if (rowsInserted > 0) {

            return 1;
        }
        else{

            return -1;
        }
    }

    public ArrayList<Marks> ViewMarks(String semid, String batchId, String department, String courseId, String studentId)
    {
        ArrayList<Marks> Markslist = new ArrayList<Marks>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from marks where courseId = '" + courseId + "'AND BatchId = '"+ batchId + "' AND Semid= '" + semid + "'AND Department= '" + department +"'AND StudentId= '" + studentId +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                Markslist.add(new Marks(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (Markslist.size() == 0) {


            return null;
        } else {

            return Markslist;
        }

    }



}
