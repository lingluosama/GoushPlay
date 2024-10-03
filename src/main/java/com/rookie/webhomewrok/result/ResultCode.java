package com.rookie.webhomewrok.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(1, "success"),
    FAIL(0, "failed"),
    /* parameter error：10001-19999 */
    PARAM_IS_INVALID(10001, "param is invalid"),
    PARAM_IS_BLANK(10002, "parma is blank"),
    PARAM_TYPE_BIND_ERROR(10003, "param type bind error"),
    PARAM_NOT_COMPLETE(10004, "param not complete"),

    /* user error：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "user not logged in"),
    USER_LOGIN_ERROR(20002, "user login error"),
    USER_NOT_EXIST(20003, "user not exist"),
    USER_HAS_EXISTED(20004, "user has existed"),

    /* system error：40001-49999 */
    FILE_MAX_SIZE_OVERFLOW(40003, "file size overflow"),
    FILE_ACCEPT_NOT_SUPPORT(40004, "file type not support"),

    /* data error：50001-599999 */
    DATA_NOT_FOUND(50001, "data not found"),
    DATA_IS_WRONG(50002, "data is wrong"),
    DATA_ALREADY_EXISTED(50003, "data already existed"),

    /* permission error：70001-79999 */
    //PERMISSION_UNAUTHENTICATED(70001, "此操作需要登陆系统！"),
    PERMISSION_UNAUTHENTICATED(70001, "need to log in"),
    //PERMISSION_UNAUTHORIZED(70002, "权限不足，无权操作！"),
    PERMISSION_UNAUTHORIZED(70002, "no permission to operate"),
    //PERMISSION_EXPIRE(70003, "登录状态过期！"),
    PERMISSION_EXPIRE(70003, "login status expired"),
    //PERMISSION_TOKEN_EXPIRED(70004, "token已过期"),
    PERMISSION_TOKEN_EXPIRED(70004, "token expired"),
    //PERMISSION_LIMIT(70005, "访问次数受限制"),
    PERMISSION_LIMIT(70005, "access limited"),
    //PERMISSION_TOKEN_INVALID(70006, "无效token"),
    PERMISSION_TOKEN_INVALID(70006, "invalid token");

    private final Integer code;
    private final String msg;
}
