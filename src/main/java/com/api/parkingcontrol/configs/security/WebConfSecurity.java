package com.api.parkingcontrol.configs.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfSecurity{

    @Autowired
    UserDetailServiceImpl userDetailService;
  /*  @Bean
     protected SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                    .and()
                        .authorizeRequests()
                        .anyRequest().authenticated()
                    .and()
                        .csrf().disable();

       return http.build();
    }*/
    @Bean
    protected AuthenticationManagerBuilder configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
        return auth;

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
