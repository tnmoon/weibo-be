package org.azhang.weibo.service;

import org.azhang.weibo.dto.Permission;
import org.azhang.weibo.dto.UserDetailResult;
import org.azhang.weibo.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface UserService {
    User getUserByUsername(String username);

    List<Permission> getPermissionList(Long id);

    Map login(String username, String password);

    @Transactional
    User register(String username, String password, String nickname);

    Boolean follow(Long followerId, Long bloggerId);

    Boolean defollow(Long followerId, Long bloggerId);

    UserDetailResult getUserDetail(Long myId, Long userId);

}
