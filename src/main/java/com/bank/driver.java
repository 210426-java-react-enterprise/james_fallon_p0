package com.bank;

import com.bank.util.LinkedList;
import com.bank.util.List;

public class driver {
    public static void main(String[] args) {
        List<String> names = new LinkedList<> ();
        names.add ("James");
        names.add("Sara");
        names.add("Sean");

        for(int i = 0; i <names.size(); i++){
            System.out.println (names.get (i));
        }

        names.remove("James");

        for(int i = 0; i <names.size(); i++){
            System.out.println (names.get (i));
        }




    }
}
