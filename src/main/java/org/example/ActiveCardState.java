package org.example;

public class ActiveCardState implements CardState {

    @Override
    public void handle(Card card) {
        System.out.println("Card is active. You can Exchanging.");
    }
}
