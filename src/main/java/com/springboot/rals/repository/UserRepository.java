package com.springboot.rals.repository;

import com.springboot.rals.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // tim user trong database bang email
    User findByEmail(String email);
}
