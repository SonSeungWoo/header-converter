package me.seungwoo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StopWatch;

import java.util.UUID;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 15:30
 */
@Slf4j
@Aspect
@Configuration
public class CustomAspect {

    @Before("execution(* me.seungwoo.*Controller.* (..)) && args(httpHeaders, ..)")
    public void doBefore(HttpHeaders httpHeaders) {
        log.info("trId : {}", httpHeaders.get("trId"));
        httpHeaders.set("trId", UUID.randomUUID().toString().replace("-", ""));
    }

    @Around("execution(* me.seungwoo.*Controller.* (..)) && args(httpHeaders, ..)")
    public Object doAround(ProceedingJoinPoint joinPoint, HttpHeaders httpHeaders) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start();
        // 대상 메서드 실행 전 trId 없으면 생성
        Object result = joinPoint.proceed();

        sw.stop();
        Long total = sw.getTotalTimeMillis();
        httpHeaders.set("isSuccess", "true");
        // 대상 메서드 실행 후 response 변경

        return result;
    }

    @AfterThrowing(value = "execution(* me.seungwoo.*Controller.* (..)) && args(httpHeaders, ..)", throwing="e")
    public void doAfterThrowing(HttpHeaders httpHeaders, Throwable e) {
        log.error("doAfterThrowing called: {}", e);
    }
}
