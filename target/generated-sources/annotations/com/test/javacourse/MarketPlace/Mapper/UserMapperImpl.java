package com.test.javacourse.MarketPlace.Mapper;

import com.test.javacourse.MarketPlace.dto.UserSaveRequestDto;
import com.test.javacourse.MarketPlace.entity.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T23:45:04+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Users userSaveRequestDtoToUsers(UserSaveRequestDto userSaveRequestDto) {
        if ( userSaveRequestDto == null ) {
            return null;
        }

        Users users = new Users();

        return users;
    }
}
