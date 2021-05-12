package com.bank.daos;

import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;
import com.bank.util.LinkedList;
import com.bank.util.List;

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
            PreparedStatement pstmt2 = conn.prepareStatement (sqlInsertAccountUser);
            pstmt2.setInt (1, newAccount.getAccountId ());
            pstmt2.setInt(2, registeredUser.getId ());
            pstmt2.executeUpdate ();
        }catch (SQLException throwables){
            throwables.printStackTrace ();
        }
    }

    public List<Account> getAllAccountsByUserID(User registeredUser){
        Account account = null;
        List<Account> accounts = new LinkedList<> ();
        try(Connection conn = ConnectionFactory.getInstance ().getConnection ()){
            String sql = "select * from bank.accounts join bank.accounts_users on accounts.account_id = accounts_users.account_id where user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                account = new Account();

                account.setAccountId (rs.getInt("account_id"));
                account.setAccountType (rs.getString("account_type"));
                account.setAccountBalance(rs.getDouble("balance"));

                accounts.add(account);
            }



        }catch (SQLException throwables){
            throwables.printStackTrace ();
        }
        return accounts;
    }

    public void updateBalance(Account account){
        try(Connection conn = ConnectionFactory.getInstance ().getConnection()){
            String sql= "update bank.accounts set balance = ? where account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement (sql);
            pstmt.setDouble(1, account.getAccountBalance());
            pstmt.setInt (2, account.getAccountId());
            pstmt.executeUpdate ();

        }catch (SQLException throwables){
            throwables.printStackTrace ();
        }
    }



}
