package utils;

import java.lang.reflect.Method;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@CustomAnnotation
@javax.interceptor.Interceptor
@Priority(javax.interceptor.Interceptor.Priority.LIBRARY_BEFORE + 100)
public class CustomInterceptor {

    private final ReferenceErrorCode errorCode;

    @Inject
    CustomInterceptor(final ReferenceErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @AroundInvoke
    public Object handlePaginatedResource(final InvocationContext context) throws Exception {
        // Get the method being intercepted
        final Method method = context.getMethod();

        log.info("Intercepting method " + method.getName());

        return context.proceed();
    }
}
