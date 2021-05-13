package com.bank.services;

import com.bank.daos.AccountDAO;

import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.Account;
import com.bank.util.Profile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {
    private TransactionService sut;
    private AccountDAO mockAccountDAO;
    private Profile mockProfile;
    private Account mockAccount;

    @Before
    public void setUp(){
        mockAccountDAO = mock(AccountDAO.class);
        mockProfile = mock(Profile.class);
        mockAccount = mock(Account.class);
        sut = new TransactionService (mockAccountDAO, mockProfile);
    }

    @After
    public void tearDown(){
        mockAccountDAO = null;
        sut = null;
        mockProfile =null;
    }

    @Test(expected = InvalidRequestException.class)
    public void test_depositWithInvalidAmount(){
        double invalidDeposit = -3;

        sut.deposit (invalidDeposit);


        verify (mockProfile, times (0)).getCurrentAccount ();
        verify (mockAccount, times (0)).setAccountBalance (anyDouble ());
        verify (mockAccountDAO, times(0)).updateBalance (any ());


    }

    @Test(expected = InvalidRequestException.class)
    public void test_withdrawWithInvalidAmount(){
        double invalidWithdraw = -200;

        sut.withdraw (invalidWithdraw);

        verify(mockProfile, times (0)).getCurrentAccount ();
        verify (mockAccount, times(0)).getAccountBalance ();
        verify (sut, times (0)).isBalanceValid (anyDouble ());
        verify (mockAccount, times(0)).setAccountBalance (anyDouble ());
        verify (mockAccountDAO, times (0)).updateBalance (any ());


    }









}
