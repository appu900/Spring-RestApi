package com.appu.restapi7;


import com.appu.restapi7.Services.UserService;
import com.appu.restapi7.Services.UserServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceFactory {

    @Bean
    UserService userservice(){
        return new UserServiceImp();
    }
}
