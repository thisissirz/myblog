package com.whgc.service;

import com.whgc.bean.Blog;
import com.whgc.bean.Tag;

import java.util.List;

public interface TagService extends PageService{

    public int saveTag(Tag tag);
    public int dropTag(Integer id);
    public int updateTag(Tag tag);
    public Tag findByidTag(Integer id);
    public List<Tag> findallTag();
    public List<Tag> descAllTag();

    List<Tag> findNumTags(int i);
    List<Tag> findBlogTags(Integer blogId);
    List<Blog> findTagInBlogs(Integer tagId);
}
