package application.DB;
import BusinessLogic.Admin;
import BusinessLogic.AdminBacklog;
import BusinessLogic.Course;
import BusinessLogic.Student;

import java.sql.*;
import java.util.ArrayList;

public class AdminDBHandler {
    Connection con=null;
    private AdminDBHandler() {
    }

    private static AdminDBHandler obj = new AdminDBHandler();


    public static AdminDBHandler getInstance(){

        return obj;
    }

    public void connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
            if(con == null) {
                System.out.println("DB connection failed");
            }
            else
                System.out.println("DB connection successful");

        }
        catch(Exception e) {
            System.out.println("exception: "
                    +e);
        }
    }

    public int addadmin(Admin admin){
        int rowsInserted = 0;

        String sql = "INSERT INTO admin (AdminId,Name,Password,Salary,PhoneNumber) VALUES(?,?, ?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, admin.getAdminId());
            statement.setString(2, admin.getName());
            statement.setString(3, admin.getPassword());

            statement.setString(4, admin.getSalary());
            statement.setString(5, admin.getPhoneNumber());



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


    public ArrayList<Admin> displayAdmin(String adminId) {

        ArrayList<Admin> adminarr = new ArrayList<Admin>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from admin where AdminId = '" + adminId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                adminarr.add(new Admin(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (adminarr.size() == 0) {


            return null;
        } else {
            System.out.println(adminarr.get(0).getName());

            return adminarr;
        }


    }

    public int SearchAdmin(String adminId) {

        ArrayList<Admin> adminarr = new ArrayList<Admin>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from admin where AdminId = '" + adminId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                adminarr.add(new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (adminarr.size() == 0) {


            return -1;
        } else {

            return 1;
        }

    }

    public int Deleteadmin(String adminid) {

        int rowsDeleted = 0;
        // TODO Auto-generated method stub
        String sql = "DELETE FROM admin WHERE AdminId= '" + adminid +  "'";
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
        } else {

            return -1;
        }
    }

    public int verifyAdmin(String adminId, String Password) {


        String Matchpassword = "Nothing";

        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select Password from admin where AdminId = '" + adminId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                Matchpassword = rs.getString(1);

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (Matchpassword.equals(Password)) {

            return 1;

        } else {

            return -1;
        }
    }


    public int updateAdmin(Admin updatedAdmin, int choice) {

        int rowsInserted = 0;
        if (choice == 1) {

            String sql = "UPDATE admin SET PhoneNumber= '" + updatedAdmin.getPhoneNumber() + "' WHERE AdminId= '" + updatedAdmin.getAdminId() + "' AND Name= '" + updatedAdmin.getName() + "' AND Password= '" + updatedAdmin.getPassword() + "'AND Salary= '" + updatedAdmin.getSalary() + "'";


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
            String sql = "UPDATE admin SET Salary= '" + updatedAdmin.getSalary() + "' WHERE AdminId= '" + updatedAdmin.getAdminId() + "' AND Name= '" + updatedAdmin.getName() + "' AND Password= '" + updatedAdmin.getPassword() + "'AND PhoneNumber= '" + updatedAdmin.getPhoneNumber() + "'";
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


}


