package com.javayh.api.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javayh.conf.dto.LogisticsInfoSerchDTO;
import com.javayh.conf.entity.Logistics;
import com.javayh.conf.entity.SysUser;
import com.javayh.conf.service.LogisticsService;
import com.javayh.conf.vo.LogisticsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Dylan Yang
 * @Description: 物流信息
 * @ProjectName javayh-distribution
 * @date 2019-11-02 23:13
 */
@Slf4j
@Controller
@RequestMapping(value = "/javayh/")
public class LogisticsController {

    @Autowired
    private LogisticsService logisticsService;
    /**
     * @Description 查询用户信息  后期需要在改
     * @UserModule: javayh-distribution
     * @author Dylan
     * @date 2019/10/31
     * @param pn
     * @param model
     * @return java.lang.String
     */
    @GetMapping("/logistics_info")
    public String getAllUser(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             LogisticsInfoSerchDTO dto, Model model) {
        PageHelper.startPage(pn, 4);
        List<LogisticsVO> listLog = logisticsService.findListLog(dto);
        PageInfo<LogisticsVO> page = new PageInfo<>(listLog, 3);
        model.addAttribute("pageInfo", page);
        return "logistics/logisticsInfo";
    }
}
