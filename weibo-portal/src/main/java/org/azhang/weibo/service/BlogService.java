package org.azhang.weibo.service;

import org.azhang.weibo.dto.*;
import org.azhang.weibo.model.BlogCollect;
import org.azhang.weibo.model.BlogLike;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogService {

    @Transactional
    BlogDetailResult insertBlog(PostBlogParam postBlogParam);

    List<BlogDetailResult> getTimelineBlog(Long userId, Long lastBlogId, Long lastBlogDate);

    Boolean insertBlogLike(BlogLike blogLike);

    Boolean deleteBlogLike(BlogLike blogLike);

    Boolean insertCollect(BlogCollect blogCollect);

    Boolean deleteCollect(BlogCollect blogCollect);

}
