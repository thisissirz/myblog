package com.whgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.bean.Blog;
import com.whgc.bean.BlogTag;
import com.whgc.bean.Tag;
import com.whgc.bean.Type;
import com.whgc.mapper.BlogMapper;
import com.whgc.mapper.BlogTagMapper;
import com.whgc.mapper.TagMapper;
import com.whgc.mapper.TypeMapper;
import com.whgc.service.BlogService;
import com.whgc.service.PageService;
import com.whgc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogServiceimpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagService tagService;
    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int dropBlog(Integer id) {
        return blogMapper.dropBlog(id);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Transactional
    @Override
    public Blog findByidBlog(Integer id) {
        Blog blog = blogMapper.getByidBlog(id);
        List<Tag> blogTags = tagService.findBlogTags(id);
        Type type = typeMapper.getByidType(blog.getTypeId());
        blog.setType(type);
        blog.setTags(blogTags);
        return blog;
    }
    @Transactional
    @Override
    public List<Blog> findallBlog() {
        List<Blog> allBlog = blogMapper.getAllBlog();
        return allBlog;
    }
    @Transactional
    @Override
    public List<Blog> descAllBlog() {
        List<Blog> blogs = blogMapper.descAllBlog();
        for(Blog blog:blogs){
            Type type = typeMapper.getByidType(blog.getTypeId());
            blog.setType(type);
        }
        return blogs;
    }
    @Transactional
    @Override
    public PageInfo findByPartBlog(Blog blog) {
        PageHelper.startPage(1,5);
        List<Blog> blogs = blogMapper.findByPartBlog(blog);
        for(Blog blog1:blogs){
            Type type = typeMapper.getByidType(blog1.getTypeId());
            blog1.setType(type);
        }
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogs,5);
        return blogPageInfo;
    }

    @Override
    public List<Blog> findNumBlog(int num) {
        return blogMapper.findNumBlog(num);
    }

    @Transactional
    @Override
    public List<Blog> findByTypeId(Integer id) {
        List<Blog> byTypeId = blogMapper.findByTypeId(id);
        List<Blog> blogs = new ArrayList<>();
        for(Blog b: byTypeId){
            blogs.add(findByidBlog(b.getId()));
        }
        return blogs;
    }

    @Override
    public List<Blog> findTitleContentBlog(String query) {
        List<Blog> blogs = blogMapper.findTitleContentBlog(query);
        return blogs;
    }

    @Override
    public List<Blog> findYearBlog(String year) {
        return blogMapper.findYearBlog(year);
    }

    @Override
    public void addViews(Integer blogId) {
        blogMapper.addViews(blogId);
    }


    @Transactional
    @Override
    public PageInfo startPage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogs = descAllBlog();
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogs,pageSize);
        for(Blog b:blogPageInfo.getList()){
            List<Tag> blogTags = tagService.findBlogTags(b.getId());
            b.setTags(blogTags);
        }
        return blogPageInfo;
    }

    @Override
    public PageInfo PagingAfter(int pageNum, int pageSize, List list) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(list,pageSize);
        for(Blog b:blogPageInfo.getList()){
            List<Tag> blogTags = tagService.findBlogTags(b.getId());
            Type type = typeMapper.getByidType(b.getTypeId());
            b.setTags(blogTags);
            b.setType(type);
        }
        return blogPageInfo;
    }
}
