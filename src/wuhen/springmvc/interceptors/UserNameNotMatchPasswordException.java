package wuhen.springmvc.interceptors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author WuHen 自定义异常
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户名和密码不匹配！")
public class UserNameNotMatchPasswordException extends RuntimeException{

    private static final long serialVersionUID = 1L;

}
