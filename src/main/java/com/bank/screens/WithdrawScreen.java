package com.bank.screens;

import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.Account;
import com.bank.services.TransactionService;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class WithdrawScreen extends Screen {
    BufferedReader consoleReader;
    ScreenRouter router;
    Profile profile;
    TransactionService transactionService;

    public WithdrawScreen(BufferedReader consoleReader, ScreenRouter router, Profile profile, TransactionService transactionService) {
        super ("WithdrawScreen", "/withdraw");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = profile;
        this.transactionService = transactionService;
    }

    @Override
    public void render() {
        Account currentAccount = profile.getCurrentAccount ();
        System.out.print("How much would you like to Withdrawal: " + currentAccount + "\n$ ");
        try {
            double withdrawal = Double.parseDouble (consoleReader.readLine ());
            transactionService.withdraw (withdrawal);
            System.out.println ("Transaction Successful ");
            System.out.println (currentAccount);
            router.navigate ("/dashboard");

        }catch (InvalidRequestException e){
            System.err.println (e.getMessage ());
            router.navigate ("/dashboard");
        }catch (NumberFormatException e) {
            System.err.println("Incorrect input");
            this.render();
        }catch (IOException e) {
            System.err.println ("Something went wrong");
            router.navigate ("/welcome");
        }
    }
}
