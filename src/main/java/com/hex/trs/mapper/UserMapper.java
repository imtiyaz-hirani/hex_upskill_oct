package com.hex.trs.mapper;

import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.enums.Role;
import com.hex.trs.model.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Component
public class UserMapper {

    public User toEntity(CustomerReqDto dto){
        String authCode = dto.autoCode(); // Sample :- aGFycnk6aGFycnkxMjM=
        /* 1. Decode auth code */
        byte[] code =  Base64.getDecoder().decode(authCode);
        // 2. Convert the byte array into a String using UTF-8 encoding
        String usernamePass = new String(code, StandardCharsets.UTF_8);
        //System.out.println(usernamePass); //harry:harry123
        String username = usernamePass.split(":")[0];
        String password = usernamePass.split(":")[1];
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(Role.CUSTOMER);
        return user;
    }
}
