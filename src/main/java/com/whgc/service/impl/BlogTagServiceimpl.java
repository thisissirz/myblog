package com.whgc.service.impl;

import com.whgc.bean.Blog;
import com.whgc.bean.BlogTag;
import com.whgc.mapper.BlogTagMapper;
import com.whgc.service.BlogService;
import com.whgc.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogTagServiceimpl implements BlogTagService {
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private BlogService blogService;
    @Override
    public List<BlogTag> findAllBlogTag() {
        return null;
    }

    @Override
    public List<BlogTag> findBlogInTag(Integer BlogId) {
        return blogTagMapper.findBlogInTag(BlogId);
    }

    @Override
    public List<BlogTag> findTagInBlog(Integer tagId) {
        List<BlogTag> tagInBlog = blogTagMapper.findTagInBlog(tagId);
        return tagInBlog;
    }
    @Transactional
    @Override
    public int saveBlogTag(BlogTag blogTag) {
        return blogTagMapper.saveBlogTag(blogTag);
    }

    @Transactional
    @Override
    public void saveBlogTag(int[] tagId) {
        List<Blog> blogs = blogService.descAllBlog();
        for(int t:tagId){
            saveBlogTag(new BlogTag(blogs.get(0).getId(),t));
        }
    }
    @Transactional
    @Override
    public void saveBlogTag(Integer blogId, int[] tagId) {
        if(blogId == null || blogId <= 0){
            saveBlogTag(tagId);
            return;
        }
        delBlogInTag(blogId);
        for(int t:tagId){
            saveBlogTag(new BlogTag(blogId,t));
        }
    }

    @Override
    public int delBlogInTag(Integer blogId) {
        return blogTagMapper.delBlogIntag(blogId);
    }
}
