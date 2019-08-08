package help1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 日志切面
 *
 * @author Administrator
 */
@Aspect
@Component
public class LogAspect {

    Logger log = LoggerFactory.getLogger(LogAspect.class);

    public LogAspect() {
        log.info("=============初始化AOP===============");
    }

    @Pointcut("execution(public * help1.DarkFuriousApplication.main(..))")
    public void weblog() {
        log.info("=============Pointcut weblog()===============");
    }

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("请求地址 : " + request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("weblog()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("方法执行后...");
    }

    @AfterReturning(returning = "object", pointcut = "weblog()")
    public void doAfterReturning(Object object) {
        log.info("返回值：" + object);
    }
}
