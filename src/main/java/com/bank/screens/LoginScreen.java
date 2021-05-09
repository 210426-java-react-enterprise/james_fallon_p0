package com.bank.screens;

import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super ("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;

    }

    @Override
    public void render() {
        String email;
        String password;


    }
}
