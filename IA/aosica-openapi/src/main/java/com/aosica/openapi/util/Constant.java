package com.aosica.openapi.util;


/**
 * 公共常量定义
 */
public interface Constant {

    /**
     * 操作失败 状态码
     */
    int FAIL = 500 ;


    /**
     * 操作成功 状态码
     */
    int SUCCESS  = 200 ;

    /**
     * 查询数据为空
     */
    int EMPTY  = 201 ;
    /**
     * 登录失败
     */
    int LOGIN_FAIL_UN = 500 ;
    String LOGIN_FAIL_UN_MESG = "登录失败" ;

    int LOGIN_FAIL = 500 ;

    String LOGIN_FAIL_MESG = "登录失败，用户名/密码错误" ;


     /**
      * 没有登录。
      */
    int UNAUTHORIZED = 401 ;

    String UNAUTHORIZED_MESG = "用户没有登录，无权该问该资源页面。"  ;


    /**
     * 没有权限。
     */
    int UNPERMISSION = 402 ;

    String UNPERMISSION_MESG = "没有相应权限，无权该问该资源页面。"  ;


    String WIN = "WIN" ;

    String UNIX = "UNIX" ;

    String REQUEST_FAIL = "请求失败" ;

    String PARAMETER_ERROR="参数错误";
    String REQUEST_QUERY_DATA_FAIL = "请求查询数据失败" ;

    String QUERY_DATA_FAIL = "查询数据失败" ;

    String QUERY_DATA_EMPTY = "查询数据为空" ;

    String DELETE__DATA_FAIL="删除数据失败";

    String UPDATE__DATA_FAIL="更新数据失败";

    String ADD_DATA_FAIL="新增数据失败";


    String DELETE__DATA_SUCCESS="删除数据成功";

    String UPDATE__DATA_SUCCESS="更新数据成功";

    String ADD_DATA_SUCCESS="新增数据成功";
    String CREATE_ROLE_FAIL = "创建角色失败" ;
    String CREATE_ROLE_SUCCESS = "创建角色成功" ;


    String CREATE_USER_FAIL = "创建用户失败" ;
    String CREATE_USER_SUCCESS = "创建用户成功" ;


    String CREATE_PERMISSION_FAIL = "创建权限失败" ;
    String CREATE_PERMISSION_SUCCESS = "创建权限成功" ;

    String INPUT_CONTENT_ILLEGAL="不可输入特殊的字符" ;


    String ROLE_NAME_NOT_NULL = "角色名称不能为空" ;


    String PARAM_DIGEST = "digest";

    String PARAM_USERNAME = "username";

    String STATELESS_LOGIN_TOKEN =  "stateless-login-token";

    String STATELESS_ACCOUNT = "stateless-account";

    String CURRENT_USER = "current_user";

    String CHARSET_UTF8 = "UTF-8" ;

    String APPLICATION_JSON = "application/json" ;

    String XMLHTTPREQUEST  = "XMLHttpRequest" ;

    String X_REQUESTED_WITH = "X-Requested-With" ;

    String THE_DATA_IS_LOCKED = "该数据已被锁定, 请稍后修改";

    String THE_DATA_ALREADY_EXISTS = "数据已经存在";

    String PARAMETER_IS_NULL = "参数为空";
}
