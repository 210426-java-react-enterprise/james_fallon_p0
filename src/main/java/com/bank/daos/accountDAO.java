package com.bank.daos;

import com.bank.pojo.Account;
import com.bank.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class accountDAO {
    public void save(Account newAccount){
        try(Connection conn = ConnectionFactory.getInstance ().getConnection ()){
            String sqlInsertUser = "insert into bank.account(type, balance) values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement (sqlInsertUser, new String[]{"account_id"});
            pstmt.setString(1, newUser.getFirstName ());
            pstmt.setString(2, newUser.getLastName ());
            pstmt.setInt(3, newUser.getAge ());
            pstmt.setString(4, newUser.getEmail ());
            pstmt.setString(5, newUser.getPassword ());
            int rowsInserted = pstmt.executeUpdate ();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys ();
                while(rs.next()){
                    newUser.setId(rs.getInt("account"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace ();
        }
    }
}
