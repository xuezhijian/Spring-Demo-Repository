package cn.xuezhijian2.demo.test.primary.mapper;

import cn.xuezhijian2.demo.test.primary.entity.Country;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.mapper
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/4/18
 * Time         : 下午8:57
 * Description  :
 */

public interface CountryMapper extends Mapper<Country> {


    Country findById(Integer id);

    List<Country> findAll();

}
