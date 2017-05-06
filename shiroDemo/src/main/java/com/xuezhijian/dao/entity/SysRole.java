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
 * Description  : 角色表映射实体
 */
@Entity
@Table(name = "sys_role")
@NamedQuery(name = "SysRole.findAll", query = "SELECT s FROM SysRole s")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库id(自增)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * 角色(不能为空)
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "role", nullable = false)
    private String role;

    /**
     * 描述
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "description", nullable = false)
    private String description;

    // 用户 - 角色关系定义;一个角色对应多个管理员
    @ManyToMany
    @JoinTable(name="manager_role_relationship",
            joinColumns={@JoinColumn(name="role_id")},
            inverseJoinColumns={@JoinColumn(name="manager_id")})
    private List<ManagerInfo> managerInfos;

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="role_permission_relationship",
            joinColumns={@JoinColumn(name="role_id")},
            inverseJoinColumns={@JoinColumn(name="permission_id")})
    private List<SysPermission> permissions;


    public SysRole(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ManagerInfo> getManagerInfos() {
        return managerInfos;
    }

    public void setManagerInfos(List<ManagerInfo> managerInfos) {
        this.managerInfos = managerInfos;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
