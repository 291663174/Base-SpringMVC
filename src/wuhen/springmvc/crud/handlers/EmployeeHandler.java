package wuhen.springmvc.crud.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import wuhen.springmvc.crud.dao.Employee;
import wuhen.springmvc.enties.DepartmentDao;
import wuhen.springmvc.enties.EmployeeDao;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author WuHen
 * jsp内的增删改查等基本操作（未涉及数据库）
 */
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id,
                            Map<String,Object> map){
        if(id != null){
            map.put("employee",employeeDao.get(id));
        }
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String  update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "input";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee, BindingResult bindingResult,
                       Map<String,Object> map){
        System.out.println("save: " + employee);
        if (bindingResult.getErrorCount() > 0 ){
            System.out.println("出错了！");

            for(FieldError fieldError:bindingResult.getFieldErrors()){
                System.out.println(fieldError.getField() + ":" +fieldError.getDefaultMessage());
            }

            //若验证出错，则转向定制的页面
            map.put("departments",departmentDao.getDepartments());
            return "input";

        }
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "emp",method = RequestMethod.GET)
    public String input(Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        //list.jsp内的employees,命名规范
        map.put("employees",employeeDao.getAll());
        return "list";
    }

    /*
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("lastName");
    }
    */

}
