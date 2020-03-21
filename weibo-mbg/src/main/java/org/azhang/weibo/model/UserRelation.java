package org.azhang.weibo.model;

import java.io.Serializable;
import java.util.Date;

public class UserRelation implements Serializable {
    private Long id;

    private Long followerId;

    private Long bloggerId;

    private Integer type;

    private Date followTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(Long bloggerId) {
        this.bloggerId = bloggerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", followerId=").append(followerId);
        sb.append(", bloggerId=").append(bloggerId);
        sb.append(", type=").append(type);
        sb.append(", followTime=").append(followTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}