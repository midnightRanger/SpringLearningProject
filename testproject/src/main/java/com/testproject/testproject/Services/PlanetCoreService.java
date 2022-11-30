package com.testproject.testproject.Services;

import com.testproject.testproject.Models.Galactic;
import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Models.PlanetCore;
import com.testproject.testproject.Repository.PlanetCoreRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PlanetCoreService {
    public final PlanetCoreRepository planetCoreRepository;

    public PlanetCoreService(PlanetCoreRepository planetCoreRepository) {
        this.planetCoreRepository = planetCoreRepository;
    }


    public void delete(PlanetCore coreObj) {
        planetCoreRepository.delete(coreObj);
    }

    public Optional<PlanetCore> findById(Long id) {
        return planetCoreRepository.findById(id);
    }

    public PlanetCore save(PlanetCore coreObj) {
        return planetCoreRepository.save(coreObj);
    }

    public Iterable<PlanetCore> findAll () {
        return planetCoreRepository.findAll();
    }

    public Optional<PlanetCore> findByName(String name) {
        return planetCoreRepository.findByName(name);
    }
}
