package com.javayh.api.serviceimpl;

import com.javayh.common.mybatis.service.BaseService;
import com.javayh.conf.dto.LogisticsInfoSerchDTO;
import com.javayh.conf.entity.Logistics;
import com.javayh.conf.mapper.LogisticsMapper;
import com.javayh.conf.service.LogisticsService;
import com.javayh.conf.vo.LogisticsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dylan Yang
 * @Description: 物流信息
 * @ProjectName javayh-distribution
 * @date 2019-11-02 23:16
 */
@Slf4j
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    private LogisticsMapper logisticsMapper;
    
    /**
     * @Description 查询物流信息
     * @UserModule: javayh     
     * @author Dylan
     * @date 2019/11/3 0003
     * @param [] 
     * @return java.util.List<com.javayh.conf.entity.Logistics>
     */
    @Override
    public List<LogisticsVO> findListLog(LogisticsInfoSerchDTO dto) {
        List<LogisticsVO> listLog = logisticsMapper.findListLog(dto);
        return listLog;
    }
}
