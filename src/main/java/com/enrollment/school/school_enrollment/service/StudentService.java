package com.enrollment.school.school_enrollment.service;

import java.util.List;

import com.enrollment.school.school_enrollment.entity.Student;
import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private final StudentRepository repository;

    public List<Student> findAll() {

        return repository.findAll();
    }

    public List<Student> findAll(Sort sort) {

        return repository.findAll(sort);
    }

    public List<Student> findAllById(Iterable<Integer> ids) {

        return repository.findAllById(ids);
    }

    public <S extends Student> List<S> saveAll(Iterable<S> entities) {

        return repository.saveAll(entities);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public <S extends Student> List<S> findAll(Example<S> example) {

        return repository.findAll(example);
    }

    public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {

        return repository.findAll(example, sort);
    }

    public Page<Student> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    public Student save(Student entity) {

        return repository.save(entity);
    }

    public Student save(Users entity, Number fees) {

        return repository.save(new Student(entity, fees));
    }

    public boolean existsById(Integer id) {

        return repository.existsById(id);
    }

    public long count() {

        return repository.count();

    }
}
