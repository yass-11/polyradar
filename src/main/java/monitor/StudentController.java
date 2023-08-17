package monitor;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentController implements Initializable{
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFaculty;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPassword;

    @FXML
    void insertStudent(ActionEvent event) throws SQLException, ClassNotFoundException {
        StudentDAO.insertStudent(txtFirstName.getText(),txtLastName.getText(),txtEmail.getText(),txtPassword.getText(),txtFaculty.getText());
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void sceneLogin(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        root = FXMLLoader.load(getClass().getResource("logIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //table view
    @FXML
    public TableView<User> displayTable;
    @FXML
    public TableColumn<User, String> colfirstName;
    @FXML
    public TableColumn<User, String> collastName;
    @FXML
    public TableColumn<User, String> colemail;
    @FXML
    public TableColumn<User, String> colfaculty;
    @FXML
    public TableColumn<User, String> colstate;
    @FXML
    public TableColumn<User, String> colrole;
    public ObservableList<User> data;
    public static boolean isSelected=false;

    public static void setSelected() {
        isSelected = true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            data = UserDAO.getCases();
            //setUsername();
            if(isSelected == true){
                colfirstName.setCellValueFactory(CellData -> CellData.getValue().firstNameprop);
                collastName.setCellValueFactory(CellData -> CellData.getValue().lastNameprop);
                colemail.setCellValueFactory(CellData -> CellData.getValue().emailprop);
                colfaculty.setCellValueFactory(CellData -> CellData.getValue().facultyprop);
                colstate.setCellValueFactory(CellData -> CellData.getValue().stateprop);
                colrole.setCellValueFactory(CellData -> CellData.getValue().roleprop);

                displayTable.setItems(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Profil

    //Display
    @FXML
    private Label labelfirstname;
    @FXML
    private Label labellastname;
    @FXML
    private Label labelfaculty;
    @FXML
    private Label labelrole;
    @FXML
    private Label labelemail;

    public static String Emailprofile;
    public static String firstnameprofile;
    public static String lastnameprofile;
    public static String e_mailprofile;
    public static String facultyprofile;
    public static String roleprofile;

    public static void setEmailprofile(String email) {
        Emailprofile = email;
    }
    public static void setFirstnameprofile(String firstnameprofile) { TeacherController.firstnameprofile = firstnameprofile; }
    public static void setLastnameprofile(String lastnameprofile) { TeacherController.lastnameprofile = lastnameprofile; }
    public static void setE_mailprofile(String e_mailprofile) { TeacherController.e_mailprofile = e_mailprofile; }
    public static void setFacultyprofile(String facultyprofile) {TeacherController.facultyprofile = facultyprofile;}
    public static void setRoleprofile(String roleprofile) {TeacherController.roleprofile = roleprofile;}

    @FXML
    void displayProfile(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        isSelected=false;
        root = FXMLLoader.load(getClass().getResource("TeacherProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void populateLabel(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        TeacherDAO.displayProfile(Emailprofile);
        labelfirstname.setText(firstnameprofile);
        labellastname.setText(lastnameprofile);
        labelemail.setText(e_mailprofile);
        labelfaculty.setText(facultyprofile);
        labelrole.setText(roleprofile);
    }

    //Edit
    @FXML
    private TextField TFlastnameedit;
    @FXML
    private TextField TFfirstnameedit;
    @FXML
    private TextField TFemailedit;
    @FXML
    private TextField TFfacultyedit;

    @FXML
    void editProfile(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        TeacherDAO.editProfile(TFfirstnameedit.getText(),TFlastnameedit.getText(),TFemailedit.getText(),TFfacultyedit.getText());
        displayProfile(event);
    }
/*
    @FXML
    private Button username;

    void setUsername()  {
        username.setText(Emailprofile);
    }
*/
//Switch scenes
@FXML
void TeacherView(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
    isSelected=true;
    root = FXMLLoader.load(getClass().getResource("TeacherView.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
    @FXML
    void addFilescene(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        isSelected=false;
        root = FXMLLoader.load(getClass().getResource("TAddFileView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
