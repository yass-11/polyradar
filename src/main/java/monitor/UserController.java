package monitor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class UserController {
    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    private static Stage stage;
    private static Scene scene;
    private static Parent root;
    private static boolean isStudent = false;
    private static boolean isTeacher = false;
    private static boolean isAdmin = false;

    public static void setIsStudent() {
        UserController.isStudent = true;
    }

    public static void setIsTeacher() {
        UserController.isTeacher = true;
    }

    public static void setIsAdmin() {
        UserController.isAdmin = true;
    }

    @FXML
    void login(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        //Student
        if(isStudent == false){
            StudentController.setEmailprofile(emailIdField.getText());
            UserDAO.login(emailIdField.getText(),passwordField.getText());
        }
        if(isStudent == true){
            studentScene(event);
        }
        //Teacher
        if(isTeacher == false){
            TeacherController.setEmailprofile(emailIdField.getText());
            UserDAO.login(emailIdField.getText(),passwordField.getText());
        }
        if(isTeacher == true){
            teacherScene(event);
        }
        //Admin
        if(isAdmin == false){
            UAdminController.setEmailprofile(emailIdField.getText());
            UserDAO.login(emailIdField.getText(),passwordField.getText());
        }
        if(isAdmin == true){
            adminScene(event);
        }
    }

    private void adminScene(ActionEvent event) throws IOException{
        UAdminController.setSelected();
        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void studentScene(ActionEvent event) throws IOException{
        StudentController.setSelected();
        root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void teacherScene(ActionEvent event) throws IOException {
        TeacherController.setSelected();
        root = FXMLLoader.load(getClass().getResource("TeacherView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SceneStudSup(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void SceneTeacherSup(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("SignUpTeacher.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SceneAdminSup(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("SignUpAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
