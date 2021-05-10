package com.bank.screens;

import com.bank.daos.userDAO;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;
    private userDAO userDAO = new userDAO ();

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super ("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;

    }

    @Override
    public void render() {
        String email;
        String password;

       /* try{
            System.out.println("Welcome Back.");
            System.out.println("-------------");

            System.out.print("Email>>");
            email = consoleReader.readLine ();
            System.out.print("Password>>");
            email = consoleReader.readLine ();

            if(email != null && !email.isEmpty () && password != null && !password.isEmpty ()){
                //AccountHolder authenticatedAccountHolder = accountHolderDAO.
           }

        } */


    }
}
