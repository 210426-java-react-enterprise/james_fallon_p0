package com.bank.screens;

import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.Account;
import com.bank.services.TransactionService;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class DepositScreen extends Screen {
    BufferedReader consoleReader;
    ScreenRouter router;
    Profile profile;
    TransactionService transactionService;

    public DepositScreen(BufferedReader consoleReader, ScreenRouter router, Profile profile, TransactionService transactionService) {
        super ("DepositScreen", "/deposit");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = profile;
        this.transactionService = transactionService;
    }

    @Override
    public void render() {
        Account currentAccount = profile.getCurrentAccount ();
        System.out.print ("How much money would you like to deposit into this account:  " + currentAccount + "\n$ ");

        try {
            double deposit = Double.parseDouble (consoleReader.readLine ());
            transactionService.deposit (deposit);
            System.out.println ("Transaction Successful ");
            System.out.println (currentAccount);
            router.navigate ("/dashboard");

        } catch (InvalidRequestException e) {
            System.err.println (e.getMessage ());
            this.render ();
        } catch (NumberFormatException e) {
            System.err.println ("Incorrect input");
            this.render ();
        } catch (IOException e) {
            System.err.println ("Something went wrong");
            router.navigate ("/welcome");
        }


    }

}
