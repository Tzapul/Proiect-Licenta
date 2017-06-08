package ro.ucv.ace.repository;

import ro.ucv.ace.model.User;

/**
 * Created by tzapt on 11/16/2016.
 */
public interface IUserRepository {
    User getByUsername(String username);

    boolean usernameExists(String username);
}
