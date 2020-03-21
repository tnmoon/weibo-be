package org.azhang.weibo.controller;

import org.azhang.weibo.bo.AdminUserDetails;
import org.azhang.weibo.dto.UserDetailResult;
import org.azhang.weibo.model.User;
import org.azhang.weibo.service.UserService;
import org.azhang.weibo.utils.response.WeiboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录接口，接收用户名和密码，验证成功后返回经算法加密后得到的token，该token将被前端妥善保管，以后的每次请求都将携带该token以表明用户身份
     *
     * @param paramMap
     * @return
     */
    @PostMapping("login")
    public WeiboResponse login(@RequestBody Map<String, String> paramMap) {
        Map loginInfo = userService.login(paramMap.get("username"), paramMap.get("password"));
        if (loginInfo == null) return WeiboResponse.failed("用户名或密码错误");
        return WeiboResponse.success(loginInfo);
    }

    @PostMapping("register")
    public WeiboResponse register(@RequestBody Map<String, String> paramMap) {
        User user = userService.register(paramMap.get("username"), paramMap.get("password"), paramMap.get("nickname"));
        if (user == null) return WeiboResponse.failed("注册失败");
        return WeiboResponse.success(user);
    }

    @PostMapping("follow")
    public WeiboResponse follow(@RequestBody Map<String, Long> paramMap) {
        Long bloggerId = paramMap.get("bloggerId");
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long followerId = userDetails.getUser().getId();
        if (userService.follow(followerId, bloggerId)) {
            return WeiboResponse.success();
        } else {
            return WeiboResponse.failed();
        }
    }

    @PostMapping("defollow")
    public WeiboResponse defollow(@RequestBody Map<String, Long> paramMap) {
        Long bloggerId = paramMap.get("bloggerId");
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long followerId = userDetails.getUser().getId();
        if (userService.defollow(followerId, bloggerId)) {
            return WeiboResponse.success();
        } else {
            return WeiboResponse.failed();
        }
    }

    @GetMapping("getUserDetail")
    public WeiboResponse getUserDetail(@RequestParam(value = "userId", required = false) Long userId) {
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long myId = userDetails.getUser().getId();
        if (userId == null) userId = myId;
        UserDetailResult userDetailResult = userService.getUserDetail(myId, userId);
        if (userDetailResult != null) {
            return WeiboResponse.success(userDetailResult);
        } else {
            return WeiboResponse.failed();
        }
    }

}
