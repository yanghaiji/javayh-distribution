package com.javayh.conf.util.log;

/**
 * @author Dylan Yang
 * @Description: 日志输出
 * @Title: WebLogAspect
 * @ProjectName exam-root
 * @date 2019/08/29
 */
public enum  OperationType {
    /**
     * 操作类型
     */
    UNKNOWN("unknown"),
    DELETE("delete"),
    SELECT("select"),
    UPDATE("update"),
    INSERT("insert"),
    LOGIN("login"),
    LOGOUT("mylogout"),
    PAGE("页面跳转")
    ;


    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationType(String s) {
        this.value = s;
    }
}

