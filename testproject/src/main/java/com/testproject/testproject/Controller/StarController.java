package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Star;
import com.testproject.testproject.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/star")
public class StarController {

    @Autowired
    StarRepository starRepository;

    @GetMapping("/")
    public String index(Model model) {

        Iterable<Star> starsIterable=  starRepository.findAll();
        model.addAttribute("starlist", starsIterable);
        return "star/index";
    }

    @GetMapping("/add")
    public String AddView() {
        return "star/star-add";
    }

    @PostMapping("/add")
    public String AddStar(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "classStar") String classStar,
            @RequestParam(name = "lumen") int lumen
    ) {
        Star new_star = new Star(name, classStar, lumen);
        starRepository.save(new_star);
        return "redirect:/";
    }
}
