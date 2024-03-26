package com.test.javacourse.MarketPlace.service;

import com.test.javacourse.MarketPlace.Mapper.UserMapper;
import com.test.javacourse.MarketPlace.dto.UserSaveRequestDto;
import com.test.javacourse.MarketPlace.entity.Users;
import com.test.javacourse.MarketPlace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public void save(UserSaveRequestDto userSaveRequestDto) {
        Users users = userMapper.userSaveRequestDtoToUsers(userSaveRequestDto);
        userRepository.save(users);
    }

    public Optional<Users> findUserById(Long userId) {
        return userRepository.findById(userId);

    }

}
