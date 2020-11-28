package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "Welcome to the landing page!";
    }

}
