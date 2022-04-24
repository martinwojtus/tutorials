package com.frontbackend.springboot.users;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    List<UserEntity> findByUsernameStartsWith(String searchFilter);

    List<UserEntity> findAllByTopIsTrue();
}
