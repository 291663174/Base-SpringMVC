package wuhen.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author WuHen �����쳣
 */
@ControllerAdvice
public class TestExceptionHandler {

    /**
     * 1. ��@ExceptionHandler ����������п��Լ���Exception���͵Ĳ���,�ò�����Ӧ�������쳣�Ķ���
     * 2. @ExceptionHandler ����������в��ܴ���Map,��ϣ�����쳣��Ϣ����ҳ����,��Ҫʹ��ModelAndView��Ϊ����ֵ
     * 3. @ExceptionHandler ������ǵ��쳣�����ȼ�������
     * 4. @ControllerAdvice: ����ڵ�ǰHandler���Ҳ���@ExceptionHandler ����������ǰ�������ֵ��쳣
     *    ��ȥ�� @ControllerAdvice ��ǵ����в��� @ExceptionHandler ��ǵķ����������쳣��
     */
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception ex){
        System.out.println("Something went wrong: " + ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",ex);
        return modelAndView;
    }

    /*
    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handlerArithmeticException2(Exception ex){
        System.out.println("[Something went wrong]: " + ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",ex);
        return modelAndView;
    }
    */

}
