package com.whgc.bean;

import java.util.Date;

public class Comment {
    private Integer id;
    //昵称
    private String nickName;
    //
    private String email;
    //内容
    private String content;
    //头像
    private String avatar ="https://picsum.photos/id/1062/40/40";
    private Date createTime;
    private Integer blogId;
    //up a comment id
    private Integer upCommentId;
    private Integer downCommentId;

    private Comment upComment;
    private Comment downComment;
    private Blog blog;

    public Comment() {
    }

    public Comment(String nickName, String email, String content, Integer blogId, Integer upCommentId) {
        this.nickName = nickName;
        this.email = email;
        this.content = content;
        this.blogId = blogId;
        this.upCommentId = upCommentId;
    }

    public Comment(Integer id, String nickName, String email, String content, Integer blogId, Integer upCommentId, Integer downCommentId) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.content = content;
        this.blogId = blogId;
        this.upCommentId = upCommentId;
        this.downCommentId = downCommentId;
    }

    public Comment(Integer id, String nickName, String email, String content, Integer blogId) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.content = content;
        this.blogId = blogId;
    }

    public Comment(Integer id, String nickName, String email, String content, Date createTime, Integer blogId) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.content = content;
        this.createTime = createTime;
        this.blogId = blogId;
    }

    public Comment(Integer id, String nickName, String email, String content, Date createTime, Integer blogId, Integer upCommentId, Integer downCommentId, Comment upComment, Comment downComment, Blog blog) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.content = content;
        this.createTime = createTime;
        this.blogId = blogId;
        this.upCommentId = upCommentId;
        this.downCommentId = downCommentId;
        this.upComment = upComment;
        this.downComment = downComment;
        this.blog = blog;
    }

    public Comment(Integer id, String nickName, String email, String content, String avatar, Date createTime, Integer blogId, Integer upCommentId, Integer downCommentId, Comment upComment, Comment downComment, Blog blog) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.content = content;
        this.avatar = avatar;
        this.createTime = createTime;
        this.blogId = blogId;
        this.upCommentId = upCommentId;
        this.downCommentId = downCommentId;
        this.upComment = upComment;
        this.downComment = downComment;
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blogId=" + blogId +
                ", upCommentId=" + upCommentId +
                ", downCommentId=" + downCommentId +
                ", upComment=" + upComment +
                ", downComment=" + downComment +
                ", blog=" + blog +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUpCommentId() {
        return upCommentId;
    }

    public void setUpCommentId(Integer upCommentId) {
        this.upCommentId = upCommentId;
    }

    public Integer getDownCommentId() {
        return downCommentId;
    }

    public void setDownCommentId(Integer downCommentId) {
        this.downCommentId = downCommentId;
    }

    public Comment getUpComment() {
        return upComment;
    }

    public void setUpComment(Comment upComment) {
        this.upComment = upComment;
    }

    public Comment getDownComment() {
        return downComment;
    }

    public void setDownComment(Comment downComment) {
        this.downComment = downComment;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
