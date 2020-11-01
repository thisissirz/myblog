package com.whgc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.bean.Blog;
import com.whgc.bean.Tag;
import com.whgc.bean.Type;
import com.whgc.service.BlogService;
import com.whgc.service.TagService;
import com.whgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TagController {
    @Autowired
    BlogService blogService;
    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String tagIndex(Model model){
        PageInfo pageInfo = blogService.startPage(1, 5);
        List<Tag> tags = tagService.findallTag();
        model.addAttribute("tagId",0);
        model.addAttribute("blogs",pageInfo);
        model.addAttribute("tags",tags);
        return "tags";
    }
    @GetMapping("/tag{id,pn}")
    public String typePn(@RequestParam(value = "id",defaultValue = "0") Integer id, @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        List<Tag> tags = tagService.findallTag();
        List<Blog> blogs = new ArrayList<>();
        if(id != null && id != 0){
            PageHelper.startPage(pn,5);
            blogs = tagService.findTagInBlogs(id);
        }else if(id == 0){
            PageHelper.startPage(pn,5);
            blogs = blogService.findallBlog();
        }
        PageInfo<Blog> blogPageInfo = tagService.PagingAfter(pn,5,blogs);
        model.addAttribute("tagId",id);
        model.addAttribute("blogs",blogPageInfo);
        model.addAttribute("tags",tags);
        return "tags";
    }

}
