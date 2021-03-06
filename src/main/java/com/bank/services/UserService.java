package com.bank.services;

import com.bank.daos.UserDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.exceptions.ResourcePersistenceException;
import com.bank.pojo.User;
import com.bank.util.Profile;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void register(User newUser) throws InvalidRequestException, ResourcePersistenceException {


        if(!isUserValid (newUser)){
           throw new InvalidRequestException ("Invalid user data");
       }
       if(!isUserOfAge (newUser)){
           throw new InvalidRequestException ("User is not old enough");
       }

       if(!userDAO.isEmailAvailable (newUser.getEmail ())){
           throw new ResourcePersistenceException ("This email is already associated with a registered User");
       }



       userDAO.save(newUser);
    }

    public boolean isUserValid(User user){
        if(user == null) return false;
        if(user.getFirstName() == null || user.getFirstName().trim().isEmpty()) return false;
        if(user.getLastName() == null || user.getLastName().trim().isEmpty()) return false;
        if(user.getEmail () == null || user.getEmail ().trim().isEmpty()||!user.getEmail ().contains ("@")) return false;
        if(user.getAge () <=0) return false;
        return true;
    }

    public boolean isUserOfAge(User user){
        if(user.getAge() < 18) return false;
        return true;
    }
}
