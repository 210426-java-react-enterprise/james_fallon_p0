package com.bank;

import com.bank.util.AppState;
import com.bank.util.LinkedList;
import com.bank.util.List;

public class Driver {

    private static AppState app = new AppState ();

    public static void main(String[] args) {
     while (app.isAppRunning ()){
         app.getRouter ().navigate("/welcome");
     }




    }

    public static AppState app(){return app;}
}
