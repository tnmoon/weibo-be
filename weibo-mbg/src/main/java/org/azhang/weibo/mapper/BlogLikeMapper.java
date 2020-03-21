package org.azhang.weibo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.model.BlogLike;
import org.azhang.weibo.model.BlogLikeExample;

public interface BlogLikeMapper {
    long countByExample(BlogLikeExample example);

    int deleteByExample(BlogLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogLike record);

    int insertSelective(BlogLike record);

    List<BlogLike> selectByExample(BlogLikeExample example);

    BlogLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogLike record, @Param("example") BlogLikeExample example);

    int updateByExample(@Param("record") BlogLike record, @Param("example") BlogLikeExample example);

    int updateByPrimaryKeySelective(BlogLike record);

    int updateByPrimaryKey(BlogLike record);
}