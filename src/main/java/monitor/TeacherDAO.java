package monitor;

import javafx.collections.ObservableList;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TeacherDAO{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*Date date = new Date();
    java.sql.Date sql;
    date = new java.sql.Date(date.getTime());*/
    static Calendar calendar = Calendar.getInstance();
    static java.util.Date currentTime = calendar.getTime();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Update Case

    public static void addCase(String setemail) throws SQLException, ClassNotFoundException {
        long time = currentTime.getTime();
        String sql = "UPDATE `monitor`.`users` SET `state` = 'Positif' WHERE (`email` = '"+setemail+"');";
        try {
            DBConnection.DBExecuteTimeStamp(sql,time);
        } catch (Exception e) {
            System.out.println("Error addCase " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void uploadPDF(String absolutePath, String uemailset) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE `monitor`.`users` SET `pdf` = '"+absolutePath+"' WHERE (`email` = '"+uemailset+"');";
        try {
            DBConnection.DBExecuteQuery(sql);
        } catch (Exception e) {
            System.out.println("Error uploadPDF " + e);
            e.printStackTrace();
            throw e;
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void insertTeacher(String firstName, String lastName,String email,String password,String faculty) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO users (firstname, lastname, email, password, faculty, state, role) VALUES('"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"', '"+faculty+"', 'Negatif', 'Teacher');";
        try{
            DBConnection.DBExecuteQuery(sql);
        }catch(Exception e){
            System.out.println("Error InsertStudent "+e);
            e.printStackTrace();
            throw e;
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Profile Teacher:
    static List<Teacher> profileList = new ArrayList<Teacher>();
    static Teacher t1 = new Teacher();
    public static void displayProfile(String emailprofile) throws SQLException, ClassNotFoundException {
        //user2@stud.fils.upb.roString sql = "SELECT firstname,lastname,email,faculty,role FROM `monitor`.`users` WHERE email = '"+emailprofile+"'";
        String sql = "SELECT firstname,lastname,email,faculty,role FROM `monitor`.`users` WHERE email = '"+emailprofile+"'";
        System.out.println(emailprofile);
        ResultSet rsprofile = DBConnection.DBExecute(sql);
        //System.out.println("profile222222");
        try {
            while(rsprofile.next()){
                t1.setFirstName(rsprofile.getString("firstname"));
                t1.setLastName(rsprofile.getString("lastname"));
                t1.setEmail(rsprofile.getString("email"));
                t1.setFaculty(rsprofile.getString("faculty"));
                t1.setRole(rsprofile.getString("role"));

                profileList.add(t1);
            }
            //System.out.println("profile");
            //System.out.println(t1.getFirstName());
            TeacherController.setFirstnameprofile(t1.getFirstName());
            TeacherController.setLastnameprofile(t1.getLastName());
            TeacherController.setE_mailprofile(t1.getEmail());
            TeacherController.setFacultyprofile(t1.getFaculty());
            TeacherController.setRoleprofile(t1.getRole());
        } catch (Exception e) {
            System.out.println("Display Profile " + e);
            e.printStackTrace();
            throw e;
        }
    }

    // Edit profile:
    public static void editProfile(String firstname,String lastname,String email,String faculty) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE `monitor`.`users` SET `firstname` = '"+firstname+"',`lastname` = '"+lastname+"',`email` = '"+email+"',`faculty` = '"+faculty+"' WHERE (`email` = '"+email+"');";
        try {
            DBConnection.DBExecuteQuery(sql);
        } catch (Exception e) {
            System.out.println("Error addCase " + e);
            e.printStackTrace();
            throw e;
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    /* show table
    


}