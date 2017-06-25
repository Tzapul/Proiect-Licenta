package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.model.User;

/**
 * Created by tzapt on 11/16/2016.
 */
@Component
public class UserVisitor {

    private UserDto userDto;

    public void visit(User user) {
        userDto = new UserDto(user.getId(), user.getUsername(), user.getPersonDetails().getFirstName(), user.getPersonDetails().getLastName(),
                user.getPersonDetails().getPhoneNumber(), user.getAccount().getEmail(), user.getPassword());
    }

    public UserDto getUserDto() {
        return userDto;
    }
}
