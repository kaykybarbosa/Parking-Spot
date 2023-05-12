package com.api.parkingcontrol.configs.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class WebConfSecurity{

    @Autowired
    UserDetailServiceImpl userDetailService;
     protected SecurityFilterChain configureHttp(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                    .and()
                        .authorizeRequests()
                        .dispatcherTypeMatchers(HttpMethod.GET).permitAll()
                        .dispatcherTypeMatchers(HttpMethod.POST).permitAll()
                        .dispatcherTypeMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                        .anyRequest().authenticated()
                    .and()
                        .csrf().disable();

       return http.build();
    }
    protected AuthenticationManagerBuilder configureBuilder  (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
        return auth;

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
