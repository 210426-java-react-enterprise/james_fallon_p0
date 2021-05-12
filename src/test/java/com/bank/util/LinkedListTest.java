package com.bank.util;

import org.junit.*;

public class LinkedListTest {
    private LinkedList<String> sut;

    @Before
    public void setUpTest(){
        sut = new LinkedList<> ();
    }

    @After
    public void tearDownTest(){
        sut = null;
    }

    @Test
    public void test_addWithNonNullValue(){
        //Arrange
        int expectedSize = 1;
        //Act
        sut.add("data");

        //Assert
        int actualSize = sut.size();
        Assert.assertEquals (expectedSize, actualSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addWithNullValue(){
        //Nothing to arrange

        sut.add(null);

        //JUnit asserts exception
    }



}
