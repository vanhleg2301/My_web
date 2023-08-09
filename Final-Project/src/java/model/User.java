/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class User {
    private int userID;
    private String fullname;
    private int age;
    private String address;
    private long phone;
    private String gender;
    private double amount;

    public User() {
    }

    public User(int userID, String fullname, int age, String address, long phone, String gender, double amount) {
        this.userID = userID;
        this.fullname = fullname;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.amount = amount;
    }

    public User(int userID, String fullname, int age, String address, long phone, String gender) {
        this.userID = userID;
        this.fullname = fullname;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
