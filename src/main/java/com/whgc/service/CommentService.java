package com.whgc.service;

import com.whgc.bean.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> oneCommentAllUp(Integer id);
    public int saveComment(Comment comment);
    List<Comment> listBlogComment(Integer id);
}
