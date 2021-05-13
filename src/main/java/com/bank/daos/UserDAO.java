package com.bank.daos;

import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The User Data Access Object Class uses Java Database Connectivity to perform DQL and DML commands on the Bank Database's User Table.
 */

public class UserDAO {

    /**
     * Inserts a row into User Table after a user has been registered.
     */
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

    /**
     * Returns a User object that holds the provide values for email and password fields.
     * @param email
     * @param password
     * @return
     */
    public User findUserByEmailAndPassword(String email, String password){
        User user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from bank.users where email = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAge(rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;


    }

    /**
     * Returns a boolean to determine if the provided value for the email field is present in the Database.
     * @param email
     * @return
     */
    public boolean isEmailAvailable(String email){
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "select * from bank.users where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString (1, email);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next ()){
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace ();
        }
        return true;

    }





}
