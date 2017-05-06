package com.xuezhijian;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.xuezhijian
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/2/14
 * Time         : 上午12:38
 * Description  :
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {


    //@Test
    public void contextLoads() {
//加密方式
        String algorithmName = "md5";
        //盐（用户名+随机数）
        String salt1 = "qq746753491";
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        //原密码
        String password = "123456";
        //散列的次数
        int hashIterations = 2;
        //进行散列获取匹配值
        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);

        String encodedPassword = hash.toHex();

        System.out.println("这个是保存进数据库的密码:"+encodedPassword);

        System.out.println("这个是保存进数据库的盐:"+salt2);
    }



}
