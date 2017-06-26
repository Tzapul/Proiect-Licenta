package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.IUserBuilder;
import ro.ucv.ace.dto.user.SUserDto;
import ro.ucv.ace.model.User;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class UserBuilder implements IUserBuilder {

    @Override
    public User build(SUserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName(),userDto.getPhoneNumber(),userDto.getEmail(),
                userDto.getUsername(), userDto.getPassword());
    }
}
