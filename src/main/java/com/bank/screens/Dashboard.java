package com.bank.screens;

import com.bank.daos.AccountDAO;
import com.bank.pojo.Account;
import com.bank.util.List;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

/**
 *
 */

public class Dashboard extends Screen {
    private AccountDAO accountDAO;
    private ScreenRouter router;
    private Profile profile;
    private BufferedReader consoleReader;
    private ScreenRouter screenRouter;

    public Dashboard(BufferedReader consoleReader, ScreenRouter router, Profile profile, AccountDAO accountDAO) {
        super ("Dashboard", "/dashboard");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = profile;
        this.accountDAO = accountDAO;
    }

    @Override
    public void render() {
        List<Account> currentUsersAccounts = accountDAO.getAllAccountsByUserID (profile.getCurrentUser ());

        System.out.println ("Welcome to your account DashBoard " + profile.getCurrentUser ().getFirstName () + "!");
        System.out.println ("Your User ID: " + profile.getCurrentUser ().getId ());
        System.out.println ("Your Account(s): ");

        for (int i = 0; i < currentUsersAccounts.size (); i++) {
            Account account = currentUsersAccounts.get (i);
            System.out.println ("-----------------------");
            System.out.println (account);

        }

        System.out.println ("-----------------------");
        System.out.println ("Make Transaction>1");
        System.out.println ("Open New Account>2");
        System.out.println ("Exit Application>3");

        try {
            String userSelection = consoleReader.readLine ();
            switch (userSelection) {
                case "1":
                    router.navigate ("/transaction");
                    break;
                case "2":
                    router.navigate ("/open");
                    break;
                case "3":
                    System.out.println ("Good Bye");
                    break;

                default:
                    System.out.println ("Invalid Selection");
                    this.render ();


            }
        } catch (Exception e) {
            e.printStackTrace ();
        }


    }
}