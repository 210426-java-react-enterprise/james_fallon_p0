package com.bank.screens;

import com.bank.util.Profile;
import com.bank.util.ScreenRouter;

import java.io.BufferedReader;

public class Dashboard extends Screen{
    private ScreenRouter router;
    private Profile profile;

    public Dashboard(BufferedReader consoleReader, ScreenRouter router, Profile profile) {
        super ("Dashboard", "/dashboard");
        this.router = router;
        this.profile = profile;
    }

    @Override
    public void render() {

        System.out.println ("Welcome to your account DashBoard " + profile.getCurrentUser () + "!");
        System.out.println ("Your User ID: " + profile.getCurrentUser ());
        System.out.println ("Your Accounts: " /* need to work on this */);
        



    }
}
