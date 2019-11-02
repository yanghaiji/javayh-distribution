package com.javayh.conf.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-distribution
 * @date 2019-11-02 22:03
 */
@Data
public class UserModfiyPwdDTO implements Serializable {
    private int id;
    private String lodPwd;
    private String newPwd;
    private Date updateDate;
}
