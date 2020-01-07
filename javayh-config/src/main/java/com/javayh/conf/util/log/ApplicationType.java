package com.javayh.conf.util.log;

/**
 * @Description 由于app和web获取认证信息方式不同，增加此枚举类 处理app web不同的判断
 * @author Dylan
 * @date 2019/11/12
 */
public enum ApplicationType {
    //web项目
    WEB,
    //拆分后适合之前功能的app接口
    APP_OLD,
    //拆分后符合新的验证及返回参数的app接口
    APP_BREAK,
    ;
}
