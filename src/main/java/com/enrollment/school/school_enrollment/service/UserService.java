package com.enrollment.school.school_enrollment.service;

import java.util.List;

import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(Users user) {
        userRepository.save(user);
        return user;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public void remove(Users entity) {
        userRepository.delete(entity);
    }

    public void removeAll(List<Users> entities) {
        userRepository.deleteAll(entities);
    }

}
