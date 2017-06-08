package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.exception.EntityNotFoundException;
import ro.ucv.ace.model.User;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.IUserRepository;

/**
 * Created by tzapt on 11/16/2016.
 */
@Repository("userRepository")
public class UserRepository implements IUserRepository {

    @Autowired
    private IJpaRepository<User, Integer> innerUserRepository;

    @Override
    public User getByUsername(String username) {
        return innerUserRepository.findOneWhere(user -> user.getAccount().getUsername().equals(username));
    }

    @Override
    public boolean usernameExists(String username) {
        try {
            User usr = innerUserRepository.findOneWhere(user -> user.getAccount().getUsername().equals(username));
        } catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }

}
