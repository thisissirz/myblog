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
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;

    @GetMapping({"/index{pn}","/"})
    public String indexBlog(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        if(pn == null){
            pn = new Integer(1);
        }
        PageInfo bloginfo = blogService.startPage(pn,5);
        List<Type> types = typeService.findNumType(6);
        List<Tag> tags = tagService.findNumTags(10);
        List<Blog> blogList = blogService.findNumBlog(8);
        //query without write Tags
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        model.addAttribute("blogs",bloginfo);
        model.addAttribute("blogList",blogList);
        return "index";
    }

    @PostMapping("/search")
    public String search(String query,Model model){
        PageHelper.startPage(1,5);
        List<Blog> blogs = blogService.findTitleContentBlog(query);
        PageInfo<Blog> pageInfo = new PageInfo(blogs,5);
        //  万不得已才这样写的。为的只是想把项目赶完了去实习
        for(Blog b:pageInfo.getList()){
            b.setType(typeService.findByidType(b.getTypeId()));
            b.setTags(tagService.findBlogTags(b.getId()));
        }
        model.addAttribute("blogs",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }
    @GetMapping("/Search{query,pn}")
    public String search_Page(@RequestParam("query") String query,@RequestParam(value="pn",defaultValue = "1") Integer pn,Model model){
        if(query == null){
            return "redirect:/search";
        }
        PageHelper.startPage(pn,5);
        List<Blog> blogs = blogService.findTitleContentBlog(query);
        PageInfo<Blog> pageInfo = new PageInfo(blogs,5);
        for(Blog b:pageInfo.getList()){
            b.setType(typeService.findByidType(b.getTypeId()));
            b.setTags(tagService.findBlogTags(b.getId()));
        }
        model.addAttribute("blogs",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }



    @GetMapping("/error/{path}")
    public String error(@PathVariable String path){
        return "error/"+path;
    }


}
