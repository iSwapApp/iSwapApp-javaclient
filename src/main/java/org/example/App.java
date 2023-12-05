package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Customer c1 = new Customer();
        Card cd1 = new Card();
        ExchangingCard order = new ExchangingCard();

        byte choice;
        do {
            System.out.println("******************************");
            System.out.println("******* Welcome to App *******");
            System.out.println("******************************");
            System.out.println("| 1.Log in                    |");
            System.out.println("| 2.Create new account        |");
            System.out.println("| 3.Exit                      |");
            System.out.println("******************************");
            System.out.println("Enter your choice: ");
            choice = in.nextByte();

            if (choice == 1) {
                boolean ch = c1.check();
                if (ch == true) {
                    customerScreen(c1, cd1, choice, in, order);
                }
            } else if (choice == 2) {
                c1.newAccount();
            } else {
                System.out.println("You enter wrong choice try again!");
            }
        } while (choice != 3);
    }

    public static void customerScreen(Customer c1, Card cd1, byte choice, Scanner in, ExchangingCard order) {

        System.out.println("Welcome " + c1.getName());
        while (choice != 6) {
            System.out.println("******************************");
            System.out.println("********** iSwap App *********");
            System.out.println("******************************");
            System.out.println("| 1.Show Information         |");
            System.out.println("| 2.Show My Cards            |");
            System.out.println("| 3.Create Order             |");
            System.out.println("| 4.Exchange Card            |");
            System.out.println("| 5.Refund From the Card     |");
            System.out.println("| 6.Log out                  |");
            System.out.println("******************************");
            System.out.println("Enter your choice: ");
            choice = in.nextByte();

            if (choice == 1) {
                c1.printInfo();
            } else if (choice == 2) {
                cd1.updateCard(c1.getID());
            } else if (choice == 3) {
                order.createOrder(c1.getID());
            } else if (choice == 4) {
                order.showOrderList(c1.getID());
            } else if (choice == 5) {
                cd1.refund(c1.getID());
            } else if (choice == 6) {
                System.out.println("Good Bye.");
            } else {
                System.out.println("You enter invalid choice try again!");
            }
        }
    }
}