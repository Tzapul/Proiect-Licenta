package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IUserBuilder;
import ro.ucv.ace.dto.user.ESUserDto;
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.exception.InvalidEmailFormat;
import ro.ucv.ace.exception.UsernameAlreadyUsed;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.User;
import ro.ucv.ace.repository.IUserRepository;
import ro.ucv.ace.service.IUserService;
import ro.ucv.ace.validator.EmailValidator;
import ro.ucv.ace.visitor.UserVisitor;

/**
 * Created by tzapt on 6/25/2017.
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserVisitor userVisitor;

    @Autowired
    private IUserBuilder userBuilder;

    @Override
    public UserDto save(ESUserDto esUserDto) {
        String username = esUserDto.getUsername();

        if (!EmailValidator.validate(esUserDto.getEmail())) {
            throw new InvalidEmailFormat("The email is not in a valid format!");
        }

        while (userRepository.usernameExists(username)) {
            throw new UsernameAlreadyUsed("The username " + username + " already exists!");
        }

        User user = userRepository.save(userBuilder.build(esUserDto));

        user.accept(userVisitor);

        return userVisitor.getUserDto();
    }
}
