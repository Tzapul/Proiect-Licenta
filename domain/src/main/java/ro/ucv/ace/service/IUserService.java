package ro.ucv.ace.service;

import ro.ucv.ace.dto.user.EUserDto;
import ro.ucv.ace.dto.user.SUserDto;
import ro.ucv.ace.dto.user.UserDto;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IUserService {
    UserDto save(SUserDto esUserDto);

    UserDto edit(int id, EUserDto userDto);
}
