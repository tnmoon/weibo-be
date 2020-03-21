package org.azhang.weibo.controller;

import com.qiniu.util.Auth;
import org.azhang.weibo.service.OtherService;
import org.azhang.weibo.utils.response.WeiboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController {

    @Autowired
    OtherService otherService;

    @GetMapping("getUploadPictureToken")
    public WeiboResponse getUploadPictureToken() {
        return WeiboResponse.success(otherService.getUploadPictureToken());
    }
}
