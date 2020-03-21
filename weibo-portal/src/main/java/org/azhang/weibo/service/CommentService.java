package org.azhang.weibo.service;

import org.azhang.weibo.dto.CommentDetailParam;
import org.azhang.weibo.dto.CommentDetailResult;
import org.azhang.weibo.model.CommentLike;

import java.util.List;

public interface CommentService {

    List<CommentDetailResult> getCommentByBlogId(CommentDetailParam commentDetailParam);

    CommentDetailResult insertComment(String text, Long ownerId, Integer commentType, Long userId);

    Boolean insertCommentLike(CommentLike commentLike);

    Boolean deleteCommentLike(CommentLike commentLike);

}
