package org.azhang.weibo.dao;

import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.dto.CommentDetailParam;
import org.azhang.weibo.dto.CommentDetailResult;
import org.azhang.weibo.dto.CommentIdRelationResult;

import java.util.List;

public interface CommentDao {

    List<CommentIdRelationResult> getCommentIdRelationByBlogId(@Param("commentDetailParam") CommentDetailParam commentDetailParam);

    List<CommentDetailResult> getCommentListDetailById(@Param("userId") Long userId, @Param("commentIdList") List<Long> commentIdList);

}
