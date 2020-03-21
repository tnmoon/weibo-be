package org.azhang.weibo.service.impl;

import com.qiniu.util.Auth;
import org.azhang.weibo.service.OtherService;
import org.azhang.weibo.utils.response.WeiboResponse;
import org.springframework.stereotype.Component;

@Component
public class OtherServiceImpl implements OtherService {

    private String accessKey = "zhWb4MzsO1XyNhoxvaFVWS9UBg5mBNOk-WDtdeP8";
    private String secretKey = "0g3OM6yu3rL7zVl87hLr3tV8dBrLT86gXF0dcYGn";
    private String bucket = "tnmoon-pictures";

    @Override
    public String getUploadPictureToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
}
