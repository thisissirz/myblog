package com.whgc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.bean.*;
import com.whgc.mapper.BlogMapper;
import com.whgc.mapper.CommentMapper;
import com.whgc.mapper.TypeMapper;
import com.whgc.service.*;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MyblogCombatApplicationTests {

    @Autowired
    BlogMapper blogMapper;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    static Date date;
    @Test
    void contextLoads() {
        Blog blog = new Blog(1,"title1","内容1","图片路径1","标记1",1024,true,true,true,true,true,new Date(),new Date());
        blog.setTypeId(5);
        System.out.println(blogMapper.updateBlog(blog)>0?"插入Blog成功":"插入Blog失败");
    }

    @Test
    void testfind(){
        Blog blog = blogMapper.getByidBlog(1);

        List<Blog> blogs = blogMapper.getAllBlog();
        String date = new Date().toString();
        System.out.println(blog.getCreateTime().toString()+"/n---------------------------"+blogs);
    }
    @Autowired
    TypeMapper typeMapper;
    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;
    @Test
    void selectBlog(){
       /* List<Blog> blogs = blogService.descAllBlog();
        System.out.println(blogs.get(0).toString());*/
       /* List<Blog> blogs = blogMapper.descAllBlog();
        Integer typeId = blogs.get(0).getTypeId();

        System.out.println(typeMapper.getByidType(typeId));*/
       //Type type = new Type(13,"叙事");
        //typeMapper.saveType(type);
        //typeService.updateType(type);
    }

    @Test
    void pageTest(){
        PageHelper.startPage(2,5);
        List<Type> types = typeService.descAllType();
        PageInfo typeList = new PageInfo(types);
        for(Object list :typeList.getList()){
            System.out.println(list.toString());
        }
        System.out.println("================"+typeList.getPages());
        System.out.println(typeList.getPageNum()+"第几页");
        System.out.println(typeList.getStartRow()+"开始于第几条数据");
        System.out.println(typeList.getPrePage()+"前一页");
    }

    @Test
    void testLikeQuery(){
        Blog blog = new Blog();
        blog.setId(1);
        blog.setTypeId(1);
        blog.setRecommend(true);
        blog.setTitle("title");
        PageInfo byPartBlog = blogService.findByPartBlog(blog);
        System.out.println("===================\n"+byPartBlog.getList().toString());
        System.out.println(blogService.findByidBlog(1));
    }
    @Test
    void pageInfo(){
        PageInfo pageInfo = blogService.startPage(1, 5);
        System.out.println(pageInfo.getTotal());
    }
    @Test
    void blogTagtest(){
        Blog byidBlog = blogService.findByidBlog(7);
        System.out.println(byidBlog.getTags());
    }
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentService commentService;
    @Test
    void commentMappertest(){
        //Comment comment = new Comment(1,"tom","thisissirz@163.com","你是好样的",1,1,null);
        //commentMapper.saveComment(comment);
       /* List<Comment> comments = commentService.oneCommentAllUp(2);
        for(Comment c : comments){
            System.out.println(c);
        }*/
        List<Comment> comments = commentService.listBlogComment(1);
        for(Comment c:comments){
            System.out.println(c);
        }
    }
    @Test
    void testDescAllBlog(){
        PageInfo pageInfo = blogService.startPage(1,5);

        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getNextPage());
        System.out.println(pageInfo.getNavigatepageNums().length);
        System.out.println(blogService.descAllBlog().size());
    }
    @Test
    void Likequery(){
        /*List<Blog> blogs = blogMapper.findTitleContentBlog("求");
        for(Blog b : blogs){
            System.out.println(b);
        }*/
        PageHelper.startPage(1,5);
        List<Blog> blogs = blogService.findTitleContentBlog("");
        PageInfo<Blog> pageInfo = new PageInfo(blogs,5);
        for(Blog b : pageInfo.getList()){
            System.out.println("==========================================================================");
            System.out.println(b);
        }
    }
    @Test
    void testYear(){
        List<Blog> yearBlog = blogService.findYearBlog("2018");
        for(Blog b : yearBlog){
            System.out.println(b);
        }
    }
    @Autowired
    UserService userService;
    @Test
    void testMD5(){
        User user = userService.getUser("thisissirz", "1008611");
        if(user == null){
            System.out.println("============================");
            System.out.println("验证失败");
        }else{
            System.out.println("验证成功");
        }
    }
    @Autowired
    TagService tagService;
    @Test
    void testGetbyTag(){
        Tag byidTag = tagService.findByidTag(1);
        System.out.println(byidTag);
    }
    @Autowired
    BlogTagService blogTagService;
    @Test
    void saveBlogTag(){
        int[] arr = {1,2,6};
        blogTagService.delBlogInTag(2);
        blogTagService.saveBlogTag(2,arr);
        List<BlogTag> blogInTag = blogTagService.findBlogInTag(2);
        for (BlogTag b:blogInTag){
            System.out.println(b);
        }
    }
    @Test
    void testBlogNums(){
        List<Type> types = typeMapper.getAllType();
        for(Type t : types){
            System.out.println(t.toString());
        }
    }
}












