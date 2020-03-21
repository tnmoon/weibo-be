package org.azhang.weibo.dto;

public class CommentDetailParam {
    private Long blogId;
    private Long lastCommentId;
    private Long lastCommentTimestamp;
    private Long userId;
    private Integer lastLikeCount;

    @Override
    public String toString() {
        return "CommentDetailParam{" +
                "blogId=" + blogId +
                ", lastCommentId=" + lastCommentId +
                ", lastCommentTimestamp=" + lastCommentTimestamp +
                ", userId=" + userId +
                ", lastLikeCount=" + lastLikeCount +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getLastCommentId() {
        return lastCommentId;
    }

    public void setLastCommentId(Long lastCommentId) {
        this.lastCommentId = lastCommentId;
    }

    public Long getLastCommentTimestamp() {
        return lastCommentTimestamp;
    }

    public void setLastCommentTimestamp(Long lastCommentTimestamp) {
        this.lastCommentTimestamp = lastCommentTimestamp;
    }

    public Integer getLastLikeCount() {
        return lastLikeCount;
    }

    public void setLastLikeCount(Integer lastLikeCount) {
        this.lastLikeCount = lastLikeCount;
    }
}
