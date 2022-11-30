package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Galactic;
import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Models.PlanetCore;
import com.testproject.testproject.Services.GalacticService;
import com.testproject.testproject.Services.PlanetCoreService;
import com.testproject.testproject.Services.PlanetService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/planet")
public class PlanetController {

    final PlanetCoreService planetCoreService;
    final PlanetService planetService;
    final GalacticService galacticService;

    public PlanetController(PlanetCoreService planetCoreService, PlanetService planetService, GalacticService galacticService) {
        this.planetCoreService = planetCoreService;
        this.planetService = planetService;
        this.galacticService = galacticService;
    }

    @GetMapping("/")
    public String planetView(@RequestParam(defaultValue = "") String keyword, Model model) {

        if (keyword == "") {
            Iterable<Planet> planetIterable = planetService.findAll();
            model.addAttribute("planetlist", planetIterable);
        }
        else {
            List<Planet> planetList = planetService.findByNameContains(keyword);
            model.addAttribute("planetlist", planetList);
        }

        return "/planet/planet";
    }

    @GetMapping("/add")
    public String planetAddView(Model model) {
        Iterable<PlanetCore> cores = planetCoreService.findAll();
        ArrayList<PlanetCore> coresList = new ArrayList<>();
        Iterable<Galactic> galacticIterable = galacticService.findAll();
        for(PlanetCore plCore: cores) {
            if(plCore.getCoreOwner() == null) {
                coresList.add(plCore);
            }
        }
        model.addAttribute("galacticlist", galacticIterable);
        model.addAttribute("planetCores", coresList);
        return "planet/planet-add";
    }

    @PostMapping("/add")
    public String AddPlanet(@Valid Planet planet, BindingResult bindingResult, @RequestParam String galacticName, @RequestParam(defaultValue = "") String planetCoreName) {
        Galactic galactic = galacticService.findByName(galacticName).orElseThrow();


        if(bindingResult.hasErrors())
            return "planet/planet-add";

        PlanetCore planetCore = planetCoreService.findByName(planetCoreName).orElse(null);
        planet.setPlanetCore(planetCore);

        planet.setGalactic(galactic);
        planetService.save(planet);
        return "redirect:/planet/";
    }

    @GetMapping("/planet-info/{id}")
    public String detailPlanet(
            @PathVariable Long id,
            Model model)
    {
       Planet planet_obj = planetService.findById(id).orElseThrow();
       model.addAttribute("one_planet", planet_obj);
        return "planet/planet-info";
    }

    @GetMapping("/planet-info/{id}/del")
    public String delPlanet(@PathVariable Long id) {
        Planet planet_obj = planetService.findById(id).orElseThrow();
        planetService.delete(planet_obj);
        return "redirect:/planet/";
    }


    @GetMapping("/planet-info/{id}/upd")
    public String updPlanet(@PathVariable Long id, Model model)
    {
        Planet planet = planetService.findById(id).orElseThrow();
        Iterable<PlanetCore> cores = planetCoreService.findAll();
        ArrayList<PlanetCore> coresList = new ArrayList<>();

        for(PlanetCore plCore: cores) {
            if(plCore.getCoreOwner() == null) {
                coresList.add(plCore);
            }
        }
        model.addAttribute("galacticlist", galacticService.findAll());
        model.addAttribute("planetCores", coresList);
        model.addAttribute("object", planet);
        return "planet/planet-upd";
    }

    @PostMapping("/planet-info/{id}/upd")
    public String updPlanetPost(@PathVariable Long id, Planet planet,
    @RequestParam String galacticName, @RequestParam(defaultValue = "") String planetCoreName)
    {
        Planet newPlanet = planetService.findById(id).orElseThrow();
        newPlanet.setName(planet.getName());
        newPlanet.setOrbitalSpeed(planet.getOrbitalSpeed());
        newPlanet.setRotation(planet.getRotation());
        newPlanet.setTempinc(planet.getTempinc());
        newPlanet.setTempink(planet.getTempink());

        Galactic galactic = galacticService.findByName(galacticName).orElseThrow();
        PlanetCore planetCore = planetCoreService.findByName(planetCoreName).orElse(null);

        newPlanet.setGalactic(galactic);
        newPlanet.setPlanetCore(planetCore);

        planetService.save(newPlanet);
        return "redirect:/planet/";
    }
}
