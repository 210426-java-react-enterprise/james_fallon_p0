package com.bank.screens;

import com.bank.daos.UserDAO;
import com.bank.pojo.User;
import com.bank.services.UserService;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;
    private UserDAO userDao = new UserDAO();

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super ("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;

    }

    @Override
    public void render() {
        String email;
        String password;


        try {
            System.out.print ("Email>>");
            email = consoleReader.readLine ();
            System.out.print("Password>>");
            password = consoleReader.readLine ();

            if (email != null && !email.isEmpty() && password != null && !password.isEmpty()){
                User authenticatedUser = userDao.findUserByEmailAndPassword(email, password);
                if (authenticatedUser != null) {
                    System.out.println("Login successful!");
                    router.navigate("/dashboard");

                } else {
                    System.out.println("Credential not recognized. Please try again.");
                    this.render ();
                }

            }

        } catch (IOException e) {
            e.printStackTrace ();
        }



    }
}
