package com.whgc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Type implements Serializable {
    private Integer id;
    private String name;
    private int blogNums;
    private List<Blog> blogs = new ArrayList<>();

    public Type(Integer id, String name, int blogNums, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogNums = blogNums;
        this.blogs = blogs;
    }

    public int getBlogNums() {
        return blogNums;
    }

    public void setBlogNums(int blogNums) {
        this.blogNums = blogNums;
    }

    public Type(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type(Integer id) {
        this.id = id;
    }

    public Type(Integer id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Type(String name) {
        this.name = name;
    }


    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogNums=" + blogNums +
                ", blogs=" + blogs +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

}
