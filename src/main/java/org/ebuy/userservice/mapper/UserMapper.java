package org.ebuy.userservice.mapper;

import org.ebuy.userservice.dto.UserDto;
import org.ebuy.userservice.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Ozgur Ustun on May, 2020
 */
@Mapper
public interface UserMapper {

    UserDto userToUserDto(User user);

    List<UserDto> userListToUserDtoList(List<User> userList);
}
