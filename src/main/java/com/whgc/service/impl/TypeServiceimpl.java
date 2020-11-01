package com.whgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whgc.bean.Type;
import com.whgc.mapper.TypeMapper;
import com.whgc.service.PageService;
import com.whgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service
public class TypeServiceimpl implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    public int dropType(Integer id) {
        return typeMapper.dropType(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public Type findByidType(Integer id) {
        return typeMapper.getByidType(id);
    }

    @Override
    public List<Type> findallType() {
        List<Type> allType = typeMapper.getAllType();
        List<Type> types = listTypeGroupBlogNums();
        if(!CollectionUtils.isEmpty(allType)){
            if(!CollectionUtils.isEmpty(types)){
                for(Type tGroup:types){
                    for(Type alltype:allType){
                        if(tGroup.getId() == alltype.getId()){
                            alltype.setBlogNums(tGroup.getBlogNums());
                        }
                    }
                }
            }
        }

        return allType;
    }

    @Override
    public List<Type> listTypeGroupBlogNums() {
        return typeMapper.listTypeGroupBlogNums();
    }

    @Override
    public List<Type> descAllType() {
        return typeMapper.DescAllType();
    }

    public PageInfo startPage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Type> types = descAllType();
        PageInfo<Type> typeList = new PageInfo<>(types,pageSize);
        return typeList;
    }

    @Override
    public List<Type> findNumType(int num) {
        List<Type> numType = typeMapper.findNumType(num);
        List<Type> allType = typeMapper.listTypeGroupBlogNums();
        if(!CollectionUtils.isEmpty(numType)){
            if(!CollectionUtils.isEmpty(allType)){
                for(Type numtype:numType){
                    for(Type alltype:allType){
                        if(numtype.getId() == alltype.getId()){
                            numtype.setBlogNums(alltype.getBlogNums());
                        }
                    }
                }
            }
        }
        return numType;
    }
}
