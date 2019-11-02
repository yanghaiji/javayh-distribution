package com.javayh.conf.service;

import com.javayh.conf.entity.Logistics;
import com.javayh.conf.vo.LogisticsVO;

import java.util.List;

/**
 * @author Dylan Yang
 * @Description: 物流信息
 * @ProjectName javayh-distribution
 * @date 2019-11-02 23:16
 */
public interface LogisticsService {

    /**
     * @Description 查询物流信息
     * @UserModule: javayh     
     * @author Dylan
     * @date 2019/11/3 0003
     * @param [] 
     * @return java.util.List<com.javayh.conf.entity.Logistics>
     */
    List<LogisticsVO> findListLog();
}
