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
        System.out.println ("");
        try(Scanner keyboard = new Scanner(System.in))  {

        AccountHolder newAccountHolder = new AccountHolder();

        System.out.println("You made a good choice!");
        System.out.println("-----------------------");
        System.out.print("First Name: ");
        newAccountHolder.setFirstName(keyboard.next());
        System.out.print("Last Name: ");
        newAccountHolder.setLastName(keyboard.next());
        System.out.print("Set Password: ");
        newAccountHolder.setPassWord(keyboard.next());

        } catch (Exception e){
            e.printStackTrace ();
        }

    }
}
