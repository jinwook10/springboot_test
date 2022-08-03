package com.example.mapper.test;

import com.example.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthMapper {
    public UserDetail getUserById(String username);

    public void signup(String username, String password);
}
