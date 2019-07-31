package amsibsam.restful.controller;

import amsibsam.restful.model.Blog;
import amsibsam.restful.repository.BlogMockData;
import amsibsam.restful.repository.database.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    BlogMockData blogMockData = BlogMockData.getInstance();

    @Autowired
    BlogRepository repository;

    @RequestMapping("/")
    public String index() {
        return "Response from BlogController.java";
    }

    @GetMapping("/blogs")
    public List<Blog> blogs() {
        return repository.findAll();
    }

    @GetMapping("/blog")
    public Blog show(@RequestParam(name = "id") String id) {
        int blogId = Integer.parseInt(id);
        return repository.findOne(blogId);
    }

    @PostMapping("/blog")
    public Blog create(@RequestParam String title, @RequestParam String content) {
        return repository.save(new Blog(title, content));
    }
}
