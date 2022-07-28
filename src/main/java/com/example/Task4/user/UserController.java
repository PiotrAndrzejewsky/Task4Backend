package com.example.Task4.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService mUserService;

    @PostMapping("/signUp")
    public boolean signUpUsername(@RequestBody UserEntity userEntity) {
        return mUserService.signUpUsername(userEntity);
    }

    @PreAuthorize("#username == authentication.getPrincipal()")
    @GetMapping("user/management/{username}")
    public String test(@PathVariable String username) {
        return username;
    }
}
