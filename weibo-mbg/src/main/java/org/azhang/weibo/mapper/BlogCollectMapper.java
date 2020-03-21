package org.azhang.weibo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.model.BlogCollect;
import org.azhang.weibo.model.BlogCollectExample;

public interface BlogCollectMapper {
    long countByExample(BlogCollectExample example);

    int deleteByExample(BlogCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogCollect record);

    int insertSelective(BlogCollect record);

    List<BlogCollect> selectByExample(BlogCollectExample example);

    BlogCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogCollect record, @Param("example") BlogCollectExample example);

    int updateByExample(@Param("record") BlogCollect record, @Param("example") BlogCollectExample example);

    int updateByPrimaryKeySelective(BlogCollect record);

    int updateByPrimaryKey(BlogCollect record);
}