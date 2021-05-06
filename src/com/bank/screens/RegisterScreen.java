package com.bank.screens;

import com.bank.pojo.AccountHolder;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class RegisterScreen extends Screen{
    public RegisterScreen(String name, String route) {
        super("RegisterScreen", "/register");
    }

    @Override
    public void render() {
        try(Scanner keyboard = new Scanner(System.in))  {

        AccountHolder newAccountHolder = new AccountHolder();

        System.out.println("You made a good choice!");
        System.out.println("-----------------------");
        System.out.println("First Name: ");
        newAccountHolder.setFirstName(keyboard.nextLine());
        System.out.println("Last Name: ");
        newAccountHolder.setLastName(keyboard.nextLine());
        System.out.println ("Set Password: ");
        newAccountHolder.setPassWord(keyboard.nextLine());

        } catch (Exception NoSuchElement){
            
        }

    }
}
