package com.springboot.rals.service.impl;

import com.springboot.rals.entity.Role;
import com.springboot.rals.entity.User;
import com.springboot.rals.repository.UserRepository;
import com.springboot.rals.service.UserService;
import com.springboot.rals.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // dung dto de lay thong tin cua user the browser sau do save
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                registrationDto.getPassword(), Arrays.asList(new Role("ROLES_USER")));
        return userRepository.save(user);
    }
}
