package com.bank.screens;

import java.io.BufferedReader;

public class WelcomeScreen extends Screen{

    private BufferedReader consoleReader;
    //private ScreenRouter router;

    public WelcomeScreen(String name, String route) {
        super("WelcomeScreen", "/welcome");
        this.consoleReader = consoleReader;
        //this.router = router;
    }

    @Override
    public void render() {
        System.out.println("Welcome to JFBanking!");
        System.out.println("****************");
        System.out.println("Press (1) to log in or press (2) to create your account today!!!!");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("Press (3) to exit");

        try {
            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to login screen");
                    //router.navigate("/login");
                    break;
                case "2":
                    System.out.println("Lets Get Started!");
                    //router.navigate("/register");
                    break;
                case "3":
                    System.out.println("Exiting application!");
                    // we need to figure out how to tell the app the shutdown
//                    System.exit(0); // very bad practice; force closes the JVM

                    break;
                default:
                    System.out.println("Invalid selection!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
