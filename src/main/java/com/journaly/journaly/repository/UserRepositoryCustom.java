package com.journaly.journaly.repository;

import com.journaly.journaly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryCustom {
    List<User> findByUsername(String username);

}