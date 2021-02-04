package com.example.blog.Controllers;
import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repos.PostRepository;
import com.example.blog.repos.UserRepository;
import com.example.blog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public HomeController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }



    @GetMapping("/")
    public String home(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "home";
    }



//    @GetMapping("/")
//    public String home(){
//        return "home";
//    }

}
