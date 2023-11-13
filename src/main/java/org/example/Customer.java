package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {

    Scanner in = new Scanner(System.in);

    //Query(SQL)
    String query;
    Connection conn;
    Statement stat;
    ResultSet result;
    private int ID;
    private String name;
    private int walletNumber;
    private double walletBalance;

    // Getter Methods
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getWalletNumber() {
        return walletNumber;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    // Setter Methods
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWalletNumber(int walletNumber) {
        this.walletNumber = walletNumber;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }


    public void newAccount() {

        System.out.println("Enter your ID (must be 5 digits): ");
        ID = in.nextInt();

        System.out.println("Enter your name: ");
        name = in.next();

        walletNumber = (int) (Math.random() * Math.pow(10, 7)); //6372864

        walletBalance = 0;

        try {
            conn = DBConnection.getInstance().getConnection();
            //Connect with DataBase
            stat = conn.createStatement();

            //Create Customer
            query = "INSERT INTO Customer VALUES('" + this.ID + "','" + this.name + "','" + this.walletNumber + "','" + this.walletBalance + "')";
            stat.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Account is created!\n");
    }

}
