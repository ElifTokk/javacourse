package com.test.javacourse.MarketPlace.Mapper;

import com.test.javacourse.MarketPlace.dto.UserSaveRequestDto;
import com.test.javacourse.MarketPlace.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users userSaveRequestDtoToUsers(UserSaveRequestDto userSaveRequestDto);
}
