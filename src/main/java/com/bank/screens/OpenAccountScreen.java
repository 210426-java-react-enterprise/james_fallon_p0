package com.bank.screens;

import com.bank.daos.AccountDAO;
import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;



public class OpenAccountScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private Profile profile;
    private AccountDAO accountDAO;

    public OpenAccountScreen(BufferedReader consoleReader, ScreenRouter router, Profile profile, AccountDAO accountDAO) {
        super ("OpenAccountScreen", "/open");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = profile;
        this.accountDAO = accountDAO;


    }

    @Override
    public void render() {
        String accountType;
        Double accountBalance;

        User currentUser = profile.getCurrentUser ();

        System.out.println ("Hello " + currentUser.getFirstName () + ". What kind of account would you like to Open?");
        System.out.println ("Checking>>1");
        System.out.println ("Savings>>2");
        System.out.println ("Go Back To Dashboard>>3");

        try {
            Account newAccount = new Account ();
            String userSelection = consoleReader.readLine ();
            switch (userSelection) {
                case "1":
                    System.out.println ("Opening Your Checking Account");
                    newAccount.setAccountType ("Checking");
                    accountDAO.save (newAccount, currentUser);
                    profile.setCurrentAccount (newAccount);
                    router.navigate ("/deposit");
                    break;
                case "2":
                    System.out.println ("Opening Your Savings Account");
                    newAccount.setAccountType ("Savings");
                    accountDAO.save (newAccount, currentUser);
                    profile.setCurrentAccount (newAccount);
                    router.navigate ("/deposit");
                    break;
                case "3":
                    System.out.println ("Going To Dashboard");
                    profile.setCurrentAccount (newAccount);
                    router.navigate ("/dashboard");
                    break;
                default:
                    System.err.println ("Invalid selection");
                    this.render ();

            }

        } catch (Exception e) {
            e.getMessage ();
        }

    }
}
