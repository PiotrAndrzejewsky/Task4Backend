package com.example.Task4.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/user/management/{username}")
    public List<UserEntity> getAllUsers(@PathVariable String username) {
        return mUserService.getAllUsers();
    }

    @PreAuthorize("#username == authentication.getPrincipal()")
    @PatchMapping("/user/{username}")
    public boolean updateLoginTime(@PathVariable String username) {
        return mUserService.updateLoginTime(username);
    }

    @PatchMapping("/user/block/{username}")
    public void blockUser(@PathVariable String username) {
        mUserService.changeActiveStatus(false,username);
    }

    @PatchMapping("/user/unblock/{username}")
    public void unBlockUser(@PathVariable String username) {
        mUserService.changeActiveStatus(true,username);
    }

    @DeleteMapping("/user/delete/{username}")
    public void deleteUser(@PathVariable String username) {
        mUserService.deleteUser(username);
    }

    @PreAuthorize("#username == authentication.getPrincipal()")
    @GetMapping("/user/status/{username}")
    public boolean getStatus(@PathVariable String username) {
        return mUserService.getStatus(username);
    }
}
