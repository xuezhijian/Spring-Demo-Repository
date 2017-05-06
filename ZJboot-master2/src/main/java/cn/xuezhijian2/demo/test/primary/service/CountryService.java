package cn.xuezhijian2.demo.test.primary.service;

import cn.xuezhijian2.demo.test.primary.entity.Country;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.service.primary
 * User         : zj
 * Date         : 17/4/21
 * Time         : 下午12:11
 * Description  :
 */

public interface CountryService {

    List<Country> getAllByPage(Integer pageNum, Integer pageSize);

    void add(Country country);

    void delete(Integer id);

    Country query(Integer id);

    void update(Country country);

}
