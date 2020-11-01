package com.whgc.controller.adminController;

import com.github.pagehelper.PageInfo;
import com.whgc.bean.Tag;
import com.whgc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class AdminTagController {

    @Autowired
    private TagService tagService;
    //index tag page
    @GetMapping("/admin/tags{pn}")
    public String adminTags(@RequestParam(value="pn", defaultValue="1") Integer pn, Model model){
        if(pn == null || pn <= 0){
            pn = new Integer(1);
        }
        PageInfo pageInfo = tagService.startPage(pn,5);
        model.addAttribute("tags",pageInfo);
        return "admin/tags";
    }
    //tag - add page
    @GetMapping("/admin/tags-add")
    public String adminTags_add(Model model){
        Integer id = new Integer(0);
        model.addAttribute("tag",new Tag(0,"空值"));
        return"/admin/tags-input";
    }
    //edit skip add page
    @GetMapping("/admin/tags-input{id}")
    public String tag_edit(@RequestParam(value="id") Integer id, Model model){
        if(id == null || id <= 0 ){
            return "redirect:/admin/tags-add";
        }
        Tag byidTag = tagService.findByidTag(id);
        model.addAttribute("tag",byidTag);
        return"/admin/tags-input";
    }
    //edit page if is add page
    @PostMapping("/admin/tags-edit")
    public String tag_edit_over(Integer id,String tagName){
        if(id <= 0){
            tagService.saveTag(new Tag(id,tagName));
        }else {
            tagService.updateTag(new Tag(id,tagName));
        }
        return "redirect:/admin/tags?pn=1";
    }

    @GetMapping("/admin/tags-del{id,pn}")
    public String delType(@RequestParam(value="id") Integer id,@RequestParam(value="pn") Integer pn){
        if(id <= 0){
            return "redirect:/admin/tags?pn=0";
        }
        int i = tagService.dropTag(id);
        return "redirect:/admin/tags?pn="+pn;
    }
}
