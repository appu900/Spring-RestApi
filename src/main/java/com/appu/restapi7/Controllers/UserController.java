package com.appu.restapi7.Controllers;


import com.appu.restapi7.Advice.UserNotFoundException;
import com.appu.restapi7.Services.UserService;
import com.appu.restapi7.dto.UserRequest;
import com.appu.restapi7.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("")
    public ResponseEntity<User> saveUserToDatabase(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllusers() {
        return ResponseEntity.ok(userService.fetchUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
   public String deleteUserById(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return "user deleted sucessfully";
   }


   @PutMapping("{id}")
   public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody UserRequest userRequest) throws UserNotFoundException {
        return ResponseEntity.ok(userService.updateUserById(id,userRequest));
   }


}
