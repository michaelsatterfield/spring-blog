package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello/{user}") //request
    @ResponseBody // response
    public String showAHelloMessage(@PathVariable String user) {
        return "Hello from " + user; // what I respond with
    }

    @GetMapping("/create-a-hello")
    @ResponseBody
    public String showCreatePage() {
        return "this would be the create form";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String submitCreateForm() {
        //... saving an ad
        return "ad has been saved!";
    }

    @GetMapping("/get-zip/{zipcode}")
    @ResponseBody
    public int getZipCode(@PathVariable int zipcode) {
        return zipcode;
    }
//
//    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
//    @ResponseBody
//    public String addOne(@PathVariable int number) {
//        return number + " plus one is " + (number + 1) + "!";
//    }
//    @GetMapping ("/fizzbuzz/{number}")
//    @ResponseBody
//    public Integer fizz(@PathVariable int number) {
//        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
//        for (String i : cars) {
//            System.out.println(i);
//        }
//        return cars.length;
//    }
}
