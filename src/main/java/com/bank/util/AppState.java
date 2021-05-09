package com.bank.util;

import com.bank.daos.AccountHolderDAO;
import com.bank.screens.RegisterAccountScreen;
import com.bank.screens.WelcomeScreen;
import com.bank.services.AccountHolderService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private boolean appRunning;

    public AppState(){
        System.out.println ("Opening 'JF Banking' applications");

        appRunning = true;
        consoleReader = new BufferedReader(new InputStreamReader (System.in));

        final AccountHolderDAO accountHolderDAO = new AccountHolderDAO ();
        final AccountHolderService accountHolderService = new AccountHolderService (accountHolderDAO);
        router = new ScreenRouter ();
        router.addScreen(new WelcomeScreen (consoleReader, router));
        router.addScreen (new RegisterAccountScreen (consoleReader, accountHolderService));

        System.out.println ("Banking application opened!");

    }
    public ScreenRouter getRouter(){return router;}

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning){this.appRunning = appRunning;}
}
