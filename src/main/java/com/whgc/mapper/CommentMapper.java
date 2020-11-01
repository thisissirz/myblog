package com.whgc.mapper;

import com.whgc.bean.Comment;

import java.util.List;

public interface CommentMapper {

    public int saveComment(Comment comment);
    public int dropComment(Integer id);
    public int updateComment(Comment comment);
    public Comment findByidComment(Integer id);
    public List<Comment> findBlogComment(Integer id);
}
