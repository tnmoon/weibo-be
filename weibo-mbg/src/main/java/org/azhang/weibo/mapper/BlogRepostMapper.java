package org.azhang.weibo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.model.BlogRepost;
import org.azhang.weibo.model.BlogRepostExample;

public interface BlogRepostMapper {
    long countByExample(BlogRepostExample example);

    int deleteByExample(BlogRepostExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogRepost record);

    int insertSelective(BlogRepost record);

    List<BlogRepost> selectByExample(BlogRepostExample example);

    BlogRepost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogRepost record, @Param("example") BlogRepostExample example);

    int updateByExample(@Param("record") BlogRepost record, @Param("example") BlogRepostExample example);

    int updateByPrimaryKeySelective(BlogRepost record);

    int updateByPrimaryKey(BlogRepost record);
}