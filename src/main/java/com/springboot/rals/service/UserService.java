package com.springboot.rals.service;

import com.springboot.rals.entity.User;
import com.springboot.rals.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

}
