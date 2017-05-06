package com.xuezhijian.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.xuezhijian.dao.entity
 * Company      : 彼得科技
 * User         : 薛志坚
 * Date         : 17/2/6
 * Time         : 上午10:13
 * Description  : 后台运维管理员信息表映射实体
 */
@Entity
@Table(name = "manager_info")
@NamedQuery(name = "ManagerInfo.findAll", query = "SELECT m FROM ManagerInfo m")
public class ManagerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库id(自增)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * 账号(不能为空)
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * 昵称(不能为空)
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 密码(不能为空)
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 加密密码的盐(不能为空)
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "salt", nullable = false)
    private String salt;

    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "state", nullable = false)
    private Byte state;

    /**
     * 一个管理员具有多个角色
     */
    @ManyToMany(fetch=FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "manager_role_relationship",
            joinColumns = { @JoinColumn(name = "manager_id") },
            inverseJoinColumns ={@JoinColumn(name = "role_id") })
    private List<SysRole> roles;// 一个用户具有多个角色

    public ManagerInfo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    /**
     * 密码盐
     */
    public String getCredentialsSalt(){
        return this.username + this.salt;
    }

    @Override
    public String toString() {
        return "ManagerInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roles=" + roles +
                '}';
    }
}
