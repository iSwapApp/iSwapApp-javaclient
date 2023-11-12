package org.example;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
    }
}
