package com.bank.services;

import com.bank.daos.UserDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.exceptions.ResourcePersistenceException;
import com.bank.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;




import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService sut;
    private UserDAO mockUserDAO;


    @Before
    public void setUp() {
        mockUserDAO = mock (UserDAO.class);
        sut = new UserService (mockUserDAO);

    }

    @After
    public void tearDown() {
        sut = null;
        mockUserDAO = null;

    }

    @Test(expected = InvalidRequestException.class)
    public void test_registerWithInvalidUser() {
        User invalidUser = new User ("RealFirstName", "", 18, "@FakeEmail.com", "realPassword");

        sut.register (invalidUser);

        verify (sut, times (0)).isUserOfAge (any ());
        verify (mockUserDAO, times (0)).save (any ());


    }

    @Test(expected = InvalidRequestException.class)
    public void test_registerNotOfAge() {
        User validUser = new User ("RealFirstName", "RealLastName", 16, "RealEmail.com", "realPassword");
        sut.register (validUser);
        verify (sut, times (1)).isUserValid (any ());
        verify (mockUserDAO, times (0)).save (any ());
    }

    @Test
    public void test_registerTakenEmail() {
        when (mockUserDAO.isEmailAvailable (anyString ())).thenReturn (false);


        try {
            sut.register (new User (0, "First", "Last", 22, "jfallon432@gmail.com", "password"));
        } catch (Exception e) {
            assertTrue (e instanceof ResourcePersistenceException);
        } finally {


            verify (mockUserDAO, times (1)).isEmailAvailable (anyString ());
            verify (mockUserDAO, times (0)).save (any ());
        }



    }

    @Test
    public void test_registerValidUserAndUniqueEmail(){
        when (mockUserDAO.isEmailAvailable (anyString ())).thenReturn (true);



        sut.register (new User (0, "First", "Last", 22, "valid2@gmail.com", "password"));


        verify (mockUserDAO, times (1)).isEmailAvailable (anyString ());
        verify (mockUserDAO, times (1)).save (any ());

    }



}
