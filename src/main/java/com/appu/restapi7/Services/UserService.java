package com.appu.restapi7.Services;

import com.appu.restapi7.Advice.UserNotFoundException;
import com.appu.restapi7.dto.UserRequest;
import com.appu.restapi7.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface UserService {


    User saveUser(UserRequest userRequest);
    User getUser(Long id) throws UserNotFoundException;

    List<User> fetchUsers();

    User updateUserById(Long id,UserRequest userRequest) throws UserNotFoundException;

    String deleteUser(Long id) throws UserNotFoundException;


}
