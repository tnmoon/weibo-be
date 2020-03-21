package org.azhang.weibo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.model.BlogPicture;
import org.azhang.weibo.model.BlogPictureExample;

public interface BlogPictureMapper {
    long countByExample(BlogPictureExample example);

    int deleteByExample(BlogPictureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogPicture record);

    int insertSelective(BlogPicture record);

    List<BlogPicture> selectByExample(BlogPictureExample example);

    BlogPicture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByExample(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByPrimaryKeySelective(BlogPicture record);

    int updateByPrimaryKey(BlogPicture record);
}