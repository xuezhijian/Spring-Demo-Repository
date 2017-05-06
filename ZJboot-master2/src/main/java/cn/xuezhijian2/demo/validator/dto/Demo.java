package cn.xuezhijian2.demo.validator.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.validator.dto
 * User         : zj
 * Date         : 17/4/23
 * Time         : 上午9:41
 * Description  :
 */

/**
 * @null           验证对象是否为空
 * @notnull     验证对象是否为非空
 * @asserttrue       验证 boolean 对象是否为 true
 * @assertfalse      验证 boolean 对象是否为 false
 * @min           验证 number 和 string 对象是否大等于指定的值
 * @max           验证 number 和 string 对象是否小等于指定的值
 * @decimalmin    验证 number 和 string 对象是否大等于指定的值，小数存在精度
 * @decimalmax    验证 number 和 string 对象是否小等于指定的值，小数存在精度
 * @size           验证对象（array,collection,map,string）长度是否在给定的范围之内
 * @digits       验证 number 和 string 的构成是否合法
 * @past           验证 date 和 calendar 对象是否在当前时间之前
 * @future       验证 date 和 calendar 对象是否在当前时间之后
 * @pattern     验证 string 对象是否符合正则表达式的规则
 * @Email     验证邮箱
 */

public class Demo {

    private long id;

    @NotEmpty(message="姓名不能为空")
    private String name;

    @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Demo [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

}
