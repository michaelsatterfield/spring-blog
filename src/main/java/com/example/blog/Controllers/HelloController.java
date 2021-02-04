package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello/{name}") //request
    public String showAHelloMessage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "/hello";
    }
    @GetMapping("/join")
    public String showJoinForm(Model model){
        List<String> cohortNames = new ArrayList<>();
        cohortNames.add("Zebra");
        cohortNames.add("Tango");
        cohortNames.add("Fruit");

        model.addAttribute("cohortNames", cohortNames);
        return "/join";
    }
    @PostMapping("/join")
    public String postJoin(@RequestParam(name = "cohort")String cohort,Model model){
        model.addAttribute("cohort",cohort);
        return "/join";
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

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
//    thymeLeaf example
//    uses NO @ResponseBody...
//    @GetMapping("/home")
//    public String welcome(){
//        return "home";
//    }

}
