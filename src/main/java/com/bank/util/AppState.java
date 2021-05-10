package com.bank.util;

import com.bank.daos.AccountDAO;
import com.bank.daos.UserDAO;
import com.bank.screens.*;
import com.bank.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private boolean appRunning;
    private Profile profile;

    public AppState(){
        System.out.println ("Opening 'JF Banking' applications");

        appRunning = true;
        consoleReader = new BufferedReader(new InputStreamReader (System.in));

        final UserDAO userDAO = new UserDAO ();
        final AccountDAO accountDAO = new AccountDAO ();
        final UserService userService = new UserService (userDAO);
        Profile profile = new Profile ();
        router = new ScreenRouter ();
        router.addScreen(new WelcomeScreen (consoleReader, router));
        router.addScreen (new RegisterAccountScreen (consoleReader, userService, router, profile));
        router.addScreen(new OpenAccountScreen (consoleReader, router, profile, accountDAO));
        router.addScreen (new DepositScreen (consoleReader, router, profile, accountDAO));
        router.addScreen (new LoginScreen (consoleReader, router, profile));

        System.out.println ("Banking application opened!");



    }
    public ScreenRouter getRouter(){return router;}



    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning){this.appRunning = appRunning;}


}
