package org.azhang.weibo.dto;

import java.util.Date;
import java.util.List;

public class CommentIdRelationResult {
    private Long commentId;
    private Integer likeCount;
    private Date commentPostTime;
    private Integer replyCount;
    private List<CommentIdRelationResult> replyList;

    @Override
    public String toString() {
        return "CommentIdRelationResult{" +
                "commentId=" + commentId +
                ", likeCount=" + likeCount +
                ", commentPostTime=" + commentPostTime +
                ", replyCount=" + replyCount +
                ", replyList=" + replyList +
                '}';
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCommentPostTime() {
        return commentPostTime;
    }

    public void setCommentPostTime(Date commentPostTime) {
        this.commentPostTime = commentPostTime;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public List<CommentIdRelationResult> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<CommentIdRelationResult> replyList) {
        this.replyList = replyList;
    }
}
