package com.javayh.conf.mapper;

import com.javayh.common.mybatis.mapper.BaseMapper;
import com.javayh.conf.dto.LogisticsInfoSerchDTO;
import com.javayh.conf.entity.Logistics;
import com.javayh.conf.vo.LogisticsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-distribution
 * @date 2019-11-02 23:23
 */
@Mapper
public interface LogisticsMapper {
    /**
     * @Description 查询所以物流信息
     * @UserModule: javayh
     * @author Dylan
     * @date 2019/11/2
     * @param []
     * @return java.util.List<com.javayh.conf.entity.Logistics>
     */
    List<LogisticsVO> findListLog(LogisticsInfoSerchDTO dto);
}
