package com.example.Task4.security;

import com.example.Task4.user.UserEntity;
import com.example.Task4.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = this.userRepository.findByUsername(s);
        if (userEntity.isPresent()) {
            UserPrincipal userPrincipal = new UserPrincipal(userEntity.get());
            return userPrincipal;
        }
        UserPrincipal userPrincipal = new UserPrincipal();
        return userPrincipal;
    }
}