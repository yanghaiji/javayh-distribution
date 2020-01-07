package com.javayh.conf.util.log;

import lombok.Data;

/**
 * @author Dylan Yang
 * @Description: 日志输出
 * @Title: WebLogAspect
 * @ProjectName exam-root
 * @date 2019/08/29
 */
@Data
public class OperationLog {

    /**
     * 唯一id
     */
    private String id;

    /*
     * 调用时间
     */
    private String createTime;
    /**
     * 日志等级
     */
    private Integer level;
    /**
     * 被操作的对象
     */
    private String operationUnit;
    /**
     * 方法名
     */
    private String method;
    /**
     * 参数
     */
    private String args;
    /**
     * 操作人id
     */
    private String userId;
    /**
     * 操作人
     */
    private String userName;
    /**
     * 日志描述
     */
    private String describe;
    /**
     * 操作类型
     */
    private String operationType;
    /**
     * 方法运行时间
     */
    private Long runTime;
    /**
     * 方法返回值
     */
    private String returnValue;
    /**
     * 调用方ip
     */
    private String callerIp;
    /**
     * 本地ip
     */
    private String localHostIp;
}


