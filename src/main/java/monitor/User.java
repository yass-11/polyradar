package monitor;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String firstName;
    private String lastName;
    private String email;
    private String state;
    private String role;
    private String faculty;

    public User(){ }
    public User(String firstName, String lastName, String email, String state, String role, String faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.state = state;
        this.role = role;
        this.faculty = faculty;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", role='" + role + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  SimpleStringProperty firstNameprop = new SimpleStringProperty();
    public  SimpleStringProperty lastNameprop = new SimpleStringProperty();
    public  SimpleStringProperty emailprop = new SimpleStringProperty();
    public  SimpleStringProperty stateprop = new SimpleStringProperty();
    public  SimpleStringProperty roleprop = new SimpleStringProperty();
    public  SimpleStringProperty facultyprop = new SimpleStringProperty();

    public User(SimpleStringProperty firstNameprop, SimpleStringProperty lastNameprop, SimpleStringProperty emailprop, SimpleStringProperty stateprop, SimpleStringProperty roleprop, SimpleStringProperty facultyprop) {
        this.firstNameprop = firstNameprop;
        this.lastNameprop = lastNameprop;
        this.emailprop = emailprop;
        this.stateprop = stateprop;
        this.roleprop = roleprop;
        this.facultyprop = facultyprop;
    }

    public String getFirstNameprop() {
        return firstNameprop.get();
    }

    public SimpleStringProperty firstNamepropProperty() {
        return firstNameprop;
    }

    public void setFirstNameprop(String firstNameprop) {
        this.firstNameprop.set(firstNameprop);
    }

    public String getLastNameprop() {
        return lastNameprop.get();
    }

    public SimpleStringProperty lastNamepropProperty() {
        return lastNameprop;
    }

    public void setLastNameprop(String lastNameprop) {
        this.lastNameprop.set(lastNameprop);
    }

    public String getEmailprop() {
        return emailprop.get();
    }

    public SimpleStringProperty emailpropProperty() {
        return emailprop;
    }

    public void setEmailprop(String emailprop) {
        this.emailprop.set(emailprop);
    }

    public String getStateprop() {
        return stateprop.get();
    }

    public SimpleStringProperty statepropProperty() {
        return stateprop;
    }

    public void setStateprop(String stateprop) {
        this.stateprop.set(stateprop);
    }

    public String getRoleprop() {
        return roleprop.get();
    }

    public SimpleStringProperty rolepropProperty() {
        return roleprop;
    }

    public void setRoleprop(String roleprop) {
        this.roleprop.set(roleprop);
    }

    public String getFacultyprop() {
        return facultyprop.get();
    }

    public SimpleStringProperty facultypropProperty() {
        return facultyprop;
    }

    public void setFacultyprop(String facultyprop) {
        this.facultyprop.set(facultyprop);
    }
}
