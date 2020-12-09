package wuhen.springmvc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wuhen.springmvc.crud.dao.Employee;
import wuhen.springmvc.enties.EmployeeDao;
import wuhen.springmvc.interceptors.UserNameNotMatchPasswordException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * @author WuHen
 * 测试类
 */
@Controller
public class SpringMvcTest {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     *  出现异常打印到页面上
     */
    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
        String [] vals = new String[10];
        System.out.println(vals[i]);
        return "success";
    }

    /**
     * 处理特殊异常，提示异常页面
     */
    @RequestMapping(value = "/testDefaultHandlerExceptionResolver",method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver(){
        System.out.println("testDefaultHandlerExceptionResolver...");
        return "success";
    }

    /**
     *  @ResponseStatus(reason = "测试",value = HttpStatus.NOT_FOUND)
     */
    @RequestMapping("/testResponserStatusExceptionResolver")
    public String testResponserStatusExceptionResolver(@RequestParam("i") int i){
        if (i == 13){
            throw new UserNameNotMatchPasswordException();
        }
        System.out.println("testResponserStatusExceptionResolver...");
        return "success";
    }

    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
        System.out.println("result: " + (10 / i) );
        return "success";
    }

    /**
     * 文件上传
     */
    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc: " + desc);
        System.out.println("OriginalFilename: " + file.getOriginalFilename());
        System.out.println("InputStream: " + file.getInputStream());
        return "success";
    }

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String value = messageSource.getMessage("i18n.user",null ,locale);
        System.out.println(value);
        return "i18n";
    }

    /**
     * 文件下载
     */
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession httpSession) throws IOException {
        byte [] body = null;
        ServletContext servletContext = httpSession.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/files/aaa.txt");
        body = new byte[inputStream.available()];
        inputStream.read(body);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment;filename=aaa.txt" );

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body,httpHeaders,statusCode);
        return responseEntity;
    }

    /**
     * 获取英文文件的内容，使其在控制台输出
     */
    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "helloworld! " + new Date();
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    /**
     *  格式为：AAaa-Aa@qq.com-0-101
     */
    @RequestMapping("/testConversionServiceConverter")
    public String testConverter(@RequestParam("employee")Employee employee){
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        System.out.println("save: " + employee);
        return "redirect:/emps";
    }

}
