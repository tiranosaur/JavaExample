package org.test.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.test.spring.model.User;
import org.test.spring.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public JwtUserDetails loadUserByUsername(final String username) {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
        List<SimpleGrantedAuthority> roles = user.getRoleList().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new JwtUserDetails(user.getId(), username, user.getPassword(), roles);
    }
}