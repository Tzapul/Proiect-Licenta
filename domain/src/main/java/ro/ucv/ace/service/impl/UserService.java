package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IUserBuilder;
import ro.ucv.ace.dto.user.EUserDto;
import ro.ucv.ace.dto.user.SUserDto;
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.exception.InvalidEmailFormat;
import ro.ucv.ace.exception.UsernameAlreadyUsed;
import ro.ucv.ace.exception.WrongPhoneNumberFormat;
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
    public UserDto save(SUserDto esUserDto) {
        String username = esUserDto.getUsername();

        if (!EmailValidator.validate(esUserDto.getEmail())) {
            throw new InvalidEmailFormat("The email is not in a valid format!");
        }

        if (userRepository.usernameExists(username)) {
            throw new UsernameAlreadyUsed("The username " + username + " already exists!");
        }

        String regexStr = "^07[2-8][0-9]{7}$";
        if(!esUserDto.getPhoneNumber().matches(regexStr)) {
            throw new WrongPhoneNumberFormat("Wrong phone number format!");
        }

        User user = userRepository.save(userBuilder.build(esUserDto));

        user.accept(userVisitor);

        return userVisitor.getUserDto();
    }

    @Override
    public UserDto edit(int id, EUserDto userDto) {
        User user = userRepository.findOne(id);
        user.update(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPhoneNumber(), userDto.getPassword());

        user.accept(userVisitor);

        return userVisitor.getUserDto();
    }
}
