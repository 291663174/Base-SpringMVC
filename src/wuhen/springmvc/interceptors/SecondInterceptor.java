package wuhen.springmvc.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WuHen  ������2 �������ȼ����������� 1 �Ļ������޸�����ʾ��
 */
public class SecondInterceptor implements HandlerInterceptor {

    /**
     * �÷�����Ŀ�귽��֮ǰ�����á�
     * ������ֵΪtrue����������ú�������������Ŀ�귽��
     * ������ֵΪfalse���򲻻��ٵ��ú�������������Ŀ�귽��
     *
     * ���Կ�����Ȩ�ޣ���־�������
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
        System.out.println("[SecondInterceptor] preHandle");
        return true;
    }

    /**
     * ����Ŀ�귽��֮�󣬵���Ⱦ��ͼ֮ǰ
     *
     * ���Զ��������е����Ի�����ͼ�����޸�
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object object, ModelAndView modelAndView) throws Exception {
        System.out.println("[SecondInterceptor] postHandle");
    }

    /**
     * ��Ⱦ��ͼ֮�󱻵��á��ͷ���Դ
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object object, Exception e) throws Exception {
        System.out.println("[SecondInterceptor] afterCompletion");
    }
}
