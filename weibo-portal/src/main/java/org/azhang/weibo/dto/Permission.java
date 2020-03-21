package org.azhang.weibo.dto;

import java.io.Serializable;

public class Permission implements Serializable {
    private Integer id;
    private String username;
    private String value;
    private Integer type;

    public Permission(Integer id, String username, String value, Integer type) {
        this.id = id;
        this.username = username;
        this.value = value;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
