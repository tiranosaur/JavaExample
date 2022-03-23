package com.example.springconsole.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/hello").authenticated()
                .antMatchers("/**").permitAll()
                .and().formLogin();
        http.logout();
//         Note:
//         Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
//         Note that the CSRf token is disabled for all requests (change it as you wish...)
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

    //This section has been replaced by the configurations in application.properties file
    @Override
    public void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("fff"))
                .authorities("ROLE_USER");
    }
}
