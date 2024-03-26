package com.test.javacourse.MarketPlace.repository;

import com.test.javacourse.MarketPlace.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}
