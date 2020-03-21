package org.azhang.weibo.dto;

public class UserBlogDetail {

    private Integer followCount;
    private Integer fansCount;
    private Integer blogCount;

    @Override
    public String toString() {
        return "UserBlogDetail{" +
                "followCount=" + followCount +
                ", fansCount=" + fansCount +
                ", blogCount=" + blogCount +
                '}';
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }
}
