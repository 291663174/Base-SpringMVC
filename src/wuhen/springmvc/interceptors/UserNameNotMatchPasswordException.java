package wuhen.springmvc.interceptors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author WuHen �Զ����쳣
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "�û��������벻ƥ�䣡")
public class UserNameNotMatchPasswordException extends RuntimeException{

    private static final long serialVersionUID = 1L;

}
