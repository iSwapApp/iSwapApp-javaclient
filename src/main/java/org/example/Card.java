package org.example;

public class Card {
    Customer c1 = new Customer();

    private String brand;
    private double cardValue;
    private String cardCode;
    private boolean cardValidity;

    public Card() {

    }

    // Constructor
    public Card(String brand, double cardValue, String cardNumber, boolean cardValidity) {
        this.brand = brand;
        this.cardValue = cardValue;
        this.cardCode = cardNumber;
        this.cardValidity = cardValidity;

    }

    // Getter and Setter Methods
    public String getCardName() {
        return brand;
    }

    public void setCardName(String cardName) {
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

    public boolean isCardValidity() {
        return cardValidity;
    }

    public void setCardValidity(boolean cardValidity) {
        this.cardValidity = cardValidity;
    }


}
