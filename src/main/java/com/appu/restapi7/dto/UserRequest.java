package com.appu.restapi7.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {


    @NotEmpty(message = "user name required")
    private String name;

    @Email(message = "invalid e-mail adress")
    @NotEmpty(message = "email filed required")
    private String email;

    private String gender;

    @Min(10)
    @Max(60)
    private int age;
}
