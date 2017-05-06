package cn.xuezhijian2.demo.test.auxiliary.entity;

import cn.xuezhijian2.core.entity.BaseEntity;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.auxiliary.entity
 * User         : zj
 * Date         : 17/4/21
 * Time         : 下午9:10
 * Description  :
 */

public class Student extends BaseEntity {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
