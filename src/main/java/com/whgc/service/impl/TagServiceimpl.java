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
import com.whgc.service.BlogService;
import com.whgc.service.TagService;
import com.whgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceimpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public int saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public int dropTag(Integer id) {
        return tagMapper.dropTag(id);
    }

    @Override
    public int updateTag(Tag tag) {
        blogTagMapper.delByidTag(tag.getId());
        return tagMapper.updateTag(tag);
    }

    @Override
    public Tag findByidTag(Integer id) {
        return tagMapper.getByidTag(id);
    }

    @Override
    public List<Tag> findallTag() {
        return tagMapper.getAllTag();
    }

    @Override
    public List<Tag> descAllTag() {
        return tagMapper.descAllTag();
    }

    @Override
    public List<Tag> findNumTags(int num) {

        return tagMapper.findNumTags(num);
    }
    @Transactional
    @Override
    public List<Tag> findBlogTags(Integer blogId) {
        List<BlogTag> blogInTag = blogTagMapper.findBlogInTag(blogId);
        List<Tag> tags = new ArrayList<>();
        for(BlogTag bt:blogInTag){
            Tag byidTag = tagMapper.getByidTag(bt.getTagId());
            tags.add(byidTag);
        }
        return tags;
    }

    @Override
    public List<Blog> findTagInBlogs(Integer tagId) {
        List<BlogTag> tagInBlog = blogTagMapper.findTagInBlog(tagId);
        List<Blog> blogs = new ArrayList<>();
        for(BlogTag bt : tagInBlog){
            Blog byidBlog = blogMapper.getByidBlog(bt.getBlogId());
            blogs.add(byidBlog);
        }
        return blogs;
    }

    @Override
    public PageInfo startPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tags = descAllTag();
        PageInfo<Tag> tagPageInfo = new PageInfo<>(tags,pageSize);
        return tagPageInfo;
    }

    @Override
    public PageInfo PagingAfter(int pageNum, int pageSize, List list) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(list,pageSize);
        for(Blog b:blogPageInfo.getList()){
            List<Tag> blogTags = findBlogTags(b.getId());
            Type type = typeService.findByidType(b.getTypeId());
            b.setTags(blogTags);
            b.setType(type);
        }
        return blogPageInfo;
    }
}
