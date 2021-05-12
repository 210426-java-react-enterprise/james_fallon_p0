package com.bank.services;

import com.bank.daos.UserDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService sut;
    private UserDAO mockUserDAO;
    private Connection mockConnection;



    @Before
    public void setUp(){
        mockUserDAO = mock(UserDAO.class);
        sut = new UserService (mockUserDAO);
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test(expected = InvalidRequestException.class)
    public void test_registerWithInvalidUser(){
        User invalidUser = new User("RealFirstName", "", 18, "@FakeEmail.com","realPassword");

        sut.register (invalidUser);

        verify(sut, times(0)).isUserOfAge (any ());
        verify (mockUserDAO, times (0)).save(any ());


    }

    @Test(expected = InvalidRequestException.class)
    public void test_registerNotOfAge(){
        User validUser = new User("RealFirstName", "RealLastName", 16, "RealEmail.com","realPassword");
        sut.register (validUser);
        verify(sut, times (1)).isUserValid (any ());
        verify (mockUserDAO, times (0)).save (any ());
    }


}
