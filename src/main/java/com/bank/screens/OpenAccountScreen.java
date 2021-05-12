package com.bank.screens;

import com.bank.daos.AccountDAO;
import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

import static com.bank.Driver.app;

public class OpenAccountScreen extends Screen{

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
        String accountType = null;
        Double accountBalance;

        User currentUser = profile.getCurrentUser ();

        System.out.println ("Hello " + currentUser.getFirstName() + ". What kind of account would you like to Open?");
        System.out.println ("Checking>>1");
        System.out.println ("Savings>>2");

        try{

            String userSelection = consoleReader.readLine();
            switch(userSelection){
                case "1":
                    System.out.println("Opening Your Checking Account");
                    accountType = "Checking";
                    break;
                case "2":
                    System.out.println ("Opening Your Savings Account");
                    accountType = "Savings";
                    break;
                default:
                    System.out.println ("Invalid selection");

            }

            Account newAccount = new Account (accountType, 0.00);
            accountDAO.save (newAccount, currentUser);
            profile.setCurrentAccount (newAccount);
            router.navigate ("/transaction");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
