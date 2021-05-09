package com.bank.screens;

import com.bank.exceptions.InvalidRequestException;
import com.bank.exceptions.ResourcePersistenceException;
import com.bank.pojo.AccountHolder;
import com.bank.services.AccountHolderService;

import java.io.BufferedReader;
import java.sql.SQLOutput;

public class RegisterAccountScreen extends Screen {

    private AccountHolderService accountHolderService;
    private BufferedReader consoleReader;
    public RegisterAccountScreen(BufferedReader consoleReader, AccountHolderService accountHolderService) {
        super ("RegisterAccount", "/register");
        this.consoleReader = consoleReader;
        this.accountHolderService = accountHolderService;
    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String email;
        String password;
        int age;

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

            AccountHolder newAccountHolder = new AccountHolder (firstName, lastName, age, email, password);
            accountHolderService.register (newAccountHolder);

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