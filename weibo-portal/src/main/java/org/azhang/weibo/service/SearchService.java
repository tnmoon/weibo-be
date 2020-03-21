package org.azhang.weibo.service;

import org.azhang.weibo.dto.UserDetailResult;

public interface SearchService {
    UserDetailResult searchUser(Long myId, String keyword);
}
