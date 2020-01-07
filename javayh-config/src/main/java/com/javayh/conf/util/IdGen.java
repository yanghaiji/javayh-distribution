package com.javayh.conf.util;

import java.util.UUID;

/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-distribution
 * @date 2020-01-07 20:15
 */
public class IdGen {

    public static String uuid(){
        return UUID.randomUUID().toString();
    }
}
