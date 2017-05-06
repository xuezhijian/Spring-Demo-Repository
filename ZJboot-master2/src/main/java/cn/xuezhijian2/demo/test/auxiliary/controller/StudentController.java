package cn.xuezhijian2.demo.test.auxiliary.controller;

import cn.xuezhijian2.demo.test.auxiliary.entity.Student;
import cn.xuezhijian2.demo.test.auxiliary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.auxiliary.controller
 * User         : zj
 * Date         : 17/4/21
 * Time         : 下午9:15
 * Description  :
 */

@Controller
@RequestMapping("/primary/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Student query(@PathVariable Integer id) {
        return studentService.query(id);
    }

}
