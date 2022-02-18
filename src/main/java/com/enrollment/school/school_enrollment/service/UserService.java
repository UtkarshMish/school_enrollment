package com.enrollment.school.school_enrollment.service;

import java.util.List;
import java.util.Optional;

import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(Users user) {
        userRepository.save(user);
        return user;
    }

    public Users findOneById(Integer id) {
        Optional<Users> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }
    public void removeOneById(Integer id) {
        userRepository.deleteById(id);
    }
    public Users findOne(String name) {
        return userRepository.findByName(name);
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

    public void removeAll() {
        userRepository.deleteAll();
    }

}
