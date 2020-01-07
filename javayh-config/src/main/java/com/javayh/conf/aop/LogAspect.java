package com.javayh.conf.aop;

import com.alibaba.fastjson.JSON;
import com.javayh.conf.util.IdGen;
import com.javayh.conf.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Dylan Yang
 * @Description: LogAcpect
 * @Title: LogAcpect
 * @ProjectName javayh-oauth2
 * @date 2019/6/17 17:44
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut(value = "@annotation(WebLogAspect)")
    public void logAspect() {

    }

    @Around(value = "logAspect()")
    public Object getLog(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        long time = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            log.info("方法执行消耗时间 = " + time);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //方法执行后
            addLogAspect(joinPoint, proceed, time);
        }
        return null;
    }

    private void addLogAspect(ProceedingJoinPoint joinPoint, Object proceed, long time) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        OperationLog operationLog = new OperationLog();
        //消耗的时间
        operationLog.setRunTime(time);
        //返回值
        operationLog.setReturnValue(JSON.toJSONString(proceed.toString()));
        //UID
        operationLog.setId(IdGen.uuid());
        //参数
        operationLog.setArgs(JSON.toJSONString(joinPoint.getArgs()));
        //创建时间
        operationLog.setCreateTime(new Date());
        //类名
        operationLog.setMethod(methodSignature.getDeclaringTypeName() + "." + methodSignature.getName());
        //获取注解
        WebLogAspect annotation = methodSignature.getMethod().getAnnotation(WebLogAspect.class);
        if (annotation != null) {
            //描述
            operationLog.setDescribe(annotation.detail());
            //等级
            operationLog.setLevel(annotation.level());
            //方法类别
            operationLog.setOperationType(annotation.operationType().getValue());
            //操作单元
            operationLog.setOperationUnit(annotation.operationUnit().getValue());
            //操作有货
            operationLog.setUserName(UserUtils.getUserName(request));
        }
        log.info("AOP日志输出为: " + operationLog);
        //进行日志的保存
    }
}

