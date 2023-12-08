package org.example.receiptStrategy;

import org.example.shopping.Card;

import java.util.List;

//Parts of the code have been quoted from this source='https://cpit252.gitlab.io/labs/lab-10/'
public abstract class Receipt {

    private int ID;

    private List<Card> cards;

    public Receipt(List<Card> cards){
        this.cards=cards;
    }

    public int getID(){
        return ID;
    }

    public List<Card> getCards(){
        return cards;
    }

    public abstract void generate();

}
