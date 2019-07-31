package amsibsam.restful.controller;

import amsibsam.restful.model.Blog;
import amsibsam.restful.repository.BlogMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    BlogMockData blogMockData = BlogMockData.getInstance();

    @RequestMapping("/")
    public String index() {
        return "Response from BlogController.java";
    }

    @GetMapping("/blogs")
    public List<Blog> blogs() {
        return blogMockData.fetchBlogs();
    }

    @GetMapping("/blog")
    public Blog show(@RequestParam(name = "id") String id) {
        int blogId = Integer.parseInt(id);
        return blogMockData.getBlogById(blogId);
    }

    @PostMapping("/blog")
    public Blog create(@RequestParam String id, @RequestParam String title, @RequestParam String content) {
        int blogId = Integer.parseInt(id);
        return blogMockData.createBlog(blogId, title, content);
    }
}
