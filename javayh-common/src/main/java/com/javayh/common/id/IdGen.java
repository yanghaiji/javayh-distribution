package com.javayh.common.id;

import java.util.UUID;

/**
 * @ClassName javayh-distribution → com.javayh.common.id → IdGen
 * @Description id 生成器
 * @Author Dylan
 * @Date 2019/10/29 17:01
 * @Version
 */
public class IdGen {

    /**
     * @Description jdk uuid
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/10/29
     * @param
     * @return java.lang.String
     */
    public static String UUID(){
        return UUID.randomUUID().toString();
    }


}
