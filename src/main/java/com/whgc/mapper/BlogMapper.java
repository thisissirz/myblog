package com.whgc.mapper;

import com.whgc.bean.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


public interface BlogMapper {

    public int saveBlog(Blog blog);
    public int dropBlog(Integer id);
    public int updateBlog(Blog blog);
    public Blog getByidBlog(Integer id);
    public List<Blog> getAllBlog();

    List<Blog> descAllBlog();

    List<Blog> findByPartBlog(Blog blog);

    List<Blog> findNumBlog(int num);

    List<Blog> findByTypeId(Integer id);

    List<Blog> findTitleContentBlog(String query);

    List<Blog> findYearBlog(String year);

    void addViews(Integer blogId);
}
