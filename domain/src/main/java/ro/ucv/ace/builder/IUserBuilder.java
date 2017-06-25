package ro.ucv.ace.builder;

import ro.ucv.ace.dto.user.ESUserDto;
import ro.ucv.ace.model.User;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IUserBuilder {
    User build(ESUserDto userDto);
}
