package com.bank.screens;

import com.bank.pojo.User;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

import static com.bank.Driver.app;

public class OpenAccountScreen extends Screen{

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private Profile profile;

    public OpenAccountScreen(BufferedReader consoleReader, ScreenRouter router, Profile profile) {
        super ("OpenAccountScreen", "/open");
        this.consoleReader = consoleReader;
        this.router = router;
        this.profile = app().getProfile;
        User currentUser = profile.getCurrentUser ();

    }

    @Override
    public void render() {
        System.out.println ("Hello " + "What kind of account would you like to Open?");
        System.out.println ("Checking>>1");
        System.out.println ("Savings>>2");

        try{
            String userSelection = consoleReader.readLine();
            switch(userSelection){
                case "1":
                    System.out.println("Taking you to your Account Dash Board");
                    ///route to login screen
                    break;
                case "2":
                    System.out.println ("Taking you to register screen");
                    router.navigate ("/register");
                    break;
                default:
                    System.out.println ("Invalid selection");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
