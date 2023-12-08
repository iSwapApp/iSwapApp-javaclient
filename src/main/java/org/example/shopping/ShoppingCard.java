package org.example.shopping;

import org.example.paymentsStrategy.CreditCardPayment;
import org.example.paymentsStrategy.Payment;
import org.example.paymentsStrategy.STCPayment;
import org.example.receiptStrategy.PrintReceipt;
import org.example.receiptStrategy.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Parts of the code have been quoted from this source='https://cpit252.gitlab.io/labs/lab-10/'
public class ShoppingCard {

    List<Card> cards;

    public ShoppingCard(){
        this.cards = new ArrayList<Card>();
    }

    public List<Card> getCards(){
        return cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public double calculateTotal(){
        double total = 0;
        for (Card c : this.cards){
            total += c.getCardValue();
        }
        return total;
    }

    public void pay(Payment method){
        double amount = calculateTotal();
        method.pay(amount);
    }

    public void payCard(ShoppingCard sc){
        Scanner in = new Scanner(System.in);
        System.out.println(sc.toString());
        System.out.println("The total is "+sc.calculateTotal()+"$");
        System.out.println("Select your payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. STCPay");
        int choice = in.nextInt();
        if (choice == 1){
            sc.pay(new CreditCardPayment("4233-2527-8395-6836","12/23","406"));
        } else if (choice == 2) {
            sc.pay(new STCPayment("0560047437"));
        } else {
            System.out.println("Invalid choice!!!");
            System.exit(0);
        }
        Scanner sr = new Scanner(System.in);
        Receipt receipt;
        receipt = new PrintReceipt(sc.getCards());
        receipt.generate();
    }

    @Override
    public String toString(){
        String message ="";
        for(Card c : this.cards){
            message += c.cardInfo() + "\n";
        }
        return message;
    }

}
