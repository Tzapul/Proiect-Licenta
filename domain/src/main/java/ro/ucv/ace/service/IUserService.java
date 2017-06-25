package ro.ucv.ace.service;

import ro.ucv.ace.dto.user.ESUserDto;
import ro.ucv.ace.dto.user.UserDto;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IUserService {
    UserDto save(ESUserDto esUserDto);
}
