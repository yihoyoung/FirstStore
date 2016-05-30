package org.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by hoyounglee on 2016. 5. 19..
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
                .antMatchers("/loginForm", "/home", "/login*", "/", "/registForm", "/regist").permitAll()
                .anyRequest().authenticated()
                .and()
          .formLogin()
                .loginPage("/loginForm")
                .failureUrl("/loginForm")
                .defaultSuccessUrl("/menu", true)
                .permitAll()
                .and()
           .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("email").password("password").roles("USER");
    }
}
