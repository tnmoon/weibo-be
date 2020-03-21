package org.azhang.weibo.controller;


import org.azhang.weibo.bo.AdminUserDetails;
import org.azhang.weibo.dto.*;
import org.azhang.weibo.model.BlogCollect;
import org.azhang.weibo.model.BlogLike;
import org.azhang.weibo.service.BlogService;
import org.azhang.weibo.utils.response.WeiboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 与博文有关的所有API
 */

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("postBlog")
    public WeiboResponse postBlog(@RequestBody PostBlogParam postBlogParam) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postBlogParam.setUserId(userDetails.getUser().getId());
        BlogDetailResult blogReturnData = blogService.insertBlog(postBlogParam);
        if (blogReturnData != null) {
            return WeiboResponse.success(blogReturnData);
        } else {
            return WeiboResponse.failed();
        }
    }

    @PostMapping("postBlogLike")
    public WeiboResponse postBlogLike(@RequestBody BlogLike blogLike) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        blogLike.setUserId(userId);
        if (blogService.insertBlogLike(blogLike)) return WeiboResponse.success();
        else return WeiboResponse.failed();
    }

    @PostMapping("deleteBlogLike")
    public WeiboResponse deleteBlogLike(@RequestBody BlogLike blogLike) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        blogLike.setUserId(userId);
        if (blogService.deleteBlogLike(blogLike)) return WeiboResponse.success();
        else return WeiboResponse.failed();
    }

    @GetMapping("getTimelineBlog")
    public WeiboResponse getTimelineBlog(@RequestParam("lastBlogId") Long lastBlogId, @RequestParam("lastBlogTimestamp") Long lastBlogTimestamp) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<BlogDetailResult> blogDetailList = blogService.getTimelineBlog(userDetails.getUser().getId(), lastBlogId, lastBlogTimestamp);
        if (blogDetailList != null) return WeiboResponse.success(blogDetailList);
        else return WeiboResponse.failed();
    }

    @PostMapping("postCollect")
    public WeiboResponse postCollect(@RequestBody BlogCollect blogCollect) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        blogCollect.setUserId(userId);
        if (blogService.insertCollect(blogCollect)) return WeiboResponse.success();
        else return WeiboResponse.failed();
    }

    @PostMapping("deleteCollect")
    public WeiboResponse deleteCollect(@RequestBody BlogCollect blogCollect) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        blogCollect.setUserId(userId);
        if (blogService.deleteCollect(blogCollect)) return WeiboResponse.success();
        else return WeiboResponse.failed();
    }



}
