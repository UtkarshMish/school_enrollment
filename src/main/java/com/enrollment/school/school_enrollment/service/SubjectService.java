package com.enrollment.school.school_enrollment.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.enrollment.school.school_enrollment.entity.subject.Subject;
import com.enrollment.school.school_enrollment.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubjectService implements SubjectRepository {

    @Autowired
    private final SubjectRepository subjectRepository;

    public Optional<Subject> findById(Integer id) {
        return subjectRepository.findById(id);
    }


    @Override
    public List<Subject> findAll() {

        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> findAll(Sort sort) {

        return subjectRepository.findAll(sort);
    }

    @Override
    public List<Subject> findAllById(Iterable<Integer> ids) {

        return subjectRepository.findAllById(ids);
    }

    @Override
    public <S extends Subject> List<S> saveAll(Iterable<S> entities) {

        return subjectRepository.saveAll(entities);
    }

    @Override
    public void flush() {

        subjectRepository.flush();
    }

    @Override
    public <S extends Subject> S saveAndFlush(S entity) {

        return subjectRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Subject> List<S> saveAllAndFlush(Iterable<S> entities) {

        return subjectRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Subject> ids) {
        subjectRepository.deleteAllInBatch(ids);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        subjectRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        subjectRepository.deleteAllInBatch();
    }

    @Override
    public Subject getReferenceById(Integer id) {

        return subjectRepository.getReferenceById(id);
    }

    @Override
    public <S extends Subject> List<S> findAll(Example<S> example) {

        return subjectRepository.findAll(example);
    }

    @Override
    public <S extends Subject> List<S> findAll(Example<S> example, Sort sort) {

        return subjectRepository.findAll(example, sort);
    }

    @Override
    public Page<Subject> findAll(Pageable pageable) {

        return subjectRepository.findAll(pageable);
    }

    @Override
    public <S extends Subject> S save(S entity) {

        return subjectRepository.save(entity);
    }

    @Override
    public boolean existsById(Integer id) {

        return false;
    }

    @Override
    public long count() {

        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void delete(Subject entity) {
        subjectRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        subjectRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Subject> entities) {
        subjectRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }

    @Override
    public <S extends Subject> Optional<S> findOne(Example<S> example) {

        return subjectRepository.findOne(example);
    }

    @Override
    public <S extends Subject> Page<S> findAll(Example<S> example, Pageable pageable) {

        return subjectRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Subject> long count(Example<S> example) {

        return subjectRepository.count(example);
    }

    @Override
    public <S extends Subject> boolean exists(Example<S> example) {

        return subjectRepository.exists(example);
    }

    @Override
    public <S extends Subject, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {

        return subjectRepository.findBy(example, queryFunction);
    }

    /**
     * Returns a reference to the entity with the given identifier. Depending on how
     * the JPA persistence provider is
     * implemented this is very likely to always return an instance and throw an
     * {@link jakarta.persistence.EntityNotFoundException} on first access. Some of
     * them will reject invalid identifiers
     * immediately.
     *
     * @param id must not be {@literal null}.
     * @return a reference to the entity with the given identifier.
     * @see EntityManager#getReference(Class, Object) for details on when an
     *      exception is thrown.
     * @deprecated use {@link JpaRepository#getReferenceById(Integer ID)}
     */
    @Deprecated(forRemoval = false)
    @Override
    public Subject getOne(Integer id) {

        return subjectRepository.getOne(id);
    }

    /**
     * Returns a reference to the entity with the given identifier. Depending on how
     * the JPA persistence provider is
     * implemented this is very likely to always return an instance and throw an
     * {@link jakarta.persistence.EntityNotFoundException} on first access. Some of
     * them will reject invalid identifiers
     * immediately.
     *
     * @param id must not be {@literal null}.
     * @return a reference to the entity with the given identifier.
     * @see EntityManager#getReference(Class, Object) for details on when an
     *      exception is thrown.
     * @deprecated use {@link JpaRepository#getReferenceById(Integer ID)} instead.
     * @since 2.5
     */
    @Deprecated(since = "2.5")
    @Override
    public Subject getById(Integer id) {

        return subjectRepository.getById(id);
    }

}
