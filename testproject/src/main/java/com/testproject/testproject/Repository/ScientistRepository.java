package com.testproject.testproject.Repository;

import com.testproject.testproject.Models.Galactic;
import com.testproject.testproject.Models.Scientist;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ScientistRepository extends CrudRepository<Scientist, Long> {

    public Optional<Scientist> findBySurname(String surname);
}
