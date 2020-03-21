package org.azhang.weibo.utils.response;

public class WeiboResponse<T> {
    private long code;
    private String message;
    private T data;

    private WeiboResponse(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> WeiboResponse<T> success(T data) {
        return new WeiboResponse<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> WeiboResponse<T> success(T data, String message) {
        return new WeiboResponse<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> WeiboResponse<T> success() {
        return new WeiboResponse<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> WeiboResponse<T> failed(IErrorCode errorCode) {
        return new WeiboResponse<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> WeiboResponse<T> failed(String message) {
        return new WeiboResponse<T>(ResponseCode.FAILED.getCode(), message, null);
    }

    public static <T> WeiboResponse<T> failed() {
        return new WeiboResponse<T>(ResponseCode.FAILED.getCode(), ResponseCode.FAILED.getMessage(), null);
    }

    public static <T> WeiboResponse<T> forbidden(T data) {
        return new WeiboResponse<T>(ResponseCode.FORBIDDEN.getCode(), ResponseCode.FORBIDDEN.getMessage(), data);
    }

    public static <T> WeiboResponse<T> unauthorized(T data){
        return new WeiboResponse<T>(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
