package com.javayh.conf.util.log;

import com.alibaba.fastjson.JSON;
import com.javayh.common.id.IdGen;
import com.javayh.common.util.DataResult;
import com.javayh.common.util.Ip;
import com.javayh.conf.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Dylan Yang
 * @Description: 日志输出
 * @Title: LogAspect
 * @ProjectName
 * @date 2019/08/29
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    //2019/10/21 修改 记录时间修改为24小时制 区分上下午
    private static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    HttpServletRequest request;

    @Pointcut(value = "@annotation(com.javayh.conf.util.log.WebLogAspect)")
    public void logAspect(){

    }

    /**
     * @des 切面记录日志方法 如果有异常，继续抛出由ControllerAdvice处理（有日志）
     *  此方法暂时没有记录异常信息，暂定由ControllerAdvice处理
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "logAspect()")
    public Object  getLog(ProceedingJoinPoint joinPoint) throws Throwable{
        Object proceed =null;
        long time = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
//            log.info("方法执行消耗时间 = {}",time);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }finally {
            //方法执行后
            addLogAspect(joinPoint,proceed,time);
        }
    }

    /**
     * @Description 后续操作
     * @author Dylan
     * @date 2019/8/29
     * @param joinPoint
     * @param proceed
     * @param time
     * @return void
     */
    private void addLogAspect(ProceedingJoinPoint joinPoint,Object proceed,long time){
        //判断返回值是否为空
        if(!ObjectUtils.allNotNull()){
            proceed = DataResult.error();
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        OperationLog operationLog = new OperationLog();
        //消耗的时间
        operationLog.setRunTime(time);
        //返回值
        operationLog.setReturnValue(JSON.toJSONString(proceed));
        //UID
        operationLog.setId(IdGen.UUID());
        //参数  防止参数中有不能序列化的对象 而报错
        Object[] args = joinPoint.getArgs();
        List<Object> params = new ArrayList<>();
        for (Object arg : args) {
            if (arg instanceof ServletRequest || arg instanceof ServletResponse || arg instanceof MultipartFile){
                continue;
            }
            params.add(arg);
        }
        operationLog.setArgs(JSON.toJSONString(params));
        //创建时间
        operationLog.setCreateTime(DateFormatUtils.format(new Date(),YMDHMS));
        //类名
        String className = methodSignature.getDeclaringTypeName() + "." + methodSignature.getName();
        operationLog.setMethod(className);
        //获取注解
        WebLogAspect annotation = methodSignature.getMethod().getAnnotation(WebLogAspect.class);
        if(annotation != null){
            //描述
            operationLog.setDescribe(annotation.detail());
            //等级
            operationLog.setLevel(annotation.level());
            //方法类别
            operationLog.setOperationType(annotation.operationType().getValue());
            //操作单元
            operationLog.setOperationUnit(annotation.operationUnit().getValue());
            //调用方ip
            operationLog.setCallerIp(request.getRemoteAddr());
            //本地ip
            operationLog.setLocalHostIp(Ip.getLocalIp());
            //判断appliaction类型 默认web
            if(annotation.applicationType().equals(ApplicationType.WEB)){
                //获取当前用户信息
                String userName = UserUtils.getUserName();
                //操作id
//                operationLog.setUserId(user.getId());
                //操作人
                operationLog.setUserName(userName);
                //拆分后适合修改前的app接口
            }else if(annotation.applicationType().equals(ApplicationType.APP_OLD)){
                //获取当前用户信息
            }else if(annotation.applicationType().equals(ApplicationType.APP_BREAK)){
                //获取当前用户信息
            }

        }
        //进行日志的保存
        log.info(className + " -> 日志输出为: {}",operationLog);
    }
}

