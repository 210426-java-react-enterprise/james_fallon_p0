package com.bank.screens;

import com.bank.util.ScreenRouter;
import static com.bank.Driver.app;
import java.io.BufferedReader;

public class WelcomeScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router){
        super("WelcomeScreen", "/welcome");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {
        System.out.println ("THANK YOU FOR CHOOSING JF BANKING!");
        System.out.println ("PRESS (1) TO LOGIN.");
        System.out.println ("PRESS (2) TO CREATE YOUR FIRST ACCOUNT TODAY!!!");
        System.out.println ("PRESS (3) TO EXIT.");
        System.out.print(">>>>>>> ");
        try{
            String userSelection = consoleReader.readLine();
            switch(userSelection){
                case "1":
                    System.out.println("Taking you to your account dashboard.");
                    router.navigate ("/login");
                    break;
                case "2":
                    System.out.println ("Taking you to registration.");
                    router.navigate ("/register");
                    break;
                case "3":
                    System.out.println ("Goodbye.");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println ("Invalid Selection");
                    this.render ();

            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
