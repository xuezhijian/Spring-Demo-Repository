package cn.xuezhijian2.demo.velocity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.velocity.controller
 * User         : zj
 * Date         : 17/4/19
 * Time         : 下午10:26
 * Description  :
 */

@Controller
@RequestMapping(value="/velocity")
public class DemoVelocityController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        modelMap.put("name","小明");
        modelMap.put("age",11);
        return "hello" ;
    }

}
