package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Scientist;
import com.testproject.testproject.Models.Star;
import com.testproject.testproject.Repository.ScientistRepository;
import com.testproject.testproject.Repository.StarRepository;
import com.testproject.testproject.Services.ScientistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/star")
public class StarController {

    @Autowired
    StarRepository starRepository;

    public final ScientistService scientistService;

    public StarController(ScientistService scientistService) {
        this.scientistService = scientistService;
    }

    @GetMapping("/")
    public String index(Model model) {

        Iterable<Star> starsIterable=  starRepository.findAll();
        model.addAttribute("starlist", starsIterable);
        return "star/index";
    }

    @GetMapping("/add")
    public String AddView(Model model) {
        Iterable<Scientist> scientists = scientistService.findAll();
        model.addAttribute("scientistlist", scientists);
        return "star/star-add";
    }

    @GetMapping("/add/{id}/scientists/")
    public String AddScientistsView(@PathVariable long id, Model model) {
      ArrayList<Scientist> filtratedScientist = new ArrayList<>();
        Star star = starRepository.findById(id).orElseThrow();
       Iterable<Scientist> scientists = scientistService.findAll();
       model.addAttribute("star",star);

      for(Scientist scientist :
           scientists) {
           if(!star.getScientists().contains(scientist))
               filtratedScientist.add(scientist);
       }

       model.addAttribute("scientists", filtratedScientist);
       model.addAttribute("star", star);

        return "star/star-add-scientists";
    }
    @PostMapping("/add/{id}/scientists/")
    public String AddScientists(@PathVariable long id, @RequestParam String scientistSurname) {

        Star star = starRepository.findById(id).orElseThrow();
        Scientist scientist = scientistService.findBySurname(scientistSurname).orElseThrow();
        star.getScientists().add(scientist);
        starRepository.save(star);


        return "redirect:/star/";
    }

    @PostMapping("/add")
    public String AddStar(Star star, @RequestParam String scientistSurname) {

        //связь МкМ - добавить к звезде ученых
        Scientist scientist = scientistService.findBySurname(scientistSurname).orElseThrow();
        List<Scientist> scientistList = new ArrayList<Scientist>();
        scientistList.add(scientist);
        star.setScientists(scientistList);
        starRepository.save(star);

        //Связь МкМ - добавить к ученому звезды
        //scientist.getStars().add(star);
        //scientistRepository.save(scientist)

        return "redirect:/star/";
    }
}
