package com.bank.screens;

import com.bank.daos.AccountDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.Account;
import com.bank.services.TransactionService;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

import static com.bank.Driver.app;

public class TransactionsScreen extends Screen {
    private TransactionService transactionService;
    private AccountDAO accountDAO;
    private Profile profile;
    private ScreenRouter router;
    private BufferedReader consoleReader;

    public TransactionsScreen(BufferedReader consoleReader, ScreenRouter router, Profile profile, TransactionService transactionService) {
        super ("TransactionsScreen", "/transaction");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = profile;
        this.transactionService = transactionService;


    }

    @Override
    public void render() {
       Account currentAccount = profile.getCurrentAccount ();
       if (currentAccount.getAccountBalance () == 0){
           depositRender (currentAccount);
       }
       else{
           System.out.println ("Deposit>>1");
           System.out.println ("Withdraw>>2");
           System.out.println ("Back To Dashboard>>3");
           try{
               String userSelection = consoleReader.readLine();
               switch(userSelection){
                   case "1":
                       depositRender (currentAccount);
                       break;
                   case "2":
                       withdrawRender (currentAccount);
                       break;
                   case "3":
                       System.out.println ("Going Back to Dashboard.");
                       router.navigate ("/dashboard");
                       break;
                   default:
                       System.out.println ("Invalid Selection");
                       this.render ();

               }
               router.navigate ("/dashboard");
           }catch(Exception e){
               e.printStackTrace();
           }
       }
    }

    public void depositRender(Account currentAccount){
        System.out.println ("How much money would you like to deposit into this account: " + currentAccount);
        try {
            double deposit = Double.parseDouble (consoleReader.readLine ());
            transactionService.deposit (deposit, currentAccount);
            System.out.println ("Transaction Successful ");
            System.out.println (currentAccount);
            router.navigate ("/dashboard");

        }catch (InvalidRequestException e){
            e.printStackTrace ();
            this.render();
        }catch (NumberFormatException e) {
            System.err.println("Incorrect input");
            this.render();
        }catch (IOException e) {
            e.printStackTrace ();
        }



    }

    public void withdrawRender(Account currentAccount){
        System.out.println ("How much money would you like to take out of this account: " + currentAccount);
        try {
            double deposit = Double.parseDouble (consoleReader.readLine ());
            transactionService.deposit (deposit, currentAccount);
            System.out.println ("Transaction Successful ");
            System.out.println (currentAccount);
            router.navigate ("/dashboard");

        }catch (InvalidRequestException e){
            System.err.println (e.getMessage ());
            this.render();
        }catch (NumberFormatException e) {
            System.err.println("Incorrect input");
            this.render();
        }catch (IOException e) {
            System.err.println ("Something went wrong");
            router.navigate ("/welcome");
        }


    }
}
