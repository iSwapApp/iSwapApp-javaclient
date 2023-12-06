package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ExchangingCard {
    Scanner in = new Scanner(System.in);
    Card cd1 = new Card();
    CardState activeCardState = new ActiveCardState();
    CardState notActiveCardState = new NotActiveCardState();

    //Query(SQL)
    String query;
    Connection conn;
    Statement stat;
    ResultSet result;
    private String OrderID;
    private String brand;
    private int cardID;
    private double value;

    public ExchangingCard() {
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
                    activeCardState.handle();
                    System.out.println("Do you want to insert this(Y/N)? ");
                    str = in.next();

                    if (str.equalsIgnoreCase("Y")) {
                        System.out.println("What is the card do you want: ");
                        String want = in.next();
                        int rand = (int) (Math.random() * 1000);
                        query = "INSERT INTO orderlist VALUES('" + rand + "','" + brand + "','" + want + "','" + value + "','" + cardID + "','" + ID + "')";
                        stat.execute(query);

                        query = "UPDATE card SET CardValidity='NotActive' WHERE CardID='" + cardID + "'";
                        stat.execute(query);
                        break;
                    } else {
                        break;
                    }
                }  else {
                    notActiveCardState.handle();
                }
            }//End of while
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showOrderList(int ID) {
        try {
            // query
            conn = DBConnection.getInstance().getConnection();
            stat = conn.createStatement();

            //Card Table
            query = "Select * from orderlist";
            result = stat.executeQuery(query);

            while (result.next()) {
                System.out.println("The Order ID: " + result.getInt("OrderID"));
                System.out.println("Exchange From: " + result.getString("Brand"));
                String bx = result.getString("Want");
                System.out.println("Exchange To: " + bx);
                System.out.println("Card Value: " + result.getDouble("cardValue"));
                System.out.println();

                System.out.println("What order do you want : ");
                int ord = in.nextInt();

                if (ID == result.getInt("ID") && ord == result.getInt("OrderID")){
                    System.out.println("This is your card, POOR MAN!!! :(");
                    break;
                }

                //New Statement and ResultSet for loop
                Statement innerStat = conn.createStatement();
                ResultSet innerResult = innerStat.executeQuery(query);

                while (innerResult.next()){
                    if (ord == innerResult.getInt("OrderID")){
                        cardID = innerResult.getInt("CardID");
                        query = "UPDATE card SET ID='" + ID + "' WHERE CardID='" + cardID + "'";
                        stat.executeUpdate(query);

                        query = "UPDATE card SET CardValidity='Active' WHERE CardID='" + cardID + "'";
                        stat.executeUpdate(query);

                        int IDX = innerResult.getInt("ID");
                        //int IDX = 19354;
                        //System.out.println(IDX);

                        query = "UPDATE card SET ID='" + IDX + "' WHERE Brand='" + bx + "'";
                        stat.executeUpdate(query);

                        query = "DELETE FROM orderlist WHERE OrderID='" + ord + "'";
                        stat.executeUpdate(query);
                        System.out.println("Done");
                    }
                }
                innerResult.close();
                innerStat.close();
            }//End of while
            result.close();
            stat.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}