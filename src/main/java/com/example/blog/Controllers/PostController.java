package com.example.blog.Controllers;
import com.example.blog.models.Post;
import com.example.blog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }



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
    public String viewCreateForm(Model model) {
        model.addAttribute("posts/create", new Post());
        return "posts/create";
    }
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "This is a Create Post Page.";
//    }

    @PostMapping("/posts/create")
//    @ResponseBody
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post post = new Post(title,body);
        Post dbPost = postDao.save(post);
        return dbPost.getId() + dbPost.getTitle() + dbPost.getBody();
    }





}
