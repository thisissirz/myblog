package com.whgc.service;

import com.github.pagehelper.PageInfo;
import com.whgc.bean.Blog;
import com.whgc.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BlogService extends PageService{

    public int saveBlog(Blog blog);
    public int dropBlog(Integer id);
    public int updateBlog(Blog blog);
    public Blog findByidBlog(Integer id);
    public List<Blog> findallBlog();
    public List<Blog> descAllBlog();

    PageInfo findByPartBlog(Blog blog);

    List<Blog> findNumBlog(int num);

    List<Blog> findByTypeId(Integer id);

    List<Blog> findTitleContentBlog(String query);

    List<Blog> findYearBlog(String Year);

    void addViews(Integer blogId);
}
