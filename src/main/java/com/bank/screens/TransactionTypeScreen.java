package com.bank.screens;

import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

public class TransactionTypeScreen extends Screen{
    private ScreenRouter router;
    private BufferedReader consoleReader;

    public TransactionTypeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super ("TransactionTypeScreen", "/transType");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {
        System.out.println ("Deposit>>1");
        System.out.println ("Withdraw>>2");
        System.out.println ("Back To Dashboard>>3");
        try {
            String userSelection = consoleReader.readLine ();
            switch (userSelection) {
                case "1":
                    router.navigate ("/deposit");
                    break;
                case "2":
                    router.navigate("/withdraw");
                    break;
                case "3":
                    System.out.println ("Going Back to Dashboard.");
                    router.navigate ("/dashboard");
                    break;
                default:
                    System.out.println ("Invalid Selection");
                    this.render ();

            }
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

}
