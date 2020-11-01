package com.whgc.bean;

import java.util.List;

public class BlogTag {
    private Integer id;
    private Integer blogId;
    private Integer tagId;

    public BlogTag() {
    }

    public BlogTag(Integer blogId, Integer tagId) {
        this.blogId = blogId;
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "BlogTag{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", tagId=" + tagId +
                '}';
    }

    public BlogTag(Integer id, Integer blogId, Integer tagId) {
        this.id = id;
        this.blogId = blogId;
        this.tagId = tagId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
