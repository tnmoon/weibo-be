package org.azhang.weibo.controller;

import org.azhang.weibo.bo.AdminUserDetails;
import org.azhang.weibo.dto.UserDetailResult;
import org.azhang.weibo.service.SearchService;
import org.azhang.weibo.utils.response.WeiboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("user")
    public WeiboResponse searchUser(@RequestParam("keyword") String keyword){
        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long myId = userDetails.getUser().getId();
        UserDetailResult userDetailResult = searchService.searchUser(myId, keyword);
        return WeiboResponse.success(userDetailResult);
    }

}
