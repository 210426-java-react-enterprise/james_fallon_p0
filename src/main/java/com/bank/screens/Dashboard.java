package com.bank.screens;

import com.bank.daos.AccountDAO;
import com.bank.pojo.Account;
import com.bank.util.List;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

import static com.bank.Driver.app;

public class Dashboard extends Screen{
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

        System.out.println ("Welcome to your account DashBoard " + profile.getCurrentUser () + "!");
        System.out.println ("Your User ID: " + profile.getCurrentUser().getId ());
        System.out.println ("Your Account(s): " );

        for(int i = 0; i<currentUsersAccounts.size (); i++){
            Account account = currentUsersAccounts.get (i);
            System.out.println ("-----------------------");
            System.out.println (account);

        }

        System.out.println ("Make or View Transaction>1");
        System.out.println ("Open New Account>2");
        System.out.println ("Exit Application>3");

        try{
            String userSelection = consoleReader.readLine();
            switch(userSelection){
                case "1":
                    System.out.println("Which account would you like to make a transaction on?");
                    for(int i = 0; i<currentUsersAccounts.size (); i++){
                        Account account = currentUsersAccounts.get (i);
                        System.out.println ("Press>>>" + i + " for account: " + account);
                        System.out.println ("-----------------------");
                        try{
                            int selection = Integer.parseInt (consoleReader.readLine ());
                            currentUsersAccounts.get(selection);
                            profile.setCurrentAccount (currentUsersAccounts.get (selection));
                            router.navigate ("/dashboard");

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case "2":
                    System.out.println ("Taking you to open a new account!");
                    router.navigate ("/open");
                    break;
                case "3":
                    System.out.println ("Good Bye");

                    break;
                case "4":
                    System.out.println ("Taking you to Transactions Portal!");
                    router.navigate ("/transactions");
                    break;
                case "5":
                    System.out.println ("Exiting Applications");
                    app().setAppRunning(false);
                default:
                    System.out.println ("Invalid Selection");
                    this.render ();


            }
        }catch(Exception e){
            e.printStackTrace();
        }



    }
}
