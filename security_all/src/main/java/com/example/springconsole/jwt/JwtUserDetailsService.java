package com.example.springconsole.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Value("${SETTINGS_DATA_CONSUMER_USER}")
	private String basicAuthUser;

	@Value("${SETTINGS_DATA_CONSUMER_PASSWORD}")
	private String basicAuthPassword;

	@Autowired
	@Lazy
	@Qualifier("customPasswordEncoder")
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (basicAuthUser.equals(username)) {
			return new User(basicAuthUser, passwordEncoder.encode(basicAuthPassword), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}