package org.example;

public class NotActiveCardState implements CardState{
    @Override
    public void handle() {
        System.out.println("Card is not active. You can't Exchanging.");
    }
}
