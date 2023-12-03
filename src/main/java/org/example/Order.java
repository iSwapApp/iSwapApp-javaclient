package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Order {
    Scanner in = new Scanner(System.in);
    Card cd1 = new Card();

    //Query(SQL)
    String query;
    Connection conn;
    Statement stat;
    ResultSet result;
    private String OrderID;
    private String brand;
    private int cardID;
    private double value;

    public Order() {
    }

    public void createOrder(int ID) {
        try {
            System.out.println("Please insert the brand card that want add to order list: ");
            String str = in.next();

            conn = DBConnection.getInstance().getConnection();
            stat = conn.createStatement();

            //Card Table
            query = "SELECT * FROM card WHERE brand='" + str + "'";
            result = stat.executeQuery(query);

            while (result.next()) {
                if (ID == result.getInt("ID") && result.getString("CardValidity").equals("Active")) {
                    cardID = result.getInt("CardID");
                    brand = result.getString("brand");
                    value = result.getDouble("CardValue");
                    System.out.println("The brand is " + brand + " " + value);

                    System.out.println("Do you want to insert this(Y/N)? ");
                    str = in.next();

                    if (str.equals("Y")) {
                        int rand = (int) (Math.random() * 1000);
                        query = "INSERT INTO orderlist VALUES('" + rand + "','" + brand + "','" + value + "','" + cardID + "')";
                        stat.execute(query);

                        query = "UPDATE card SET CardValidity='NotActive' WHERE CardID='" + cardID + "'";
                        stat.execute(query);
                        break;
                    }
                }
            }//End of while
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showOrderList() {
        try {
            // query
            conn = DBConnection.getInstance().getConnection();
            stat = conn.createStatement();

            //Card Table
            query = "Select * from orderlist";
            result = stat.executeQuery(query);

            while (result.next()) {
                System.out.println("The Order ID: " + result.getInt("OrderID"));
                System.out.println("Brand: " + result.getString("Brand"));
                System.out.println("Card Value: " + result.getDouble("cardValue"));
                System.out.println();
            }//End of while
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
