package monitor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    private static String passwordDB= null;
    private static String roleDB= null;
    private static ResultSet resultSet1 = null;
    private static ResultSet resultSet2 = null;

    public static void login(String email,String password) throws SQLException, ClassNotFoundException{
        String sql1 = "SELECT password FROM `monitor`.`users` WHERE email = '"+email+"'";
        String sql2 = "SELECT role FROM `monitor`.`users` WHERE email = '"+email+"'";
        TeacherController.setEmailprofile(email);
        try{
            resultSet1 = DBConnection.DBExecute(sql1);
            resultSet2 = DBConnection.DBExecute(sql2);

            while(resultSet1.next()){
                passwordDB = resultSet1.getString("password");
                //System.out.println(passwordDB);
            }
            while(resultSet2.next()){
                roleDB = resultSet2.getString("role");
                //System.out.println(roleDB);
            }
            //System.out.println(password);
            if(passwordDB.equals(password)){
                //System.out.println("password checked!");
                if(roleDB.equals("Student")){
                    //System.out.println("you are student");
                    UserController.setIsStudent();
                }else if(roleDB.equals("Teacher")) {
                    UserController.setIsTeacher();
                }else if(roleDB.equals("Admin")) {
                    UserController.setIsAdmin();
                }else{
                    System.out.println("User deosn't exists!!");
                }
            }
        }catch(Exception e){
            System.out.println("Error login "+e);
            e.printStackTrace();
            throw e;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Display Table
    public static ObservableList<User> getCases() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM `monitor`.`users` WHERE state = 'Positif'";
        try{
            ResultSet rsSet = DBConnection.DBExecute(sql);
            ObservableList<User> data = getUserObjects(rsSet);
            //System.out.println("teeeeeest : "+rsSet.getString("firstname"));
            return data;
        } catch (SQLException e){
            System.out.println("Error getCases "+e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<User> getUserObjects(ResultSet rsSet) throws SQLException {
        try {
            ObservableList<User> data = FXCollections.observableArrayList();
            while (rsSet.next()) {
                User usr = new User();
                usr.setFirstNameprop(rsSet.getString("firstname"));
                usr.setLastNameprop(rsSet.getString("lastname"));
                usr.setEmailprop(rsSet.getString("email"));
                usr.setFacultyprop(rsSet.getString("faculty"));
                usr.setStateprop(rsSet.getString("state"));
                usr.setRoleprop(rsSet.getString("role"));
                data.add(usr);
            }
            System.out.println(data);
            return data;
        } catch (SQLException e) {
            System.out.println("getUserObjects "+e);
            e.printStackTrace();
            throw e;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
