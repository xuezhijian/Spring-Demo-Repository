package cn.xuezhijian2.demo.test.primary.entity;

import cn.xuezhijian2.core.annotation.MapperClass;
import cn.xuezhijian2.core.entity.BaseEntity;
import cn.xuezhijian2.demo.test.primary.mapper.CountryMapper;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.entity
 * User         : zj
 * Date         : 17/4/18
 * Time         : 下午8:54
 * Description  :
 */


@MapperClass(CountryMapper.class)
public class Country extends BaseEntity {

    /**
     * 名称
     */
    private String countryname;

    /**
     * 代码
     */
    private String countrycode;


    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryname='" + countryname + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }
}
