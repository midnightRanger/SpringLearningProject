package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Repository.PlanetRepository;
import com.testproject.testproject.Services.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/planet")
public class PlanetController {

    final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String planets(@RequestParam(defaultValue = "") String keyword, Model model) {

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
    public String AddView() {
        return "planet/planet-add";
    }

    @PostMapping("/add")
    public String AddPlanet(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "orbitalspeed") double orbitalSpeed,
            @RequestParam(name = "rotation") double rotation,
            @RequestParam(name = "tempinc") double tempInC,
            @RequestParam(name = "tempink") double tempInK
    ) {
        Planet newPlanet = new Planet(name, orbitalSpeed, rotation, tempInC, tempInK);
        planetService.save(newPlanet);
        return "redirect:/planet/";
    }

    @GetMapping("/planet-info/{id}")
    public String detailPlanet(
            @PathVariable Long id,
            Model model
    )
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
        model.addAttribute("object", planetService.findById(id).orElseThrow());
        return "planet/planet-upd";
    }

    @PostMapping("/planet-info/{id}/upd" )
    public String updPlanetPost(@PathVariable Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "orbitalSpeed") double orbitalSpeed,
            @RequestParam(name = "rotation") double rotation,
            @RequestParam(name = "tempinc") double tempinc,
            @RequestParam(name = "tempink") double tempink
    ) {
        Planet newPlanet = planetService.findById(id).orElseThrow();
        newPlanet.setName(name);
        newPlanet.setOrbitalSpeed(orbitalSpeed);
        newPlanet.setRotation(rotation);
        newPlanet.setTempinc(tempinc);
        newPlanet.setTempink(tempink);

        planetService.save(newPlanet);
        return "redirect:/planet/";
    }
}
