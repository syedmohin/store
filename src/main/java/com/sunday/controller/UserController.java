package com.sunday.controller;

import com.sunday.model.User;
import com.sunday.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin("*")
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllUser() {
        var itre = userRepository.findAll();
        List<User> list = new ArrayList<>();
        itre.forEach(list::add);
        var sl = list.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
        return ok(sl);
    }

    @DeleteMapping("delete/{username}")
    public void delete(@PathVariable("username") String username) {
        userRepository.deleteByUsername(username);
    }
}
