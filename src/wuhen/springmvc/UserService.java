package wuhen.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WuHen
 */
@Service
public class UserService {
    
    //@Autowired
    //private HelloWorld helloWorld;
    
    public UserService(){
        System.out.println("UserService Constructor...");
    }
    
}
