package com.whgc.controller;

import com.whgc.bean.Blog;
import com.whgc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArchivesController {

    @Autowired
    BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        List<Blog> blogList1 = blogService.findYearBlog("2018");
        List<Blog> blogList2 = blogService.findYearBlog("2019");
        List<Blog> blogList3 = blogService.findYearBlog("2020");
        List<Blog> blogList = blogService.findallBlog();
        model.addAttribute("blogList",blogList);
        model.addAttribute("blog2018",blogList1);
        model.addAttribute("blog2019",blogList2);
        model.addAttribute("blog2020",blogList3);
        return "archives";
    }

}
