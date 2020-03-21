package org.azhang.weibo.dto;

public class UserDetailResult {

    private String userNickname;
    private Long userId;
    private String userIconUrl;
    private String userDescription;
    private Integer followCount;
    private Integer fansCount;
    private Integer blogCount;
    private Boolean hasFollowed;

    @Override
    public String toString() {
        return "UserDetailResult{" +
                "userNickname='" + userNickname + '\'' +
                ", userId=" + userId +
                ", userIconUrl='" + userIconUrl + '\'' +
                ", hasFollowed=" + hasFollowed +
                ", userDescription='" + userDescription + '\'' +
                ", followCount=" + followCount +
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

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public Boolean getHasFollowed() {
        return hasFollowed;
    }

    public void setHasFollowed(Boolean hasFollowed) {
        this.hasFollowed = hasFollowed;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

}
