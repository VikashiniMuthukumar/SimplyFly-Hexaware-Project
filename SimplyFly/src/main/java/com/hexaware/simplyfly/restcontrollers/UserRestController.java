package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.UserDTO;
import com.hexaware.simplyfly.entities.User;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody UserDTO dto) {
        User user = userService.registerUser(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserDTO dto) throws UserNotFoundException {
        User user = userService.updateUser(userId, dto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
