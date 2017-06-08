package ro.ucv.ace.service;

import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.dto.user.UserLoginDto;
import ro.ucv.ace.model.User;

/**
 * Created by Geo on 15.11.2016.
 */
public interface ILoginService {

    User getByUsername(String username);

    UserDto authenticateUser(UserLoginDto userLogin);
}
