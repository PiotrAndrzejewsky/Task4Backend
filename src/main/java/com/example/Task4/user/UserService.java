package com.example.Task4.user;

import com.example.Task4.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository mUserRepository;

    public UserService(UserRepository userRepository) { this.mUserRepository = userRepository; }

    public boolean isUsernameTaken(String username) {
        Optional<UserEntity> userEntity = mUserRepository.findByUsername(username);
        return userEntity.isPresent();
    }

    public boolean signUpUsername(UserEntity userEntity) {
        System.out.println(userEntity.getUsername());
        if (!isUsernameTaken(userEntity.getUsername())) { addNewUser(userEntity); return true; }

        return false;
    }

    public void addNewUser(UserEntity userEntity) {
        String password = new BCryptPasswordEncoder().encode(userEntity.getPassword());
        userEntity.setPassword(password);
        mUserRepository.save(userEntity); }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<UserEntity>();
        mUserRepository.findAll().forEach(users::add);
        return users;
    }

    @Transactional
    public boolean updateLoginTime(String username) {
        Optional<UserEntity> userEntity = mUserRepository.findByUsername(username);
        if (userEntity.isPresent()) {
            if (userEntity.get().getUsername() != "") {
                userEntity.get().setLastLoginTime(LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void changeActiveStatus(boolean active, String username) {
        mUserRepository.changeActiveStatus(active, username);
    }

    public void deleteUser(String username) {
        Optional<UserEntity> userEntity = mUserRepository.findByUsername(username);
        userEntity.ifPresent(entity -> mUserRepository.delete(entity));
    }

    public boolean getStatus(String username) {
        Optional<UserEntity> userEntity = mUserRepository.findByUsername(username);
        return userEntity.map(UserEntity::isActive).orElse(false);
    }
}
