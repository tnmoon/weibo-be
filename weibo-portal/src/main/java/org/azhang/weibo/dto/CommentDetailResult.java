package org.azhang.weibo.dto;

import java.util.Date;
import java.util.List;

public class CommentDetailResult {

    private Long commentId;
    private String commentText;
    private Date commentPostTime;
    private Integer likeCount;
    private Integer hasLiked;

    private Long userId;
    private String userNickname;
    private String userIconUrl;

    private Integer replyCount;
    private List<CommentDetailResult> replyList;

    @Override
    public String toString() {
        return "CommentDetailResult{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                ", commentPostTime=" + commentPostTime +
                ", likeCount=" + likeCount +
                ", hasLiked=" + hasLiked +
                ", userId=" + userId +
                ", userNickname='" + userNickname + '\'' +
                ", userIconUrl='" + userIconUrl + '\'' +
                ", replyCount=" + replyCount +
                ", replyList=" + replyList +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public List<CommentDetailResult> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<CommentDetailResult> replyList) {
        this.replyList = replyList;
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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentPostTime() {
        return commentPostTime;
    }

    public void setCommentPostTime(Date commentPostTime) {
        this.commentPostTime = commentPostTime;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }
}
