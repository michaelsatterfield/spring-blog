package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {



    @GetMapping ("/posts/index")
    public String allPosts(Model model) {
        List<String> newPosts = new ArrayList<>();
        newPosts.add("Telephone for Sale, 25 Dollars.");
        newPosts.add("Rechargeable Batteries in Box, 10 Dollars");

        model.addAttribute("newPosts",newPosts );
        return "posts/index";
    }

    @GetMapping ("/posts/show")
    public String individualPost(@ModelAttribute String post, Model model) {

        model.addAttribute("post"," Here is a New Post!" + post );
        //        Post newPost = new Post();
        return "/posts/show";
    };

    @GetMapping ("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable long id) {
        return "This is the View Post Page : "+ id + ".";
    }
    @GetMapping ("/posts/create")
    @ResponseBody
    public String viewCreateForm() {
        return "This is a View Form for Creating Post Page.";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This is a Create Post Page.";
    }






}
