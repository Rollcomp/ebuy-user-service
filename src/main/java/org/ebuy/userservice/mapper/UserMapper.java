package org.ebuy.userservice.mapper;

import org.ebuy.userservice.dto.UserDto;
import org.ebuy.userservice.entity.User;
import org.ebuy.userservice.model.KafkaMessage;
import org.ebuy.userservice.model.UserRequest;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Ozgur Ustun on May, 2020
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    List<UserDto> userListToUserDtoList(List<User> userList);

    User userToUser(User user);

    User userDtoToUser(UserDto userDto);

    UserRequest KafkaMsgToUserReq(KafkaMessage kafkaMessage);
}
