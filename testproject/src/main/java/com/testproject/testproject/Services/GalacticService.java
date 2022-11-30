package com.testproject.testproject.Services;

import com.testproject.testproject.Models.Galactic;
import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Models.PlanetCore;
import com.testproject.testproject.Repository.GalacticRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GalacticService {

    public final GalacticRepository galacticRepository;

    public GalacticService(GalacticRepository galacticRepository) {
        this.galacticRepository = galacticRepository;
    }

    public void delete(Galactic galacticObj) {
        galacticRepository.delete(galacticObj);
    }

    public Optional<Galactic> findById(Long id) {
        return galacticRepository.findById(id);
    }

    public Galactic save(Galactic galacticObj) {
        return galacticRepository.save(galacticObj);
    }

    public Iterable<Galactic> findAll () {
        return galacticRepository.findAll();
    }

    public List<Galactic> findByNameContains(String word) {
        return galacticRepository.findByNameContains(word);
    }

    public Optional<Galactic> findByName(String name) {
        return galacticRepository.findByName(name);
    }


}
