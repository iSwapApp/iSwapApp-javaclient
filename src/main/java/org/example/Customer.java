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
        return this.ID;
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


    // This method will craete a new customer
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

    // This method will check the customer if exist in Database
    public boolean check() {

        System.out.print("Enter your ID: ");
        ID = in.nextInt();

        try {
            // query
            conn = DBConnection.getInstance().getConnection();
            stat = conn.createStatement();

            //*************************************************************
            //Login Table
            query = "Select * from customer";
            result = stat.executeQuery(query);

            boolean found = false;
            while (result.next()) {

                if (ID == result.getInt("ID")) {
                    ID = result.getInt("ID");
                    name = result.getString("Name");
                    walletNumber = result.getInt("WalletNumber");
                    walletBalance = result.getDouble("WalletBalance");
                    found = true;
                    break;
                }
            }//End of while

            if (!found) {
                System.out.println("Your ID is not correct!!!");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public void printInfo(){
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.name);
        System.out.println("Wallet Number: "+this.walletNumber);
        System.out.println("Balance: "+walletBalance);
        System.out.println();
    }

}
