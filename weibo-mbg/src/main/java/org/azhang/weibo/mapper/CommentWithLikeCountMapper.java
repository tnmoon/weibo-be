package org.azhang.weibo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.model.CommentWithLikeCount;
import org.azhang.weibo.model.CommentWithLikeCountExample;

public interface CommentWithLikeCountMapper {
    long countByExample(CommentWithLikeCountExample example);

    int deleteByExample(CommentWithLikeCountExample example);

    int insert(CommentWithLikeCount record);

    int insertSelective(CommentWithLikeCount record);

    List<CommentWithLikeCount> selectByExample(CommentWithLikeCountExample example);

    int updateByExampleSelective(@Param("record") CommentWithLikeCount record, @Param("example") CommentWithLikeCountExample example);

    int updateByExample(@Param("record") CommentWithLikeCount record, @Param("example") CommentWithLikeCountExample example);
}