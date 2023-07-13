package com.fazlerabbikhan.crudusers.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String outCode = "";
    private String outMessage = "";
    private long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String address;
}
