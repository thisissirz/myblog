package com.whgc.controller;

import com.github.pagehelper.PageInfo;
import com.whgc.bean.Blog;
import com.whgc.bean.Comment;
import com.whgc.bean.Tag;
import com.whgc.bean.Type;
import com.whgc.service.BlogService;
import com.whgc.service.CommentService;
import com.whgc.service.TagService;
import com.whgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;

    @GetMapping("/blog/{id}")
    public String blog_details(@PathVariable Integer id,Model model){
        if(id == null || id <= 0){
            return "blog";
        }
        List<Comment> comments = commentService.listBlogComment(id);
        Blog blog = blogService.findByidBlog(id);
        blogService.addViews(id);
        model.addAttribute("comments",comments);
        model.addAttribute("blog",blog);
        return "blog";
    }
}
