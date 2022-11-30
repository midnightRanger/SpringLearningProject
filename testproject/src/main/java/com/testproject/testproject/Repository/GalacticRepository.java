package com.testproject.testproject.Repository;

import com.testproject.testproject.Models.Galactic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GalacticRepository extends CrudRepository<Galactic, Long> {
    public List<Galactic> findByNameContains(String word);
    public Optional<Galactic> findByName(String name);
}
