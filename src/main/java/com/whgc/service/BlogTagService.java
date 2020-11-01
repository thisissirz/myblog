package com.whgc.service;

import com.whgc.bean.BlogTag;

import java.util.List;

public interface BlogTagService {

    public List<BlogTag> findAllBlogTag();
    public List<BlogTag> findBlogInTag(Integer BlogId);
    public List<BlogTag> findTagInBlog(Integer tagId);
    public int saveBlogTag(BlogTag blogTag);
    public void saveBlogTag(int[] tagId);
    public void saveBlogTag(Integer blogId,int[] tagId);
    int delBlogInTag(Integer blogId);
}
