package monitor;

import monitor.DBConnection;
import java.sql.SQLException;

public class StudentDAO {
    public static void insertStudent(String firstName, String lastName,String email,String password,String faculty) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO users (firstname, lastname, email, password, faculty, state, role) VALUES('"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"', '"+faculty+"', 'Negatif', 'Student');";
        try{
            DBConnection.DBExecuteQuery(sql);
        }catch(Exception e){
            System.out.println("Error InsertStudent "+e);
            e.printStackTrace();
            throw e;
        }
    }
}
