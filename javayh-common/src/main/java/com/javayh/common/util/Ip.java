package com.javayh.common.util;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

/**
 * @ClassName javayh-distribution → com.javayh.common.util → Ip
 * @Description
 * @Author Dylan
 * @Date 2019/11/12 15:27
 * @Version
 */
@Slf4j
public class Ip {
    /**
     * @Description 获取本地IP
     * @author Dylan
     * @date 2019/11/12
     * @param
     * @return java.lang.String
     */
    public static String getLocalIp(){
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
            String localip=ia.getHostAddress();
            return localip;
        }catch (Exception e){
            log.error("{获取本地IP}" + e.getMessage());
            return "";
        }
    }
}
