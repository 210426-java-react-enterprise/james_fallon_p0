package com.bank.daos;

import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {
    public void save(User newUser){
        try(Connection conn = ConnectionFactory.getInstance ().getConnection ()){
            String sqlInsertUser = "insert into bank.users(first_name, last_name, age, email, password) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement (sqlInsertUser, new String[]{"user_id"});
            pstmt.setString(1, newUser.getFirstName ());
            pstmt.setString(2, newUser.getLastName ());
            pstmt.setInt(3, newUser.getAge ());
            pstmt.setString(4, newUser.getEmail ());
            pstmt.setString(5, newUser.getPassword ());
            int rowsInserted = pstmt.executeUpdate ();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys ();
                while(rs.next()){
                    newUser.setId(rs.getInt("user_id"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace ();
        }

    }




}
