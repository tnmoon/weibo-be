package org.azhang.weibo.service.impl;

import org.azhang.weibo.dao.BlogDao;
import org.azhang.weibo.dao.UserDao;
import org.azhang.weibo.dto.UserDetailResult;
import org.azhang.weibo.dto.Permission;
import org.azhang.weibo.mapper.UserMapper;
import org.azhang.weibo.mapper.UserRelationMapper;
import org.azhang.weibo.model.User;
import org.azhang.weibo.model.UserExample;
import org.azhang.weibo.model.UserRelation;
import org.azhang.weibo.model.UserRelationExample;
import org.azhang.weibo.service.UserService;
import org.azhang.weibo.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRelationMapper userRelationMapper;
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<Permission> getPermissionList(Long id) {
        List<Permission> permissionList = new ArrayList<>();
        Permission permission = new Permission(77676, "li895227852", "1213", 2);
        permissionList.add(permission);
        return permissionList;
    }

    @Override
    public Map login(String username, String password) {
        try {
            User user = this.getUserByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("用户名不存在");
            }
            if (!user.getPassword().equals(password)) {
                throw new BadCredentialsException("密码错误");
            }
            String token = jwtTokenUtil.generateToken(user);
            Map<String, String> loginInfoMap = new HashMap<>();
            loginInfoMap.put("token", token);
            loginInfoMap.put("nickname", user.getNickname());
            loginInfoMap.put("uuid", user.getId().toString());
            loginInfoMap.put("profilePictureUrl", user.getProfilePictureUrl());
            return loginInfoMap;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User register(String username, String password, String nickname) {
        UserExample example = new UserExample();
        List<User> userList = null;

        example.createCriteria().andUsernameEqualTo(username);
        userList = userMapper.selectByExample(example);
        if (userList != null && userList.size() > 0) return null;

        example.createCriteria().andUsernameEqualTo(nickname);
        userList = userMapper.selectByExample(example);
        if (userList != null && userList.size() > 0) return null;

        User user = new User();
        user.setNickname(nickname);
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertSelective(user);

        UserRelation userRelation = new UserRelation();
        userRelation.setBloggerId(user.getId());
        userRelation.setFollowerId(user.getId());
        userRelationMapper.insertSelective(userRelation);

        return user;
    }

    @Override
    public Boolean follow(Long followerId, Long bloggerId) {
        if (followerId == bloggerId) return false;
        try {
            if (userMapper.selectByPrimaryKey(followerId) == null) {
                return false;
            }
            if (userMapper.selectByPrimaryKey(bloggerId) == null) {
                return false;
            }
            UserRelation userRelation = new UserRelation();
            userRelation.setFollowerId(followerId);
            userRelation.setBloggerId(bloggerId);
            userRelationMapper.insertSelective(userRelation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean defollow(Long followerId, Long bloggerId) {
        if (followerId == bloggerId) return false;
        try {
            UserRelationExample userRelationExample = new UserRelationExample();
            UserRelationExample.Criteria criteria = userRelationExample.createCriteria();
            criteria.andBloggerIdEqualTo(bloggerId);
            criteria.andFollowerIdEqualTo(followerId);
            userRelationMapper.deleteByExample(userRelationExample);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public UserDetailResult getUserDetail(Long myId, Long userId) {
        try {
            return userDao.getUserDetail(myId, userId);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
