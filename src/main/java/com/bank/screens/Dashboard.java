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
        System.out.println ("Your User ID: " + profile.getCurrentUser ());
        System.out.println ("Your Accounts: " );

        for(int i = 0; i<currentUsersAccounts.size (); i++){
            currentUsersAccounts.get (i);
            System.out.println (i);
            System.out.println ("-----------------------");
        }

        System.out.println ("Open Account>1");
        System.out.println ("Deposit>2");
        System.out.println ("Withdraw>3");
        System.out.println ("View Transactions>4");
        System.out.println ("Exit Application>5");

        try{
            String userSelection = consoleReader.readLine();
            switch(userSelection){
                case "1":
                    System.out.println("Taking you to the New Account portal!");
                    router.navigate ("/open");
                    break;
                case "2":
                    System.out.println ("Taking you to Deposit Portal!");
                    router.navigate ("/deposit");
                    break;
                case "3":
                    System.out.println ("Taking you to Withdraw Portal!");
                    router.navigate("/withdraw");
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
