package com.example.Task4.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    Optional<UserEntity> findByUsername(String username);

    @Modifying
    @Query(value = "UPDATE users SET active = :active WHERE username = :username", nativeQuery = true)
    void changeActiveStatus(boolean active, String username);
}
