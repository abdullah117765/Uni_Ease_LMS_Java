package application.DB;

import BusinessLogic.Announcement;
import BusinessLogic.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class AnnouncementDBHandler {

    private AnnouncementDBHandler() {
    }

    private static AnnouncementDBHandler obj = new AnnouncementDBHandler();


    public static AnnouncementDBHandler getInstance(){

        return obj;
    }

    public int MakeAnnouncement(Announcement announcement){
        int rowsInserted = 0;

        String sql = "INSERT INTO announcement (announcement,teachercheck,studentcheck) VALUES(?,?,?)";
        PreparedStatement statement;

        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1,announcement.getAnnouncement());
            statement.setString(2,announcement.getTeachercheck());
            statement.setString(3, announcement.getStudentcheck());





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
    public ArrayList<Announcement> DisplayallAnnouncementfor(int choice){
        int rowsInserted = 0;
        ArrayList<Announcement> announcements = new ArrayList<Announcement>();
        if (choice == 2) {
            Statement stmt;
            PreparedStatement statement;
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
                stmt = con.createStatement();
                //Teacher Reacord reading
                String sql = "Select *  FROM announcement WHERE teachercheck= 'yes'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {

                   announcements.add(new Announcement(rs.getString(1), rs.getString(2), rs.getString(3)));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choice == 3) {



            Statement stmt;
            PreparedStatement statement;
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
                stmt = con.createStatement();
                //Teacher Reacord reading
                String sql = "Select *  FROM announcement WHERE studentcheck= 'yes'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    announcements.add(new Announcement(rs.getString(1), rs.getString(2), rs.getString(3)));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (rowsInserted > 0) {

            return announcements;
        }
        else{

            return announcements;
        }
    }

    }

