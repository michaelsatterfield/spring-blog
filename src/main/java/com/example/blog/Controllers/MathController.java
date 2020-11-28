package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @GetMapping("/add/{number}/and/{numberB}")
    @ResponseBody
    public String addition(@PathVariable int number, @PathVariable int numberB) {
        return number + " plus " + numberB + " = " + (number + numberB) + "!";
    }

    @GetMapping("/subtract/{number}/from/{numberB}")
    @ResponseBody
    public String subtraction(@PathVariable int number, @PathVariable int numberB) {
        return number + " minus " + numberB + " = " + (number - numberB) + "!";
    }

    @GetMapping("/multiply/{number}/and/{numberB}")
    @ResponseBody
    public String multiplication(@PathVariable int number, @PathVariable int numberB) {
        return number + " times " + numberB + " = " + (number * numberB) + "!";
    }

    @GetMapping("/divide/{number}/by/{numberB}")
    @ResponseBody
    public String division(@PathVariable double number, @PathVariable double numberB) {
        return number + " divided by " + numberB + " = " + (number / numberB) + "!";
    }

}
