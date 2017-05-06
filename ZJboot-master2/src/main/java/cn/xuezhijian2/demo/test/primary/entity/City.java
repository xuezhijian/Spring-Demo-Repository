package cn.xuezhijian2.demo.test.primary.entity;

import cn.xuezhijian2.core.annotation.MapperClass;
import cn.xuezhijian2.core.entity.BaseEntity;
import cn.xuezhijian2.demo.test.primary.mapper.CityMapper;


/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.entity
 * User         : zj
 * Date         : 17/4/18
 * Time         : 下午8:55
 * Description  :
 */

@MapperClass(CityMapper.class)
public class City extends BaseEntity {

    private String name;

    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
