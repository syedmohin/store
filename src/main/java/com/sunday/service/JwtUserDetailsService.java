package com.sunday.service;

import com.sunday.model.User;
import com.sunday.model.UserDTO;
import com.sunday.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userDao;
    private final PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userDao.findByUsername(username);
        if (user.isPresent()) {
            var u = user.get();
            if (u.getUsername().equals(username)) {
                return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), new ArrayList<>());
            } else {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

    public boolean existsByUsername(String name) {
        return userDao.existsByUsername(name);
    }

}
