package org.azhang.weibo.dao;

import org.azhang.weibo.dto.UserDetailResult;

public interface UserDao {
    UserDetailResult getUserDetail(Long myId, Long userId);
}
