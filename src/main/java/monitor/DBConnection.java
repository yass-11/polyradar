package monitor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet.*;

public class DBConnection {

    private static Connection connection = null;
    private static Connection connection2 = null;

    public static void DBConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitor", "root", "yassirNJ11");
            // Step 2: Allocate a 'Statement' object in the Connection
            Statement stmt = connection.createStatement();
        }catch(SQLException e){
            System.out.println("Connection Failed!");
            throw e;
        }
    }

    public static void DBDisconnect()throws SQLException{
        try {
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch(Exception e){
            throw e;
        }
    }

    public static void DBExecuteQuery(String stmt1) throws SQLException,ClassNotFoundException{
        Statement stmt = null;
        try {
            DBConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(stmt1);
        }catch(SQLException e){
            System.out.println("DBExecution Query!! " + e);
            throw e;
        }
        finally{
            if(stmt !=null){
                stmt.close();
            }
            DBDisconnect();
        }
    }

    public static ResultSet DBExecute(String sqlQuery) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            DBConnection();
            pst = connection.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
        }catch(SQLException e){
            System.out.println("Error DBExecute!! "+e);
        }/*
        finally{
            if(pst !=null && rs !=null){
                pst.close();
                rs.close();
            }
            DBDisconnect();
        }*/
        return rs;
    }

    public static void DBExecuteTimeStamp(String sqlQuery, long time) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            DBConnection();
            pst = connection.prepareStatement(sqlQuery);
            pst.setTimestamp(10, new Timestamp(time));
            rs = pst.executeQuery();
        }catch(SQLException e){
            System.out.println("Error DBExecute!! "+e);
        }
        finally{
            if(pst !=null && rs !=null){
                pst.close();
                rs.close();
            }
            DBDisconnect();
        }
    }

    public static Connection getConnect (){
        try {
            connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitor", "root", "yassirNJ11");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  connection2;
    }

    /*
    public static void getData(String stmt1) throws SQLException,ClassNotFoundException{
        Statement stmt = null;
        try {
            DBConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(stmt1);

            query = "SELECT * FROM `users` WHERE state='Positif'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        }catch(SQLException e){
            System.out.println("DBExecution Query!! " + e);
            throw e;
        }
        finally{
            if(stmt !=null){
                stmt.close();
            }
            DBDisconnect();
        }
    }
    */

/*
    public static ResultSet DBExecute(String sqlQuery) throws SQLException{
        Statement stmt = null;
        ResultSet rs = null;

        try {
            DBConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);

        }catch(SQLException e){
            System.out.println("Error DBExecute!! "+e);
        }
        finally{
            if(stmt !=null && rs !=null){
                stmt.close();
                rs.close();
            }
            DBDisconnect();
        }
        return rs;
    }



*/
}
