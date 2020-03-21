package org.azhang.weibo.dto;

import java.util.List;

public class PostBlogParam {
    private Long userId;
    private String text;
    private String postLocation;
    private String postTerminal;
    private Long sourceBlogId;
    private Long leafBlogId;
    private List<String> pictureUrlArray;

    @Override
    public String toString() {
        return "PostBlogParam{" +
                "userId=" + userId +
                ", text='" + text + '\'' +
                ", postLocation='" + postLocation + '\'' +
                ", postTerminal='" + postTerminal + '\'' +
                ", sourceBlogId=" + sourceBlogId +
                ", leafBlogId=" + leafBlogId +
                ", pictureUrlArray=" + pictureUrlArray +
                '}';
    }

    public Long getLeafBlogId() {
        return leafBlogId;
    }

    public void setLeafBlogId(Long leafBlogId) {
        this.leafBlogId = leafBlogId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation;
    }

    public void setPostTerminal(String postTerminal) {
        this.postTerminal = postTerminal;
    }

    public void setSourceBlogId(Long sourceBlogId) {
        this.sourceBlogId = sourceBlogId;
    }

    public void setPictureUrlArray(List<String> pictureUrlArray) {
        this.pictureUrlArray = pictureUrlArray;
    }

    public String getText() {
        return text;
    }

    public String getPostLocation() {
        return postLocation;
    }

    public String getPostTerminal() {
        return postTerminal;
    }

    public Long getSourceBlogId() {
        return sourceBlogId;
    }

    public List<String> getPictureUrlArray() {
        return pictureUrlArray;
    }

}
