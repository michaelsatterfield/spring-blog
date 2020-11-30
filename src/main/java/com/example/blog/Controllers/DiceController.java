package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {
//    return a view
    @GetMapping("/roll-dice")
    public String dice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String guessDice(@PathVariable int n, Model model){
        int random = (int) (Math.random() * ((6 - 1))) + 1;
        boolean correct = (n == random);
        model.addAttribute("correct",correct);
//        model.addAttribute("n",n);
//        model.addAttribute("random",random);
        return "/correctDice";
    }
}
