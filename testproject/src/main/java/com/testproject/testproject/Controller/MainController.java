package com.testproject.testproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/home")
    public String Index() {
        return "Home";
    }


    @GetMapping("/calc")
    public String About(@RequestParam(name = "firstNum", required = false, defaultValue = "0") Double firstNum,
                        @RequestParam(name = "secondNum", required = false, defaultValue =  "0") Double secondNum,
                        @RequestParam(name = "operator", required = false, defaultValue =  "+") String operator,
                        Model model) {
        System.out.println("first number: " + firstNum);
        System.out.println("second number:" + secondNum);

        //adding attributes in model
        model.addAttribute("firstNum", firstNum);
        model.addAttribute("secondNum", secondNum);
        model.addAttribute("operator", operator);

        model.addAttribute("result", Calculate(firstNum, secondNum, operator));

        return "Calc";
    }


    @PostMapping("/calc")
    public String PostAbout(@RequestParam(name = "firstNum", required = false, defaultValue = "0") Double firstNum,
                            @RequestParam(name = "secondNum", required = false, defaultValue =  "0") Double secondNum,
                            @RequestParam(name = "operator", required = false, defaultValue =  "+") String operator,
                            Model model) {
        //adding attributes in model
        model.addAttribute("firstNum", firstNum);
        model.addAttribute("secondNum", secondNum);
        model.addAttribute("operator", operator);
        model.addAttribute("result", Calculate(firstNum, secondNum, operator));

        return "Calc";
    }

    public double Calculate(double firstNum, double secondNum, String operator) {
        switch(operator) {
            case "+": return firstNum+secondNum;
            case "-": return firstNum-secondNum;
            case "*": return firstNum*secondNum;
            case "/": return firstNum/secondNum;

            default: return 0.0;
        }
    }
}

