package cn.xuezhijian2.demo.test.primary.service.impl;

import cn.xuezhijian2.demo.test.primary.entity.Country;
import cn.xuezhijian2.demo.test.primary.mapper.CountryMapper;
import cn.xuezhijian2.demo.test.primary.service.CountryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.service.primary.impl
 * User         : zj
 * Date         : 17/4/21
 * Time         : 下午12:13
 * Description  :
 */

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    CountryMapper countryMapper;

    @Override
    public List<Country> getAllByPage(Integer pageNum, Integer pageSize) {

        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return countryMapper.selectAll();
        //return countryMapper.findAll();
    }

    @Override
    public void add(Country country) {
        countryMapper.insert(country);
    }

    @Override
    public void delete(Integer id) {
        countryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Country query(Integer id) {
        return countryMapper.findById(id);
        //selectByPrimaryKey方法有问题。
        //return countryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Country country) {
        countryMapper.updateByPrimaryKey(country);
    }
}
