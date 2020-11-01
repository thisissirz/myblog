package com.whgc.controller.adminController;

import com.github.pagehelper.PageInfo;
import com.whgc.bean.Blog;
import com.whgc.bean.BlogTag;
import com.whgc.bean.Tag;
import com.whgc.bean.Type;
import com.whgc.mapper.BlogTagMapper;
import com.whgc.service.BlogService;
import com.whgc.service.BlogTagService;
import com.whgc.service.TagService;
import com.whgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminBlogsController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogTagService blogTagService;
    //blogs index page
    @GetMapping("/admin/blogs")
    public String blogsIndex(Model model){
        PageInfo bloginfo = blogService.startPage(1,5);
        List<Type> types = typeService.findallType();
        model.addAttribute("types",types);
        model.addAttribute("blogs",bloginfo);
        return "admin/blogs";
    }
    //page skip n
    @GetMapping("/admin/blog{pn}")
    public String blogsSkipPage(@PathParam("pn") Integer pn,Model model){
        PageInfo bloginfo = blogService.startPage(pn,5);
        List<Type> types = typeService.findallType();
        model.addAttribute("types",types);
        model.addAttribute("blogs",bloginfo);
        return "admin/blogs";
    }
    //blogs input page / add page
    @GetMapping("/admin/blogs-input-add")
    public String blogsInput(Model model){
        List<Type> types = typeService.findallType();
        List<Tag> tags = tagService.findallTag();
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("blog",new Blog(0));
        return "admin/blogs-input";
    }
    //blogs edit page
    @GetMapping("/admin/blogs-input-edit{id}")
    public String blogs_edit(@PathParam("id") Integer id,Model model){
        // query blog edit might select type and tag,and blog edit info
        Blog blog = blogService.findByidBlog(id);
        List<Type> types = typeService.findallType();
        List<Tag> tags = tagService.findallTag();
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("blog",blog);
        return "admin/blogs-input";
    }

    @PostMapping("/admin/blogs/search")
    public String blogs_search(Model model,Blog blog){
        PageInfo bloginfo = blogService.findByPartBlog(blog);
        List<Type> types = typeService.findallType();
        model.addAttribute("types",types);
        model.addAttribute("blogs",bloginfo);
        return "admin/blogs :: blogList";
    }
    //blog submit after skip page
    @PostMapping("/admin/blogs/add-after")
    public String blogs_add_after(Blog blog,int[] tagId){
        if(blog == null || blog.getTypeId() == null){
            return "redirect:/admin/blogs-input-add";
        }
        //blogTag.setBlogId(blog.getId());
        if(blog.getId() == null || blog.getId() <= 0){
            blogService.saveBlog(blog);
            blogTagService.saveBlogTag(tagId);
        }else {
            blogService.updateBlog(blog);
            blogTagService.saveBlogTag(blog.getId(),tagId);
        }
        return "redirect:/admin/blog?pn=1";
    }
    @GetMapping("/admin/blog-del{id,pn}")
    public String blog_del(@PathParam("id")Integer id,@PathParam("pn") Integer pn){
        blogService.dropBlog(id);

        return "redirect:/admin/blog?pn="+pn;
    }

}
