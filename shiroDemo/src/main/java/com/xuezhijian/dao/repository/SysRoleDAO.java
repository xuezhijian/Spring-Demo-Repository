package com.xuezhijian.dao.repository;

import com.xuezhijian.dao.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.xuezhijian.dao.repository
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/2/13
 * Time         : 下午11:08
 * Description  :
 */

@Repository(value="SysRoleDAO")
public interface SysRoleDAO extends JpaRepository<SysRole,Integer> {

    @Query("from SysRole where role=:role")
    public SysRole findByRole(@Param(value = "role") String role);
}
