package com.whgc.mapper;

import com.whgc.bean.BlogTag;

import java.util.List;

public interface BlogTagMapper {
    public List<BlogTag> findAllBlogTag();
    public List<BlogTag> findBlogInTag(Integer blogId);
    public List<BlogTag> findTagInBlog(Integer bagId);
    int delBlogIntag(Integer blogId);
    int delByidTag(Integer tagId);

    int saveBlogTag(BlogTag blogTag);
}
