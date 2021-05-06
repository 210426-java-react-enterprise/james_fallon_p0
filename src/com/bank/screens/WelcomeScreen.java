package com.bank.screens;

public class WelcomeScreen extends Screen{


    public WelcomeScreen(String name, String route) {
        super("WelcomeScreen", "/welcome");
    }

    @Override
    public void render() {
        System.out.println("Welcome to JFBanking!");
        System.out.println("****************");
        System.out.println("Press (1) to log in or press (2) to create your account today!!!!");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("Press (3) to exit");

    }
}
