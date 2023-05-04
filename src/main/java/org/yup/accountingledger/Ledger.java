package org.yup.accountingledger;

import java.util.Scanner;

public class Ledger {


    public static int ledger(){
        int selection;

        Scanner myScanner = new Scanner(System.in);
        System.out.println("--------------------\n");
        System.out.println("1. to Display all entries");
        System.out.println("2. to Display all deposited entries ");
        System.out.println("3. to Display all negative entries");
        System.out.println("4. to exit the ledger");

        System.out.print("Your selected option is: \n");
        selection = myScanner.nextInt();
        return selection;







    }


}


