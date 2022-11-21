package application.DB;

import BusinessLogic.Attendance;
import BusinessLogic.Query;

import java.sql.*;
import java.util.ArrayList;

public class QueryDBHandler {

    private QueryDBHandler() {
    }

    private static QueryDBHandler obj = new QueryDBHandler();


    public static QueryDBHandler getInstance(){

        return obj;
    }


    public int addQuery(Query query){
        int rowsInserted = 0;

        String sql = "INSERT INTO Query ( Semid, BatchId, Department, CourseId, StudentId,statement, reply, queryid) VALUES( ?,?,?,?, ?,?,?,?)";
        PreparedStatement statement;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            statement = con.prepareStatement(sql);
            statement.setString(1, query.getSemid());
            statement.setString(2, query.getBatchId());
            statement.setString(3, query.getDepartment());
            statement.setString(4, query.getCourseId());
            statement.setString(5, query.getStudentId());
            statement.setString(6, query.getStatement());
            statement.setString(7, query.getReply());
            statement.setString(8, query.getQueryid());
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

    public ArrayList<Query> ViewQuerry(String semid, String batchId, String department, String courseId, String studentId){
        ArrayList<Query> QueryList = new ArrayList<Query>();


        Statement stmt;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
            stmt = con.createStatement();
            //Teacher Reacord reading
            String sql = "Select * from Query where CourseId = '" + courseId + "'AND BatchId = '"+ batchId + "' AND Semid= '" + semid + "'AND Department= '" + department +"'AND StudentId= '" + studentId +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                QueryList.add(new Query(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));

            }

            con.close();


        } catch (Exception e) {

            System.out.println("exception: " + e);
        }
        if (QueryList.size() == 0) {
            for(int i=0;i<QueryList.size();i++){
                System.out.println(QueryList.get(i).getQueryid());
            }


            return QueryList;
        } else {

            return QueryList;
        }
    }

  //  public int ReplytoQuerry(String semid, String batchId, String department, String courseId, String studentId, String Reply,String Queryid)
        public int ReplytoQuerry(Query query)
    {
        int rowsInserted = 0;


            String sql = "UPDATE Query SET reply= '" + query.getReply() + "' WHERE CourseId= '" + query.getCourseId() + "' AND Semid= '" + query.getSemid() + "' AND BatchId= '" + query.getBatchId() + "'AND StudentId= '" + query.getStudentId() + "'AND queryId= '" + query.getQueryid() +"'AND Department= '" + query.getDepartment() +"'AND statement= '" + query.getStatement() +"'";


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
    public  ArrayList<Query>  ViewReply(String semid, String batchId, String department, String courseId, String studentId, String QueryId, String Statement)
    {
        int rowsInserted = 0;
        ArrayList<Query> QueryList = new ArrayList<Query>();


            Statement stmt;
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtutor");
                stmt = con.createStatement();
                //Teacher Reacord reading
                String sql = "Select * FROM Query WHERE CourseId= '" + courseId + "' AND Semid= '" + semid + "' AND BatchId= '" + batchId + "'AND StudentId= '" + studentId + "'AND queryid= '" + QueryId +"'AND Department= '" + department +"'AND statement= '" + Statement +"'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    QueryList.add(new Query(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));

                }

                con.close();


            } catch (Exception e) {

                System.out.println("exception: " + e);
            }
            if (QueryList.size() == 0) {

                return QueryList;
            } else {



                return QueryList;
            }

    }
}



