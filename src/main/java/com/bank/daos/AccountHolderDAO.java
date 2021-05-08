package com.bank.daos;

import com.bank.pojo.AccountHolder;
import com.bank.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountHolderDAO {
    public void save(AccountHolder newAccountHolder){
        try(Connection conn = ConnectionFactory.getInstance ().getConnection ()){
            String sqlInsertAccountHolder = "insert into bank.account_holder(first_name, last_name, age, email, password) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement (sqlInsertAccountHolder, new String[]{"user_id"});
            pstmt.setString(1, newAccountHolder.getFirstName ());
            pstmt.setString(2, newAccountHolder.getLastName ());
            pstmt.setInt(3, newAccountHolder.getAge ());
            pstmt.setString(3, newAccountHolder.getEmail ());
            pstmt.setString(3, newAccountHolder.getPassword ());
            int rowsInserted = pstmt.executeUpdate ();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys ();
                while(rs.next()){
                    newAccountHolder.setId(rs.getInt("user_id"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace ();
        }

    }



}
