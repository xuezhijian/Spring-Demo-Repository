package cn.xuezhijian2.demo.test.primary.mapper;

import cn.xuezhijian2.demo.test.primary.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.mapper
 * User         : zj
 * Date         : 17/4/18
 * Time         : 下午8:56
 * Description  :
 */

public interface UserInfoMapper extends Mapper<UserInfo> {


    @Results(id = "userInfoResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username", id = true),
            @Result(property = "password", column = "password", id = true)
    })
    @Select("SELECT * FROM user_info WHERE username = #{username}")
    UserInfo findByUsername(@Param("username") String name, String username);

    UserInfo findByPassword(String password);

}
