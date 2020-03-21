package org.azhang.weibo.model;

import java.io.Serializable;

public class BlogRepost implements Serializable {
    private Long id;

    private Long blogId;

    private Long sourceBlogId;

    private Long leafBlogId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getSourceBlogId() {
        return sourceBlogId;
    }

    public void setSourceBlogId(Long sourceBlogId) {
        this.sourceBlogId = sourceBlogId;
    }

    public Long getLeafBlogId() {
        return leafBlogId;
    }

    public void setLeafBlogId(Long leafBlogId) {
        this.leafBlogId = leafBlogId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogId=").append(blogId);
        sb.append(", sourceBlogId=").append(sourceBlogId);
        sb.append(", leafBlogId=").append(leafBlogId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}