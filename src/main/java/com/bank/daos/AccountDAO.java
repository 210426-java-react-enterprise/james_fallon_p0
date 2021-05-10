package com.bank.daos;

import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public void save(Account newAccount, User registeredUser){
        try(Connection conn = ConnectionFactory.getInstance ().getConnection()){
            String sqlInsertAccount = "insert into bank.accounts(account_type, balance) values(?, ?)";
            PreparedStatement pstmt = conn.prepareStatement (sqlInsertAccount, new String[]{"account_id"});
            pstmt.setString(1, newAccount.getAccountType ());
            pstmt.setDouble (2, newAccount.getAccountBalance());
            int rowsInserted = pstmt.executeUpdate ();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys ();
                while(rs.next()){
                    newAccount.setAccountId (rs.getInt("account_id"));
                }
            }

            String sqlInsertAccountUser = "insert into bank.accounts_users(account_id, user_id) values(?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement (sqlInsertAccount);
            pstmt2.setInt (1, newAccount.getAccountId ());
            pstmt2.setInt(2, registeredUser.getId ());
        }catch (SQLException throwables){
            throwables.printStackTrace ();
        }
    }
}