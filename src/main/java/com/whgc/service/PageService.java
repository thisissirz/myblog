package com.whgc.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PageService<E> {
    public PageInfo startPage(int pageNum,int pageSize);

    public PageInfo<E> PagingAfter(int pageNum,int pageSize,List<E> list);
}
