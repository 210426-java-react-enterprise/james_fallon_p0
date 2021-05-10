package com.bank.util;

import com.bank.daos.userDAO;
import com.bank.screens.OpenAccountScreen;
import com.bank.screens.RegisterAccountScreen;
import com.bank.screens.WelcomeScreen;
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

        final userDAO userDAO = new userDAO ();
        final UserService userService = new UserService (userDAO);
        router = new ScreenRouter ();
        router.addScreen(new WelcomeScreen (consoleReader, router));
        router.addScreen (new RegisterAccountScreen (consoleReader, userService, router, profile));
        router.addScreen(new OpenAccountScreen (consoleReader, router, profile));

        System.out.println ("Banking application opened!");



    }
    public ScreenRouter getRouter(){return router;}



    public void setProfile(){this.profile = profile;}

    public Profile getProfile(){return profile;}

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning){this.appRunning = appRunning;}


}
