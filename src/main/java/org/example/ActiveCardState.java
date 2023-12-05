package org.example;

public class ActiveCardState implements CardState {

    @Override
    public void handle() {
        System.out.println("Card is active. You can Exchanging.");
    }
}
