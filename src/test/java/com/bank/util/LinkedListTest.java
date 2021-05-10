package com.bank.util;

public class LinkedListTest {

    private LinkedList<String> sut;

    public void test_add_withNull(){
        //Arrange

        sut = new LinkedList<> ();

        //Act
        try {
            sut.add (null);
            System.out.println ("Test add with null did not pass");
        }catch (IllegalArgumentException e){
            System.out.println ("Test Passed");
        }
        //Assert
    }

    public void test_add_withNonNullValues{

        sut = new LinkedList<> ();

        sut.add("not null");
    }


}
