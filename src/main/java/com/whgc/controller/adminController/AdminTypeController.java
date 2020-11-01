package com.whgc.controller.adminController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.bean.Type;
import com.whgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class AdminTypeController {

    @Autowired
    private TypeService typeService;
    //Type page
    @GetMapping("/admin/types{pn}")
    public String types(@RequestParam(value="pn", defaultValue="1") Integer pn, Model model){
        PageInfo typeList = typeService.startPage(pn,5);
        model.addAttribute("types",typeList);
        return "admin/types";
    }

    //type add page   typeinput page need one id value
    @GetMapping("/admin/type-add")
    public String addType(){
        return "redirect:/admin/types-input?id=0";
    }
    //Type add edit page
    @GetMapping("/admin/types-input{id}")
    public String types_input(@RequestParam(value="id") Integer id,Model model){
        //query is add or edit
        if(id == null || id == 0){
            model.addAttribute("type",new Type(0));
            return "admin/types-input";
        }
        Type byidType = typeService.findByidType(id);
        model.addAttribute("type",byidType);
        return "admin/types-input";
    }

    //Type delete page
    @GetMapping("/admin/types-del{id,pn}")
    public String delType(@RequestParam(value="id") Integer id,@RequestParam(value="pn") Integer pn){
        if(id <= 0){
            return "redirect:/admin/types?pn=0";
        }
        int i = typeService.dropType(id);
        if(i <= 0){
            return "redirect:/admin/types?pn=0";
        }
        return "redirect:/admin/types?pn="+pn;
    }

    //type edited
    @PostMapping("/admin/types-edit")
    public String updateType(Integer id,String typename){
        if(id >0){
            System.out.println("update-------------"+id+typename);
            typeService.updateType(new Type(id,typename));
        }else if(id <= 0){
            System.out.println("save-------------"+id+typename);
            typeService.saveType(new Type(id,typename));
        }
        return "redirect:/admin/types?pn=1";
    }

}
