package com.enrollment.school.school_enrollment.service;

import java.util.List;

import com.enrollment.school.school_enrollment.entity.subject.Assessments;
import com.enrollment.school.school_enrollment.repository.AssessmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssessmentService {
    @Autowired
    private final AssessmentRepository repository;

    public List<Assessments> findAll() {

        return repository.findAll();
    }

    public List<Assessments> findAll(Sort sort) {

        return repository.findAll(sort);
    }

    public List<Assessments> findAllById(Iterable<Integer> ids) {

        return repository.findAllById(ids);
    }

    public <S extends Assessments> List<S> saveAll(Iterable<S> entities) {

        return repository.saveAll(entities);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public <S extends Assessments> List<S> findAll(Example<S> example) {

        return repository.findAll(example);
    }

    public <S extends Assessments> List<S> findAll(Example<S> example, Sort sort) {

        return repository.findAll(example, sort);
    }

    public Page<Assessments> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    public <S extends Assessments> S save(S entity) {

        return repository.save(entity);
    }

    public boolean existsById(Integer id) {

        return repository.existsById(id);
    }

    public long count() {

        return repository.count();

    }

}
