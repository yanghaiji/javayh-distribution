package com.javayh.conf.util.log;

/**
 * @author Dylan Yang
 * @Description: 日志输出
 * @Title: WebLogAspect
 * @ProjectName exam-root
 * @date 2019/08/29
 */
public enum OperationUnit {
    /**
     * 被操作的单元
     */
    UNKNOWN("unknown"),
    USER("user"),
    EMPLOYEE("employee"),
    Redis("redis");

    private String value;

    OperationUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
