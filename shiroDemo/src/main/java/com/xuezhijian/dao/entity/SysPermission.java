package com.xuezhijian.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.bidekeji.hibernate.entity.shiro
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/2/6
 * Time         : 上午10:13
 * Description  : 权限表映射实体
 */
@Entity
@Table(name = "sys_permission")
@NamedQuery(name = "SysPermission.findAll", query = "SELECT s FROM SysPermission s")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库id(自增)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * 权限(不能为空)
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "permission", nullable = false)
    private String permission;


    @ManyToMany
    @JoinTable(name="role_permission_relationship",
            joinColumns={@JoinColumn(name="permission_id")},
            inverseJoinColumns={@JoinColumn(name="role_id")})
    private List<SysRole> roles;

    public SysPermission(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<SysRole> getRoles() {
        return roles;
    }
    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

}
