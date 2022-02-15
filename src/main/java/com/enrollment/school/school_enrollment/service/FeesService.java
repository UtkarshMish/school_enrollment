package com.enrollment.school.school_enrollment.service;

import java.util.List;

import com.enrollment.school.school_enrollment.entity.Fees;
import com.enrollment.school.school_enrollment.repository.FeesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeesService {
    @Autowired
    private final FeesRepository repository;

    public List<Fees> findAll() {

        return repository.findAll();
    }

    public List<Fees> findAll(Sort sort) {

        return repository.findAll(sort);
    }

    public List<Fees> findAllById(Iterable<Integer> ids) {

        return repository.findAllById(ids);
    }

    public <S extends Fees> List<S> saveAll(Iterable<S> entities) {

        return repository.saveAll(entities);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public <S extends Fees> List<S> findAll(Example<S> example) {

        return repository.findAll(example);
    }

    public <S extends Fees> List<S> findAll(Example<S> example, Sort sort) {

        return repository.findAll(example, sort);
    }

    public Page<Fees> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    public <S extends Fees> S save(S entity) {

        return repository.save(entity);
    }

    public boolean existsById(Integer id) {

        return repository.existsById(id);
    }

    public long count() {

        return repository.count();

    }
}
