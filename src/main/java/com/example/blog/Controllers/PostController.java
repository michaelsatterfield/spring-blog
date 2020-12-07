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


@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;


//dependency injection...can also use @autowired
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postToBeSaved.setOwner(user);
        Post dbPost = postDao.save(postToBeSaved);
        emailService.prepareAndSend(dbPost,"Your ad has been created","Your post has been logged! \n\n Title: '" + dbPost.getTitle()+"'\n Body: '" + dbPost.getBody()+"'");
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

 @PostMapping("posts/{id}/delete")
    public String deleteAd(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
 }




}
