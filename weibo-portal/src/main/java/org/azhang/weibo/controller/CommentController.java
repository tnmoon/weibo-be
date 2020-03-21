package org.azhang.weibo.controller;

import org.azhang.weibo.bo.AdminUserDetails;
import org.azhang.weibo.dto.CommentDetailParam;
import org.azhang.weibo.dto.CommentDetailResult;
import org.azhang.weibo.model.CommentLike;
import org.azhang.weibo.service.CommentService;
import org.azhang.weibo.utils.response.WeiboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("postComment")
    public WeiboResponse postComment(@RequestBody Map<String, String> paramMap) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        CommentDetailResult commentReturnData = commentService.insertComment(paramMap.get("text"), Long.valueOf(paramMap.get("ownerId")), Integer.valueOf(paramMap.get("ownerType")), userId);
        if (commentReturnData != null) {
            return WeiboResponse.success(commentReturnData);
        } else {
            return WeiboResponse.failed();
        }
    }

    @GetMapping("getCommentByBlogId")
    public WeiboResponse getCommentByBlogId(@RequestParam("blogId") Long blogId,
                                            @RequestParam("lastCommentId") Long lastCommentId,
                                            @RequestParam("lastCommentTimestamp") Long lastCommentTimestamp,
                                            @RequestParam(value = "lastLikeCount", required = false) Integer lastLikeCount) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        CommentDetailParam commentDetailParam = new CommentDetailParam();

        commentDetailParam.setBlogId(blogId);
        commentDetailParam.setUserId(userId);
        commentDetailParam.setLastCommentId(lastCommentId);
        commentDetailParam.setLastCommentTimestamp(lastCommentTimestamp / 1000);
        commentDetailParam.setLastLikeCount(lastLikeCount);

        List<CommentDetailResult> commentDetailResultList = commentService.getCommentByBlogId(commentDetailParam);
        if (commentDetailResultList != null) return WeiboResponse.success(commentDetailResultList);
        else return WeiboResponse.failed();
    }

    @PostMapping("postCommentLike")
    public WeiboResponse postCommentLike(@RequestBody CommentLike commentLike) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        commentLike.setUserId(userId);
        if (commentService.insertCommentLike(commentLike)) return WeiboResponse.success();
        else return WeiboResponse.failed();
    }

    @PostMapping("deleteCommentLike")
    public WeiboResponse deleteCommentLike(@RequestBody CommentLike commentLike) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        commentLike.setUserId(userId);
        if (commentService.deleteCommentLike(commentLike)) return WeiboResponse.success();
        else return WeiboResponse.failed();
    }

}
