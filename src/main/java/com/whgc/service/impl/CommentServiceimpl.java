package com.whgc.service.impl;

import com.whgc.bean.Comment;
import com.whgc.mapper.CommentMapper;
import com.whgc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Transactional
    @Override
    public List<Comment> oneCommentAllUp(Integer id) {
        List<Comment> comments = new  ArrayList<>();
        while (findOneComment(id).getUpCommentId()  != null){
            comments.add(findOneComment(id));
            id = findOneComment(id).getUpCommentId();
            comments.add(findOneComment(id));
        }
        return comments;
    }
    public Comment findOneComment(Integer id){
        return commentMapper.findByidComment(id);
    }
    @Transactional
    @Override
    public int saveComment(Comment comment) {
        return commentMapper.saveComment(comment);
    }

    @Override
    public List<Comment> listBlogComment(Integer id) {
        List<Comment> blogComment = commentMapper.findBlogComment(id);
        return blogComment;
    }
}
