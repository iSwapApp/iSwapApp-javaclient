package org.example.receiptStrategy;

import org.example.shopping.Card;

import java.util.List;

//Parts of the code have been quoted from this source='https://cpit252.gitlab.io/labs/lab-10/'
public class PrintReceipt extends Receipt {

    public PrintReceipt(List<Card> cards){
        super(cards);
    }

    @Override
    public void generate() {
        System.out.println("******** - ********");
        System.out.println("Card\t | Price");
        double total = 0;
        for (Card c: this.getCards()){
            System.out.println(c.getBrand() + "\t | " + c.getCardValue() + "\n");
            total += c.getCardValue();
        }
        System.out.println("The total price is "+total+" $");
    }
}
