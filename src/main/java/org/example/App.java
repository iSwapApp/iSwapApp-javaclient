package org.example;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        Customer c1 = new Customer();
        Card cd1 = new Card();
/*        try {
            DBConnection db1 = DBConnection.getInstance();
            DBConnection db2 = DBConnection.getInstance();
            if (db1 == db2) {
                System.out.println("It's a singleton");
            } else {
                System.err.println("Error: Two different objects");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }**/

        int ID;
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
                if (ch == true){
                    customerScreen(c1, cd1, choice, in);
                }

            }  else if (choice == 2) {
                c1.newAccount();

            } else {
                System.out.println("You enter wrong choice try again!");
            }

        } while (choice != 3);

    }
    public static void customerScreen(Customer c1, Card cd1, byte choice, Scanner in) {

        System.out.println("Welcome " + c1.getName());

        while (choice != 5) {
            System.out.println("******************************");
            System.out.println("********** iSwap App *********");
            System.out.println("******************************");
            System.out.println("| 1.Show Information         |");
            System.out.println("| 2.Pay Card                 |");
            System.out.println("| 3.Exchange Card            |");
            System.out.println("| 4.Deposit to Wallet        |");
            System.out.println("| 5.Log out                  |");
            System.out.println("******************************");
            System.out.println("Enter your choice: ");
            choice = in.nextByte();

            if (choice == 1){
                c1.printInfo();
            } else if (choice == 2) {
                System.out.println("Your balance is " + c1.getWalletBalance());
                cd1.payCards();

            } else if (choice == 3) {

            } else if (choice == 4) {
                System.out.println("Enter how many do you want to deposit: ");
                int depo = in.nextInt();
                c1.setWalletBalance(depo);

            } else if (choice == 5) {
                System.out.println("Good Bye.");

            } else {
                System.out.println("You enter invalid choice try again!");
            }
        }
    }

}
