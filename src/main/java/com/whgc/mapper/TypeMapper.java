package com.whgc.mapper;

import com.whgc.bean.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface TypeMapper {

    public int saveType(Type type);
    public int dropType(Integer id);
    public int updateType(Type type);
    public Type getByidType(Integer id);
    public List<Type> getAllType();
    public List<Type> DescAllType();

    List<Type> findNumType(int num);

    List<Type> listTypeGroupBlogNums();
}
