package cn.xuezhijian2.demo.test.primary.controller;


import cn.xuezhijian2.demo.test.primary.entity.UserInfo;
import cn.xuezhijian2.demo.test.primary.mapper.UserInfoMapper;
import cn.xuezhijian2.demo.test.primary.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.controller
 * User         : zj
 * Date         : 17/4/18
 * Time         : 下午9:23
 * Description  :
 */

@RestController
@RequestMapping("/primary/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    UserInfoMapper userInfoMapper;


    @RequestMapping(value = "/test",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void getAll() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo = userInfoMapper.selectOne(userInfo);
        System.out.println(userInfo);
    }


}
