package wuhen.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author WuHen 测试异常
 */
@ControllerAdvice
public class TestExceptionHandler {

    /**
     * 1. 在@ExceptionHandler 方法的入参中可以加入Exception类型的参数,该参数对应发生的异常的对象
     * 2. @ExceptionHandler 方法的入参中不能传入Map,若希望把异常信息传到页面上,需要使用ModelAndView作为返回值
     * 3. @ExceptionHandler 方法标记的异常有优先级的问题
     * 4. @ControllerAdvice: 如果在当前Handler中找不到@ExceptionHandler 方法来处理当前方法出现的异常
     *    则去将 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常。
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
