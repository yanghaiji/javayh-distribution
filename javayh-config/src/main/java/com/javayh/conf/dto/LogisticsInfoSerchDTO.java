package com.javayh.conf.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName javayh-distribution → com.javayh.conf.dto → LogisticsInfoSerchDTO
 * @Description 物流搜索
 * @Author Dylan
 * @Date 2019/11/4 13:27
 * @Version
 */
@Data
public class LogisticsInfoSerchDTO implements Serializable {
    private String addresseeName;
    private String senderName;
    private String emsStatus;
    private String retreatStatus;
}
