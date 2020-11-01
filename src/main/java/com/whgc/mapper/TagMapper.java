package com.whgc.mapper;

import com.whgc.bean.Blog;
import com.whgc.bean.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface TagMapper {

    public int saveTag(Tag tag);
    public int dropTag(Integer id);
    public int updateTag(Tag tag);
    public Tag getByidTag(Integer id);
    public List<Tag> getAllTag();

    List<Tag> descAllTag();

    List<Tag> findNumTags(int num);
}
