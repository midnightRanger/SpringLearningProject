package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Galactic;
import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Services.GalacticService;
import com.testproject.testproject.Services.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/galactic")
public class GalacticController {
    final GalacticService galacticService;

    public GalacticController(GalacticService galacticService) {
        this.galacticService = galacticService;
    }

    @GetMapping("/")
    public String galactics(@RequestParam(defaultValue = "") String keyword, Model model) {

        if (keyword == "") {
            Iterable<Galactic> galacticIterable = galacticService.findAll();
            model.addAttribute("galacticlist", galacticIterable);
        }

        else {
            List<Galactic> galacticList = galacticService.findByNameContains(keyword);
            model.addAttribute("galacticlist", galacticList);
        }
        return "/galactic/galactic";
    }

    @GetMapping("/add")
    public String AddView() {
        return "galactic/galactic-add";
    }

    @PostMapping("/add")
    public String AddGalactic(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "diametr") double diametr,
            @RequestParam(name = "weight") double weight,
            @RequestParam(name = "rotationSpeed") double rotationSpeed,
            @RequestParam(name = "lumen") double lumen
    ) {
        Galactic newGalactic = new Galactic(name, diametr, weight, rotationSpeed, lumen);
        galacticService.save(newGalactic);
        return "redirect:/galactic/";
    }

    @GetMapping("/galactic-info/{id}")
    public String detailGalactic(
            @PathVariable Long id,
            Model model
    )
    {
        Galactic galacticObj = galacticService.findById(id).orElseThrow();
        model.addAttribute("oneGalactic", galacticObj);
        return "galactic/galactic-info";
    }

    @GetMapping("/galactic-info/{id}/del")
    public String delGalactic(@PathVariable Long id) {
        Galactic galacticObj = galacticService.findById(id).orElseThrow();
        galacticService.delete(galacticObj);
        return "redirect:/galactic/";
    }

    @GetMapping("/galactic-info/{id}/upd")
    public String updGalactic(@PathVariable Long id, Model model)
    {
        model.addAttribute("object", galacticService.findById(id).orElseThrow());
        return "galactic/galactic-upd";
    }

    @PostMapping("/galactic-info/{id}/upd" )
    public String updGalacticPost(@PathVariable Long id,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "diametr") double diametr,
                                @RequestParam(name = "weight") double weight,
                                @RequestParam(name = "rotationSpeed") double rotationSpeed,
                                @RequestParam(name = "lumen") double lumen
    ) {
        Galactic newGalactic = galacticService.findById(id).orElseThrow();
        newGalactic.setName(name);
        newGalactic.setDiametr(diametr);
        newGalactic.setWeight(weight);
        newGalactic.setRotationSpeed(rotationSpeed);
        newGalactic.setLumen(lumen);

        galacticService.save(newGalactic);
        return "redirect:/galactic/";
    }
}
