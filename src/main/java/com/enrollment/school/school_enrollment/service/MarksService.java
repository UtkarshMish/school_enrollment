package com.enrollment.school.school_enrollment.service;

import java.util.List;

import com.enrollment.school.school_enrollment.entity.Marks;
import com.enrollment.school.school_enrollment.repository.MarkSheetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarksService {
    @Autowired
    private final MarkSheetRepository repository;

    public List<Marks> findAll() {

        return repository.findAll();
    }

    public List<Marks> findAll(Sort sort) {

        return repository.findAll(sort);
    }

    public List<Marks> findAllById(Iterable<Integer> ids) {

        return repository.findAllById(ids);
    }

    public <S extends Marks> List<S> saveAll(Iterable<S> entities) {

        return repository.saveAll(entities);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public <S extends Marks> List<S> findAll(Example<S> example) {

        return repository.findAll(example);
    }

    public <S extends Marks> List<S> findAll(Example<S> example, Sort sort) {

        return repository.findAll(example, sort);
    }

    public Page<Marks> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    public <S extends Marks> S save(S entity) {

        return repository.save(entity);
    }

    public boolean existsById(Integer id) {

        return repository.existsById(id);
    }

    public long count() {

        return repository.count();

    }
}
