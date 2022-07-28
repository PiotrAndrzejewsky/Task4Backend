package com.example.Task4.user;

import com.example.Task4.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository mUserRepository;

    public UserService(UserRepository userRepository) { this.mUserRepository = userRepository; }

    public UserEntity getById(Long id) {
        return mUserRepository
                .findById(id)
                .orElseThrow(() -> new UserDoesNotExistException(id));
    }

    public boolean isUsernameTaken(String username) { return mUserRepository.findByUsername(username) != null; }

    public boolean signUpUsername(UserEntity userEntity) {
        if (!isUsernameTaken(userEntity.getUsername())) { addNewUser(userEntity); return true; }

        return false;
    }

    public void addNewUser(UserEntity userEntity) {
        String password = new BCryptPasswordEncoder().encode(userEntity.getPassword());
        userEntity.setPassword(password);
        mUserRepository.save(userEntity); }
}
