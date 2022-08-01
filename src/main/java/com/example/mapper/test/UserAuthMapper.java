package com.example.mapper.test;

import com.example.model.CustomUserDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthMapper {
    public CustomUserDetails getUserById(String username);

    public void signup(String username, String password);
}
