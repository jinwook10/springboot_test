package com.example.config;

import com.example.handler.LoginFailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@EnableWebSecurity  //SecurityConfig로 시큐리티 제어
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final LoginFailHandler customFailHandler;
    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()// spring security 필터 타지 않게 설정
                .antMatchers("/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //지우면 기존 시큐리티 비활성화
        //super.configure(http);

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/login", "/signup").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/login/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                //.defaultSuccessUrl("/")
                .failureHandler(customFailHandler)
                .and()
                .logout()
                .logoutUrl("/logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}12345678").roles("USER");
    }

}

