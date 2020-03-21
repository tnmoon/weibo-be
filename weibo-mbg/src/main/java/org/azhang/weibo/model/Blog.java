package org.azhang.weibo.model;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private Long id;

    private Long userId;

    private Integer type;

    private String text;

    private Date postTime;

    private String postLocation;

    private String postTerminal;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation;
    }

    public String getPostTerminal() {
        return postTerminal;
    }

    public void setPostTerminal(String postTerminal) {
        this.postTerminal = postTerminal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", text=").append(text);
        sb.append(", postTime=").append(postTime);
        sb.append(", postLocation=").append(postLocation);
        sb.append(", postTerminal=").append(postTerminal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}