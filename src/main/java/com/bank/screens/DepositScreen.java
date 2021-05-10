package com.bank.screens;

import com.bank.daos.AccountDAO;
import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class DepositScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;
    private Profile profile;
    private AccountDAO accountDAO;
    private User currentUser;
    private Account currentAccount;

    public DepositScreen(BufferedReader consoleReader, ScreenRouter router, Profile profile, AccountDAO accountDAO) {
        super ("DepositScreen", "/deposit");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = profile;
        this.accountDAO = accountDAO;


    }


    @Override
    public void render() {
        double deposit;
        currentUser = profile.getCurrentUser ();
        currentAccount = profile.getCurrentAccount ();

        System.out.println (currentUser + ", how much would you like to deposit into " + currentAccount.getAccountType () + " account?");
        System.out.println (">>$");


        try {
            deposit = Double.parseDouble (consoleReader.readLine ());
            //need to finish this.
            router.navigate ("/dashboard");

        }catch (NumberFormatException e){
            System.err.println("You provided incorrect input for your deposit!");
            this.render ();
        }

        catch (IOException e) {
            e.printStackTrace ();
        }


    }
}
