package cn.xuezhijian2.demo.email.controller;

import cn.xuezhijian2.demo.email.service.EmailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.email.controller
 * User         : zj
 * Date         : 17/4/19
 * Time         : 上午11:37
 * Description  :
 */

@RestController
@RequestMapping(value="/email")
public class DemoEmailController {

    @Resource
    private EmailService emailService;

    /**
     * 测试邮件发送
     */
    @RequestMapping(value = "/getTestDemoEmail", method = RequestMethod.GET)
    public void getEntityById() throws Exception {
        String sendTo = "1265400024@qq.com";
        String titel = "测试邮件标题";
        String content = "测试邮件内容";
        emailService.sendSimpleMail(sendTo, titel, content);
        //return ResultDataDto.addSuccess();
    }

}
