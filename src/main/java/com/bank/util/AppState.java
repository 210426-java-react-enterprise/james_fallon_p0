package com.bank.util;

import com.bank.daos.AccountHolderDAO;
import com.bank.screens.WelcomeScreen;

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

        router = new ScreenRouter ();
        router.addScreen(new WelcomeScreen (consoleReader, router));

        System.out.println ("Banking application opened!");

    }
    public ScreenRouter getRouter(){return router;}

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning){this.appRunning = appRunning;}
}
