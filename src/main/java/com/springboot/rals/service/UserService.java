package com.springboot.rals.service;

import com.springboot.rals.entity.User;
import com.springboot.rals.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
