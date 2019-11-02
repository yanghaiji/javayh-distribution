package com.javayh.conf.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dylan Yang
 * @Description: 物流
 * @ProjectName javayh-distribution
 * @date 2019-11-02 23:18
 */
@Data
public class Logistics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id private int id;
    private String addresseeName;
    private String addressee;
    private int addresseePhone;
    private String senderName;
    private String senderAdd;
    private int emsStatus;
    private int retreatStatus;
    private String retreatInfo;
    private Date createDate;
    private Date updateDate;
    private String createBy;

}
