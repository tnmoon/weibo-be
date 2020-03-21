package org.azhang.weibo.dto;

public class BlogIdRelationResult {
    private Long id;
    private Long SourceBlogId;

    @Override
    public String toString() {
        return "blogIdRelation{" +
                "id=" + id +
                ", SourceBlogId=" + SourceBlogId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceBlogId() {
        return SourceBlogId;
    }

    public void setSourceBlogId(Long sourceBlogId) {
        SourceBlogId = sourceBlogId;
    }
}
