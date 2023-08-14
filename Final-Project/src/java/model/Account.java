/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {

    private int userID;
    private String email;
    private String password;
    private int customerID;
    private boolean gender;
    private int role;

    public Account() {
    }

    public Account(int userID, String email, String password, int customerID, boolean gender, int role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.customerID = customerID;
        this.gender = gender;
        this.role = role;
    }
    
    

    public Account(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Account(int userID, String email, String password, int role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Account(String email, String password, int customerID, boolean gender, int role) {
        this.email = email;
        this.password = password;
        this.customerID = customerID;
        this.gender = gender;
        this.role = role;
    }

    public Account(String email, int customerID, boolean gender) {
        this.email = email;
        this.customerID = customerID;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Account{" + "userID=" + userID + ", email=" + email + ", password=" + password + ", customerID=" + customerID + ", gender=" + gender + ", role=" + role + '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
