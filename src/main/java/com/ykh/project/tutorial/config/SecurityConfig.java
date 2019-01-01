package com.ykh.project.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable()
                 .sessionManagement().disable()
                 .authorizeRequests()
                 .anyRequest().authenticated()
                 .antMatchers("/security/**").permitAll()
                 .and().formLogin().and().httpBasic();
    }


    @Bean
    public UserDetailsService  userDetailsService(){
        InMemoryUserDetailsManager inMemoryUserDetailsManager =  new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("admin").build());
        return inMemoryUserDetailsManager;
    }


}
