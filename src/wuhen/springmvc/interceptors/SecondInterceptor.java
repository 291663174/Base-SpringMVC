package wuhen.springmvc.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WuHen  拦截器2 测试优先级，在拦截器 1 的基础上修改了提示语
 */
public class SecondInterceptor implements HandlerInterceptor {

    /**
     * 该方法在目标方法之前被调用。
     * 若返回值为true，则继续调用后续的拦截器和目标方法
     * 若返回值为false，则不会再调用后续的拦截器和目标方法
     *
     * 可以考虑做权限，日志，事务等
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
        System.out.println("[SecondInterceptor] preHandle");
        return true;
    }

    /**
     * 调用目标方法之后，但渲染视图之前
     *
     * 可以对请求域中的属性或者视图做出修改
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object object, ModelAndView modelAndView) throws Exception {
        System.out.println("[SecondInterceptor] postHandle");
    }

    /**
     * 渲染视图之后被调用。释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object object, Exception e) throws Exception {
        System.out.println("[SecondInterceptor] afterCompletion");
    }
}
