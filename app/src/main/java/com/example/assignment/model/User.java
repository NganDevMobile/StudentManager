package com.example.assignment.model;

public class User {
    private int AccountID;
    private String Username, Password, FullName, Address, PhoneNumber;

    public User(String user, String pass, String fullName, String adress, int phoneNumber) {
    }

    public User(int accountID, String password) {
        AccountID = accountID;
        Password = password;
    }


    public User(int accountID, String username, String fullName, String address, String phoneNumber) {
        AccountID = accountID;
        Username = username;
        FullName = fullName;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public User(int accountID, String username, String password, String fullName, String address, String phoneNumber) {
        AccountID = accountID;
        Username = username;
        Password = password;
        FullName = fullName;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public User(String username, String password, String fullName, String address, String phoneNumber) {
        Username = username;
        Password = password;
        FullName = fullName;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
