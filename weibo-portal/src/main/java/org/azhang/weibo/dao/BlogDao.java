package org.azhang.weibo.dao;

import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.dto.*;

import java.util.List;

public interface BlogDao {

    List<BlogIdRelationResult> getTimelineBlogIdRelation(@Param("userId") Long userId, @Param("lastBlogId") Long lastBlogId, @Param("lastBlogTimestamp") Long lastBlogTimestamp);

    List<BlogDetailResult> getBlogListDetailById(@Param("blogIdList") List<Long> blogIdList, @Param("userId") Long userId);

    Integer getRepostCountByBlogId(@Param("blogId") Long blogId);

    UserBlogDetail getUserBlogDetail(@Param("userId") Long userId);

}
