package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Card {

    Scanner in = new Scanner(System.in);
    Customer c1 = new Customer();

    //Query(SQL)
    String query;
    Connection conn;
    Statement stat;
    ResultSet result;
    private String brand;
    private double cardValue;
    private String cardCode;
    private String cardValidity;
    private CardState state;

    public Card() {

    }

    // Constructor
    public Card(String brand, double cardValue, String cardNumber, String cardValidity) {
        this.brand = brand;
        this.cardValue = cardValue;
        this.cardCode = cardNumber;
        this.cardValidity = cardValidity;

    }

    // Getter and Setter Methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCardValue() {
        return cardValue;
    }

    public void setCardValue(double cardValue) {
        this.cardValue = cardValue;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String isCardValidity() {
        return cardValidity;
    }

    public void setCardValidity(String cardValidity) {
        this.cardValidity = cardValidity;
    }

    public void setStat(CardState stat) {
        this.state = state;
    }

    public void hanle() {
        this.state.handle();
    }

    public void payCards() {
    }

    @Override
    public String toString() {
        return "\nBrand: " + brand +
                "\nCard Value: " + cardValue +
                "\nCard Code: " + cardCode +
                "\nCard Validity: " + cardValidity + "\n";
    }

    public ArrayList<Card> updateCard(int ID) {

        ArrayList<Card> cards = new ArrayList<>();
        try {
            // query
            conn = DBConnection.getInstance().getConnection();
            stat = conn.createStatement();

            //Card Table
            query = "Select * from card";
            result = stat.executeQuery(query);

            byte count = 0;
            while (result.next()) {
                if (ID == result.getInt("ID")) {
                    Card cd1 = new Card(result.getString("Brand"), result.getDouble("CardValue"), result.getString("CardCode"), result.getString("CardValidity"));
                    cards.add(cd1);
                    System.out.print(++count);
                    System.out.println(cd1.toString());
                }
            }//End of while
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cards;
    }

    public void refund(int ID) {
        try {
            // query
            conn = DBConnection.getInstance().getConnection();
            stat = conn.createStatement();

            //Card Table
            query = "Select * from card WHERE ID='" + ID + "'";
            result = stat.executeQuery(query);

            while (result.next()) {
                if (result.getString("CardValidity").equals("Active")) {
                    System.out.println("The card "+result.getString("Brand")+" is Active do you want to refund"
                            + "(Y/N): ");
                    String str = in.next();
                    if (str.equalsIgnoreCase("Y")){
                        query = "UPDATE customer SET WalletBalance=WalletBalance+'" + result.getDouble("CardValue") + "' WHERE ID='" + ID + "'";
                        stat.executeUpdate(query);

                        query = "DELETE FROM card WHERE CardID='" + result.getInt("CardID") + "'";
                        stat.executeUpdate(query);
                        System.out.println("Done");
                        break;
                    }
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}