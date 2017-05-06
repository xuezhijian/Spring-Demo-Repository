package cn.xuezhijian2.demo.test.auxiliary.service.impl;

import cn.xuezhijian2.demo.test.auxiliary.entity.Student;
import cn.xuezhijian2.demo.test.auxiliary.mapper.StudentMapper;
import cn.xuezhijian2.demo.test.auxiliary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.auxiliary.service.impl
 * User         : zj
 * Date         : 17/4/21
 * Time         : 下午9:13
 * Description  :
 */

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student query(Integer id) {
        return studentMapper.findById(id);
    }
}
