package com.testproject.testproject.Services;

import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Models.Scientist;
import com.testproject.testproject.Repository.ScientistRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScientistService {
    public final ScientistRepository scientistRepository;

    public ScientistService(ScientistRepository scientistRepository) {
        this.scientistRepository = scientistRepository;
    }

    public void delete(Scientist scientist) {
        scientistRepository.delete(scientist);
    }

    public Optional<Scientist> findById(Long id) {
        return scientistRepository.findById(id);
    }

    public Scientist save(Scientist scientist) {
        return scientistRepository.save(scientist);
    }

    public Iterable<Scientist> findAll () {
        return scientistRepository.findAll();
    }

    public Optional<Scientist> findBySurname(String surname) {
        return scientistRepository.findBySurname(surname);
    }
}
