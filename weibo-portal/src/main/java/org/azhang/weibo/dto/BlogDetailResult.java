package org.azhang.weibo.dto;

import java.util.Date;
import java.util.List;

public class BlogDetailResult {
    private Long blogId;
    private Integer firstCommentCount;
    private Integer secondCommentCount;
    private Integer repostCount;
    private Integer likeCount;
    private Integer hasLiked;
    private Integer hasCollected;
    private String blogText;
    private Date blogPostTime;
    private String blogPostTerminal;
    private String blogPostLocation;
    private Long userId;
    private String userNickname;
    private List<String> blogPictureUrlList;
    private String userProfilePictureUrl;
    private BlogDetailResult sourceBlogDetail;

    @Override
    public String toString() {
        return "BlogDetailTransfer{" +
                "blogId=" + blogId +
                ", firstCommentCount=" + firstCommentCount +
                ", secondCommentCount=" + secondCommentCount +
                ", repostCount=" + repostCount +
                ", likeCount=" + likeCount +
                ", hasLiked=" + hasLiked +
                ", hasCollected=" + hasCollected +
                ", blogText='" + blogText + '\'' +
                ", blogPostTime=" + blogPostTime +
                ", blogPostTerminal='" + blogPostTerminal + '\'' +
                ", blogPostLocation='" + blogPostLocation + '\'' +
                ", userId=" + userId +
                ", userNickname='" + userNickname + '\'' +
                ", blogPictureUrlList=" + blogPictureUrlList +
                ", userProfilePictureUrl='" + userProfilePictureUrl + '\'' +
                ", sourceBlogDetail=" + sourceBlogDetail +
                '}';
    }

    public Integer getHasCollected() {
        return hasCollected;
    }

    public void setHasCollected(Integer hasCollected) {
        this.hasCollected = hasCollected;
    }

    public BlogDetailResult getSourceBlogDetail() {
        return sourceBlogDetail;
    }

    public void setSourceBlogDetail(BlogDetailResult sourceBlogDetail) {
        this.sourceBlogDetail = sourceBlogDetail;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getFirstCommentCount() {
        return firstCommentCount;
    }

    public void setFirstCommentCount(Integer firstCommentCount) {
        this.firstCommentCount = firstCommentCount;
    }

    public Integer getSecondCommentCount() {
        return secondCommentCount;
    }

    public void setSecondCommentCount(Integer secondCommentCount) {
        this.secondCommentCount = secondCommentCount;
    }

    public Integer getRepostCount() {
        return repostCount;
    }

    public void setRepostCount(Integer repostCount) {
        this.repostCount = repostCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getHasLiked() {
        return hasLiked;
    }

    public void setHasLiked(Integer hasLiked) {
        this.hasLiked = hasLiked;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public Date getBlogPostTime() {
        return blogPostTime;
    }

    public void setBlogPostTime(Date blogPostTime) {
        this.blogPostTime = blogPostTime;
    }

    public String getBlogPostTerminal() {
        return blogPostTerminal;
    }

    public void setBlogPostTerminal(String blogPostTerminal) {
        this.blogPostTerminal = blogPostTerminal;
    }

    public String getBlogPostLocation() {
        return blogPostLocation;
    }

    public void setBlogPostLocation(String blogPostLocation) {
        this.blogPostLocation = blogPostLocation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public List<String> getBlogPictureUrlList() {
        return blogPictureUrlList;
    }

    public void setBlogPictureUrlList(List<String> blogPictureUrlList) {
        this.blogPictureUrlList = blogPictureUrlList;
    }

    public String getUserProfilePictureUrl() {
        return userProfilePictureUrl;
    }

    public void setUserProfilePictureUrl(String userProfilePictureUrl) {
        this.userProfilePictureUrl = userProfilePictureUrl;
    }
}
