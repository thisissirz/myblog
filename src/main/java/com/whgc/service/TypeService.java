package com.whgc.service;

import com.github.pagehelper.PageInfo;
import com.whgc.bean.Blog;
import com.whgc.bean.Type;

import java.util.List;

public interface TypeService {

    public int saveType(Type type);
    public int dropType(Integer id);
    public int updateType(Type type);
    public Type findByidType(Integer id);
    public List<Type> findallType();
    List<Type> listTypeGroupBlogNums();
    public List<Type> descAllType();

    public PageInfo startPage(int pageNum,int pageSize);

    List<Type> findNumType(int num);
}
