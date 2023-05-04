package org.yup.accountingledger;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class AccountingLedgerApp {




    public static void main(String[] args) {
        int userSelection;
        boolean appRunning = true;
        while (appRunning)

                do{
                    userSelection = homeMenu();

                    switch(userSelection){
                        case 1:
                            //LocalDate today = LocalDate.now();
                            //System.out.println("give me a description");
                            transDepo(false);

                            break;
                        case 2:
                            transDepo(true);

                            break;
                        case 3:
                            int ledgerSelection = Ledger.ledger();
                            switch (ledgerSelection){
                                //case one uses file reader to display all entries for the sub menu
                                case 1:
                                    try {
                                        FileReader transEntries = new FileReader("transaction.csv");
                                        BufferedReader entriesHDD = new BufferedReader(transEntries);

                                        String theTrans;
                                        while ( ( theTrans = entriesHDD.readLine() ) != null ){
                                            String[] linePiece = theTrans.split("\\|");

                                            System.out.printf("Date: %s - Time: %s - Description: %s - Vendor: %s - amount: $%.2f\n", linePiece[0], linePiece[1], linePiece[2], linePiece[3], Float.parseFloat(linePiece[4]));



                                        }
                                        entriesHDD.close();





                                    }catch (IOException e){
                                        System.out.println("Error 404 NOT FOUND");
                                        e.printStackTrace();
                                    }



                                    break;
                                case 2:
                                    break;
                                case 3:

                                    break;
                                case 4:
                                    continue;
                            }
                            break;

                        case 4:
                            System.out.println("Thank you Have a good day");
                            appRunning = false;
                            break;
                        default:
                            break;

                    }
                }
                while (userSelection > 5);



    }

    public static int homeMenu(){
        int selection;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hello! Welcome to RunAway Bank");
        System.out.println("--------------------\n");
        System.out.println("Choose and type a number");
        System.out.println("--------------------\n");
        System.out.println("1. to make a deposit");
        System.out.println("2. to make a payment ");
        System.out.println("3. to view ledger");
        System.out.println("4. to exit the ledger");

        System.out.print("Your selected option is: \n");
        selection = myScanner.nextInt();
        return selection;

    }



    //make the settings to make a deposit
    // ask the users for inputs to make the dep
    public static String transDepo(boolean isDebit) {
        String description;
        String vendor;
        double amount;
        Scanner myScanner = new Scanner(System.in);
        //Creating date for
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String transTime = timeFormat.format(date);
        String transDate = dateFormat.format(date);
        System.out.println("Deposit Information: ");
        description = myScanner.nextLine();

        System.out.println("Vendor: ");
        vendor = myScanner.nextLine();

        System.out.println("Amount: ");
        amount = myScanner.nextDouble();


        try {
            FileWriter TransFileWeWantToWrite = new FileWriter("transaction.csv", true);

            if (isDebit) {
                //This writes into the transaction.csv file using the pipe format
                TransFileWeWantToWrite.write(transDate + "|" + transTime + "|" + description + "|" + vendor + "|" + amount * -1 + "\n");


            } else {
                TransFileWeWantToWrite.write(transDate + "|" + transTime + "|" + description + "|" + vendor + "|" + amount + "\n");


            }
            TransFileWeWantToWrite.close();


        } catch (IOException e) {
            System.out.println(" File not found ");
        }


        return null;

    }

    //public static String transPay(){

    //}





}
