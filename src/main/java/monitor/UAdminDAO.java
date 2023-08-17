package monitor;

import java.sql.SQLException;

public class UAdminDAO {
    public static void insertAdmin(String firstName, String lastName,String email,String password,String faculty) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO users (firstname, lastname, email, password, faculty, state, role) VALUES('"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"', '"+faculty+"', 'Negatif', 'Admin');";
        try{
            DBConnection.DBExecuteQuery(sql);
        }catch(Exception e){
            System.out.println("Error InsertStudent "+e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void addCase(String setemail) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE `monitor`.`users` SET `state` = 'Positif' WHERE (`email` = '"+setemail+"');";
        try {
            DBConnection.DBExecuteQuery(sql);
        } catch (Exception e) {
            System.out.println("Error addCase " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
