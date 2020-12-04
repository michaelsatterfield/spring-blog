package com.example.blog.Controllers;
import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repos.PostRepository;
import com.example.blog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }
//Show all posts
    @GetMapping("/posts")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//    @GetMapping ("/posts/search")
//    public String search(@RequestParam(name = "term") String term, Model viewModel){
//        term = "%"+term+"%";
//        List<Post> dbPosts = postDao.findOne(term);
//        viewModel.addAttribute("ads", dbPosts);
//        return "ads/index";
//    }

//edit this method
    @GetMapping ("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping ("/posts/create")
    public String viewCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved){
        User user = userDao.getOne(1l);
        postToBeSaved.setOwner(user);
        Post dbPost = postDao.save(postToBeSaved);
        return "redirect:/posts/" + dbPost.getId();
    }
    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id,@ModelAttribute Post postToBeEdited){
        User user = userDao.getOne(1l);
        postToBeEdited.setOwner(user);
        postDao.save(postToBeEdited);
        return "redirect:/posts/";
    }
//    @PostMapping("/posts/{id}/edit")
//    public String editPost(
//            @PathVariable long id,
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "body") String body
//    ){
//        Post dbPost = postDao.getOne(id);
//        dbPost.setTitle(title);
//        dbPost.setBody(body);
//
//        postDao.save(dbPost);
//        return "redirect:/posts/";
//    }
 @PostMapping("posts/{id}/delete")
    public String deleteAd(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
 }




}
