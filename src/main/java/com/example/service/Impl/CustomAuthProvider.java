package com.example.service.Impl;

import com.example.mapper.test.UserAuthMapper;
import com.example.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthProvider implements AuthenticationProvider {

    private final UserAuthMapper userAuthMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //아이디 비밀번호 비교
        String username = (String) authentication.getPrincipal(); //입력한 아이디 저장
        String password = (String) authentication.getCredentials(); // 비밀번호 저장

        CustomUserDetails user = userAuthMapper.getUserById(username);

        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("id,pw X"+username);
        }
        if(!user.isEnabled()) {
            throw new AuthenticationCredentialsNotFoundException(username);
        }
        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
