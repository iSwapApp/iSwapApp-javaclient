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
        try {
            DBConnection db1 = DBConnection.getInstance();
            DBConnection db2 = DBConnection.getInstance();
            if (db1 == db2) {
                System.out.println("It's a singleton");
            } else {
                System.err.println("Error: Two different objects");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        int ID;
        byte choice;

        do {
            System.out.println("******************************");
            System.out.println("******* Welcome to App *******");
            System.out.println("******************************");
            System.out.println("| 1.Log in (Customer)         |");
            System.out.println("| 2.Log in (Admin)            |");
            System.out.println("| 3.Create new account        |");
            System.out.println("| 4.Exit                      |");
            System.out.println("******************************");
            System.out.println("Enter your choice: ");
            choice = in.nextByte();

            if (choice == 1) {

                boolean ch = c1.check();
                if (ch == true){
                    customerScreen(c1, cd1, choice, in);
                }

            } else if (choice == 2) {


                System.out.println("Enter the card code: ");
                cd1.setCardCode(in.next());


            } else if (choice == 3) {
                c1.newAccount();

            } else {
                System.out.println("You enter wrong choice try again!");
            }

        } while (choice != 4);

    }

}
