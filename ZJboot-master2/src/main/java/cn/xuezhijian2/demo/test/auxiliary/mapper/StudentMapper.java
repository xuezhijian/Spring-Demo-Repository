package cn.xuezhijian2.demo.test.auxiliary.mapper;

import cn.xuezhijian2.demo.test.auxiliary.entity.Student;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.auxiliary.mapper
 * User         : zj
 * Date         : 17/4/21
 * Time         : 下午9:10
 * Description  :
 */

public interface StudentMapper extends Mapper<Student> {


    Student findById(Integer id);

}
