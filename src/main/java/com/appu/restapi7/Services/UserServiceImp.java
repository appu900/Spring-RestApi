package com.appu.restapi7.Services;

import com.appu.restapi7.Advice.UserNotFoundException;
import com.appu.restapi7.Repository.UserRepository;
import com.appu.restapi7.dto.UserRequest;
import com.appu.restapi7.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImp  implements UserService{


    @Autowired
    private UserRepository userRepo;


    @Override
    public User saveUser(UserRequest userRequest) {
        User user = User.build(0L,userRequest.getName(),userRequest.getEmail(),userRequest.getGender(),userRequest.getAge());
        return userRepo.save(user);
    }

    @Override
    public User getUser(Long id) throws UserNotFoundException {
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));
    }


    @Override
    public List<User> fetchUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUserById(Long id, UserRequest userRequest) throws UserNotFoundException {
        User baseUserData = userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));
        baseUserData.setName(userRequest.getName());
        baseUserData.setAge(userRequest.getAge());
        baseUserData.setEmail(userRequest.getEmail());
        baseUserData.setGender(userRequest.getGender());
        return userRepo.save(baseUserData);

    }

    @Override
    public String deleteUser(Long id) throws UserNotFoundException {
        User requestedDeletedUser = userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("user not exists"));
        if(requestedDeletedUser != null){
            userRepo.deleteById(id);
        }
        return "user deleted sucessfully";
    }
}
