package com.enrollment.school.school_enrollment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.enrollment.school.school_enrollment.entity.Attendance;
import com.enrollment.school.school_enrollment.repository.AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    @Autowired
    private final AttendanceRepository repository;

    public List<Attendance> findAll() {

        return repository.findAll();
    }

    public List<Attendance> findAll(Sort sort) {

        return repository.findAll(sort);
    }

    public List<Attendance> findByStudentId(Integer id) {

        return repository.findByStudentId(id);
    }

    public List<Attendance> findAllByDate(LocalDate date) {

        return repository.findAllByDate(date);
    }
    public List<Attendance> findAllById(Iterable<Integer> ids) {

        return repository.findAllById(ids);
    }

    public <S extends Attendance> List<S> saveAll(Iterable<S> entities) {

        return repository.saveAll(entities);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public <S extends Attendance> List<S> findAll(Example<S> example) {

        return repository.findAll(example);
    }

    public <S extends Attendance> List<S> findAll(Example<S> example, Sort sort) {

        return repository.findAll(example, sort);
    }

    public <S extends Attendance> S save(S entity) {

        return repository.save(entity);
    }

    public boolean existsById(Integer id) {

        return repository.existsById(id);
    }

    public long count() {

        return repository.count();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void delete(Attendance entity) {
        repository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        repository.deleteAllById(ids);
    }

    public void deleteAll(Iterable<? extends Attendance> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public <S extends Attendance> Optional<S> findOne(Example<S> example) {

        return repository.findOne(example);
    }

}
