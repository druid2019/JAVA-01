package com.jinjie.dtdli;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/18 19:34
 * @Description ${description}
 */
public class LogHandler implements InvocationHandler {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Object delegate;
    public LogHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        try {
            logger.info("method stats..." + method);
            o = method.invoke(delegate, args);
            logger.info("method ends..." + method);
        } catch (Exception e) {
            logger.info("Exeception happens...");
            // exception handling
        }
        return o;
    }
}
