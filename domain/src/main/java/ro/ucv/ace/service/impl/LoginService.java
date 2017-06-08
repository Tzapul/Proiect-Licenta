package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.dto.user.UserLoginDto;
import ro.ucv.ace.exception.InvalidPasswordException;
import ro.ucv.ace.model.User;
import ro.ucv.ace.repository.IUserRepository;
import ro.ucv.ace.service.ILoginService;
import ro.ucv.ace.visitor.UserVisitor;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by Geo on 15.11.2016.
 */
@Service("loginService")
@Transactional(rollbackFor = Exception.class)
public class LoginService implements ILoginService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserVisitor userVisitor;

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public UserDto authenticateUser(UserLoginDto userLogin) {
        User user = userRepository.getByUsername(userLogin.getUsername().toLowerCase());

        if (!user.passwordMatches(userLogin.getPassword())) {
            throw new InvalidPasswordException("Invalid user password!");
        }

        user.accept(userVisitor);

        UserDto userDto = userVisitor.getUserDto();

        String token = userLogin.getUsername() + ":" + userLogin.getPassword();
        byte[] bytes = Base64.getEncoder().encode(token.getBytes());
        userDto.setAuthorization("Basic " + new String(bytes, Charset.forName("UTF-8")));

        return userDto;
    }
}