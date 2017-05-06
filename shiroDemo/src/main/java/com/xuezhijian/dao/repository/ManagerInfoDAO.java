package com.xuezhijian.dao.repository;

import com.xuezhijian.dao.entity.ManagerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.xuezhijian.dao.repository
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/2/13
 * Time         : 下午11:07
 * Description  :
 */

@Repository(value="ManagerInfoDAO")
public interface ManagerInfoDAO extends JpaRepository<ManagerInfo,Integer>,
        JpaSpecificationExecutor<ManagerInfo> {

    @Query("from ManagerInfo where username=:username")
    public ManagerInfo findByUsername(@Param(value = "username") String username);

}
