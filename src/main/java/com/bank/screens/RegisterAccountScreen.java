package com.bank.screens;

import com.bank.exceptions.InvalidRequestException;
import com.bank.exceptions.ResourcePersistenceException;
import com.bank.pojo.User;
import com.bank.services.UserService;
import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

import static com.bank.Driver.app;

public class RegisterAccountScreen extends Screen {

    private UserService userService;
    private BufferedReader consoleReader;
    private ScreenRouter router;
    private Profile profile;
    public RegisterAccountScreen(BufferedReader consoleReader, UserService userService, ScreenRouter router, Profile profile) {
        super ("RegisterAccount", "/register");
        this.consoleReader = consoleReader;
        this.userService = userService;
        this.router = router;
        this.profile = profile;
    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String email;
        String password;
        int age;
        String accountType = null;
        Double accountBalance = 0.00;

        System.out.println ("CREATE YOUR ACCOUNT!");
        System.out.println ("+==================+");

        try{
            System.out.print("First Name:>>");
            firstName = consoleReader.readLine();
            System.out.print("Last Name:>>");
            lastName = consoleReader.readLine ();
            System.out.print("Email:>>");
            email = consoleReader.readLine ();
            System.out.print("Age:>>");
            age = Integer.parseInt (consoleReader.readLine ());
            System.out.print("Create Password:>>");
            password = consoleReader.readLine ();

            User newUser = new User (firstName, lastName, age, email, password);
            userService.register (newUser);
            profile.setCurrentUser (newUser);
            router.navigate ("/open");



        }catch(NumberFormatException nfe){
            System.err.println("You provided incorrect input for your age!");
            this.render ();
        }catch (InvalidRequestException | ResourcePersistenceException e){
            e.printStackTrace ();
        }catch (Exception e){
            e.printStackTrace ();
        }
    }
}