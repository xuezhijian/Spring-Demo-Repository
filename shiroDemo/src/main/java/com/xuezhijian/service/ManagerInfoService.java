package com.xuezhijian.service;

import com.xuezhijian.dao.entity.ManagerInfo;
import com.xuezhijian.dao.repository.ManagerInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.xuezhijian.service
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/2/13
 * Time         : 下午11:09
 * Description  :
 */

@Service
public class ManagerInfoService {

    @Autowired
    ManagerInfoDAO managerInfoDAO;


    public ManagerInfo findByUsername(String username) {
        return managerInfoDAO.findByUsername(username);
    }


}
