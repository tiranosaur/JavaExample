package com.example.springconsole.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@Order(2)
public class AuthBasicConfig extends WebSecurityConfigurerAdapter {
    @Value("${SETTINGS_DATA_CONSUMER_USER}")
    private String basicAuthUser;

    @Value("${SETTINGS_DATA_CONSUMER_PASSWORD}")
    private String basicAuthPassword;

    @Autowired
    PasswordEncoder customPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestMatcher(new BasicRequestMatcher())
                .authorizeRequests()
                .antMatchers("/authenticate/**").permitAll()
                .antMatchers("/hello/**").authenticated()
                .anyRequest().denyAll()
                .and().httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // {noop} configures how the password is encrpyted; noop=no encyption
        auth.inMemoryAuthentication()
                .withUser(basicAuthUser)
                .password(customPasswordEncoder.encode(basicAuthPassword))
                .roles("USER");
    }

    private static class BasicRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            return auth != null && auth.startsWith("Basic ");
        }
    }
}