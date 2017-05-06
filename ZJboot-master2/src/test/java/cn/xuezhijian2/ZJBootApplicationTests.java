package cn.xuezhijian2;

import cn.xuezhijian2.demo.test.primary.entity.Country;
import cn.xuezhijian2.demo.test.primary.entity.UserInfo;
import cn.xuezhijian2.demo.test.primary.mapper.CountryMapper;
import cn.xuezhijian2.demo.test.primary.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2
 * User         : zj
 * Date         : 17/4/19
 * Time         : 下午3:39
 * Description  :
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZJBootApplicationTests {

    @Autowired
    CountryMapper countryMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    public void contextLoads() {
//        Country country = countryMapper.selectByPrimaryKey(186);
//        System.out.println(country);

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);

        System.out.println(userInfo);
    }


}
