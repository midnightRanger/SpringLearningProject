package com.testproject.testproject.Services;

import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanetService {
    public final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void delete(Planet planetObj) {
        planetRepository.delete(planetObj);
    }

    public Optional<Planet> findById(Long id) {
        return planetRepository.findById(id);
    }

    public Planet save(Planet planetObj) {
        return planetRepository.save(planetObj);
    }

    public Iterable<Planet> findAll () {
        return planetRepository.findAll();
    }

    public List<Planet> findByNameContains (String keyword) {
        return planetRepository.findByNameContains(keyword);
    }
}
