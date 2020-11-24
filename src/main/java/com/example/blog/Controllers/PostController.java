package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping ("/posts")
    @ResponseBody
    public String index() {
        return "This is the Post Index Page.";
    }

    @GetMapping ("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable long id) {
        return "This is the View Post Page : "+ id + ".";
    }
    @GetMapping ("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
        return "This is a View Create Post Page.";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This is a Create Post Page.";
    }




}
