package cn.xuezhijian2.demo.validator.controller;

import cn.xuezhijian2.demo.validator.dto.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.validator.controller
 * User         : zj
 * Date         : 17/4/23
 * Time         : 上午9:40
 * Description  :
 */

@Controller
@RequestMapping(value="/validator")
public class DemoValidatorController {


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "demo";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@Valid Demo demo, BindingResult result, Model model){
        //有错误信息.
        model.addAttribute("demo",demo);
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError  error:list){
                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }

            return "demoFail";
        }
        return "demoSuccess";
    }

}
