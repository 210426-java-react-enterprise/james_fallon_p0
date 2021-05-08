package com.bank.screens;

import com.bank.util.ScreenRouter;
import static com.bank.Driver.app;
import java.io.BufferedReader;

public class WelcomeScreen extends Screen{
    private BufferedReader consoleReaader;
    private ScreenRouter router;

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router){
        super("WelcomeScreen", "/welcome");
        this.consoleReaader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {
        System.out.println ("THANK YOU FOR CHOOSING JF BANKING!");
        System.out.println ("PRESS (1) TO LOGIN.");
        System.out.println ("PRESS (2) TO CREATE YOUR ACCOUNT TODAY!!!");
        System.out.println ("PRESS (3) TO EXIT.");
        System.out.print(">>>>>>> ");
        try{
            String userSelection = consoleReaader.readLine();
            switch(userSelection){
                case "1":
                    System.out.println("Taking you to your Account Dash Board");
                    ///route to login screen
                    break;
                case "2":
                    System.out.println ("Taking you to register screen");
                    //route to register screen
                    break;
                case "3":
                    System.out.println ("Exiting application!");
                    app().setAppRunning(false);

            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
