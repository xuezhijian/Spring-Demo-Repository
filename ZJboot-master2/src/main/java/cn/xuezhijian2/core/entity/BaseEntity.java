package cn.xuezhijian2.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.entity
 * User         : zj
 * Date         : 17/4/15
 * Time         : 下午2:55
 * Description  :
 */

public class BaseEntity extends Entity{

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient//可以忽略字段,添加该注解的字段不会作为表字段使用
    private Integer page = 1;

    @Transient
    private Integer rows = 2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

}
