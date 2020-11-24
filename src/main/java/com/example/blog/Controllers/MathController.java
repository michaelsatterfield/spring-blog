package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{number}/and/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String addition(@PathVariable int number, @PathVariable int numberB) {
        return number + " plus " + numberB + " = " + (number + numberB) + "!";
    }

    @RequestMapping(path = "/subtract/{number}/from/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String subtraction(@PathVariable int number, @PathVariable int numberB) {
        return number + " minus " + numberB + " = " + (number - numberB) + "!";
    }

    @RequestMapping(path = "/multiply/{number}/and/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplication(@PathVariable int number, @PathVariable int numberB) {
        return number + " times " + numberB + " = " + (number * numberB) + "!";
    }

    @RequestMapping(path = "/divide/{number}/by/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String division(@PathVariable float number, @PathVariable float numberB) {
        return number + " divided by " + numberB + " = " + (number / numberB) + "!";
    }

}
