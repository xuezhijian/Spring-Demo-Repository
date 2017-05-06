package cn.xuezhijian2.core.dao;

import cn.xuezhijian2.core.dto.FlexiPageDto;
import cn.xuezhijian2.core.entity.Entity;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.dao
 * User         : zj
 * Date         : 17/4/15
 * Time         : 下午2:58
 * Description  :
 */

public interface BaseDao<T> {

    /**
     * 根据Id查询实体
     */
    public T getEntityById(final Class<T> cls, final Integer id);

    /**
     * 新增实体
     */
    public void addEntity(final T entity);

    /**
     * 更新实体
     */
    public void updateEntity(final T entity);

    /**
     * 根据Id删除实体
     */
    public void deleteEntityById(final Class<T> cls, final Integer id);

    /**
     * 查询全部
     */
    public List<T> selectAll(Class<T> cls);

    /**
     * 分页查询
     */
    public List<T> selectAllByPage(Class<T> cls,Integer pageNum, Integer pageSize);

    /**
     * 单表模糊查询
     */
    public List<T> findByLike(Example example);

    /**
     * 根据模糊分页查询
     */
    public List<T> findByPage(Example example, FlexiPageDto flexiPageDto);

    /**
     * 单表模糊查询总记录数
     */
    public int findRowCount(Example example);

}
