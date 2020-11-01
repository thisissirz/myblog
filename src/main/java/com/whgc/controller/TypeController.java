package com.whgc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.bean.Blog;
import com.whgc.bean.Type;
import com.whgc.service.BlogService;
import com.whgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TypeController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;

    @GetMapping("/type{id,pn}")
    public String typePn(@RequestParam(value = "id",defaultValue = "0") Integer id,@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        List<Type> types = typeService.findallType();
        if (!CollectionUtils.isEmpty(types)) {
            Type type = new Type();
            type.setName("全部");
            for (Type t : types) {
                type.setBlogNums(type.getBlogNums() + t.getBlogNums());
            }
            types.add(type);
        }
        List<Blog> blogs = new ArrayList<>();
        if(id != null && id != 0){
            PageHelper.startPage(pn,5);
            blogs = blogService.findByTypeId(id);
        }else if(id == 0){
            PageHelper.startPage(pn,5);
            blogs = blogService.findallBlog();
        }
        PageInfo blogPageInfo = blogService.PagingAfter(pn,5,blogs);
        model.addAttribute("typeId",id);
        model.addAttribute("blogs",blogPageInfo);
        model.addAttribute("types",types);
        return "types";
    }

    @GetMapping("/types")
    public String typeIndex(Model model){
        PageInfo pageInfo = blogService.startPage(1, 5);
        List<Type> types = typeService.findallType();
        if (!CollectionUtils.isEmpty(types)) {
            Type type = new Type();
            type.setName("全部");
            for (Type t : types) {
                type.setBlogNums(type.getBlogNums() + t.getBlogNums());
            }
            types.add(type);
        }
        model.addAttribute("typeId",0);
        model.addAttribute("blogs",pageInfo);
        model.addAttribute("types",types);
        return "types";
    }

}

