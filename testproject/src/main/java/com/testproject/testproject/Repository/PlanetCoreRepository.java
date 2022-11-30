package com.testproject.testproject.Repository;

import com.testproject.testproject.Models.Galactic;
import com.testproject.testproject.Models.PlanetCore;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlanetCoreRepository extends CrudRepository<PlanetCore, Long> {

    public Optional<PlanetCore> findByName(String name);
}
