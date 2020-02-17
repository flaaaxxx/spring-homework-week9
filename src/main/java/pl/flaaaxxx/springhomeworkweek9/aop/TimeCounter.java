package pl.flaaaxxx.springhomeworkweek9.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.flaaaxxx.springhomeworkweek9.Start;

@Aspect
@Component
public class TimeCounter {

    @Around("@annotation(TimeAspect)")
    public void count(ProceedingJoinPoint joinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        joinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long time = end - start;
        System.out.println("Time: " + time);
    }

}
