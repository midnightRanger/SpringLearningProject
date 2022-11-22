package com.testproject.testproject.Repository;

import com.testproject.testproject.Models.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetRepository extends CrudRepository<Planet, Long> {

    public List<Planet> findByNameContains(String name);

    public List<Planet> findByOrbitalSpeed(String orbitalSpeed);

}
