package com.bank.screens;

import com.bank.daos.AccountDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.Account;
import com.bank.services.TransactionService;
import com.bank.util.List;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

import static com.bank.Driver.app;

public class TransactionsScreen extends Screen {
    private AccountDAO accountDAO;
    private Profile profile;
    private ScreenRouter router;
    private BufferedReader consoleReader;

    public TransactionsScreen(BufferedReader consoleReader, ScreenRouter router, Profile profile, AccountDAO accountDAO) {
        super ("TransactionsScreen", "/transaction");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = profile;
        this.accountDAO = accountDAO;


    }

    @Override
    public void render() {
        List<Account> currentUsersAccounts = accountDAO.getAllAccountsByUserID (profile.getCurrentUser ());
        System.out.println ("Which account would you like to make a transaction on?");
        for (int i = 0; i < currentUsersAccounts.size (); i++) {
            Account account = currentUsersAccounts.get (i);
            System.out.println ("Press>>>" + i + " for account: " + account);
            System.out.println ("-----------------------");
        }
        try {
            int selection = Integer.parseInt (consoleReader.readLine ());

            if (selection >= currentUsersAccounts.size () || selection < 0) {
                System.out.println ("Incorrect input");
                this.render ();
            }
            currentUsersAccounts.get (selection);
            profile.setCurrentAccount (currentUsersAccounts.get (selection));
            router.navigate ("/transType");

        } catch (NumberFormatException e) {
            System.err.println ("Incorrect input");
            this.render ();
        } catch (Exception e) {
            e.getMessage ();
        }


    }
}

