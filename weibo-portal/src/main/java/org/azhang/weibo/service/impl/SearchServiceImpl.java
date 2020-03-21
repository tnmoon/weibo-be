package org.azhang.weibo.service.impl;

import org.azhang.weibo.dao.UserDao;
import org.azhang.weibo.dto.UserDetailResult;
import org.azhang.weibo.mapper.UserMapper;
import org.azhang.weibo.model.User;
import org.azhang.weibo.model.UserExample;
import org.azhang.weibo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchServiceImpl implements SearchService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserDao userDao;

    @Override
    public UserDetailResult searchUser(Long myId, String keyword) {

        try {

            UserExample userExample = new UserExample();
            userExample.createCriteria().andNicknameEqualTo(keyword);
            List<User> userList = userMapper.selectByExample(userExample);

            if (userList == null || userList.size() == 0) return null;
            return userDao.getUserDetail(myId, userList.get(0).getId());

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
