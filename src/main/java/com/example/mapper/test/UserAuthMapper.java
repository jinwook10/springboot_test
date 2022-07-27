package com.example.mapper.test;

import com.example.model.CustomUserDetails;

public interface UserAuthMapper {
    public CustomUserDetails getUserById(String username);
}
