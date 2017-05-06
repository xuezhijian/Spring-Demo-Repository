package cn.xuezhijian2.core.dao.impl;

import cn.xuezhijian2.core.annotation.MapperClass;
import cn.xuezhijian2.core.dao.BaseDao;
import cn.xuezhijian2.core.dto.FlexiPageDto;
import cn.xuezhijian2.core.entity.Entity;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.dao.impl
 * User         : zj
 * Date         : 17/4/21
 * Time         : 上午3:00
 * Description  :
 */

@Repository("myBatisAuxiliaryBaseDao")
@SuppressWarnings("unchecked")
public class MyBatisAuxiliaryBaseDaoImpl <T> implements BaseDao<T> {

    @Resource
    @Qualifier("auxiliarySqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @SuppressWarnings("rawtypes")
    public <M extends Mapper<T>> M getMapper(Class cls){
        MapperClass mapperClass = (MapperClass) cls.getAnnotation(MapperClass.class);
        if(null == mapperClass){
            throw new RuntimeException("没有注解MapperClass");
        }
        return (M) getSqlSession().getMapper(mapperClass.value());
    }

    @Override
    public T getEntityById(Class<T> cls, Integer id) {
        return this.getMapper(cls).selectByPrimaryKey(id);
    }

    @Override
    public void addEntity(T entity) {
        this.getMapper(entity.getClass()).insert(entity);
    }

    @Override
    public void updateEntity(T entity) {
        this.getMapper(entity.getClass()).updateByPrimaryKey(entity);
    }

    @Override
    public void deleteEntityById(Class<T> cls, Integer id) {
        this.getMapper(cls).deleteByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll(Class<T> cls) {
        return this.getMapper(cls).selectAll();
    }

    @Override
    public List<T> selectAllByPage(Class<T> cls, Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return this.getMapper(cls).selectAll();
    }

    @Override
    public List<T> findByLike(Example example) {
        return this.getMapper(example.getEntityClass()).selectByExample(example);
    }

    @Override
    public List<T> findByPage(Example example, FlexiPageDto flexiPageDto) {
        RowBounds rowBounds = new RowBounds(flexiPageDto.getOffset(), flexiPageDto.getRp());
        return this.getMapper(example.getEntityClass()).selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public int findRowCount(Example example) {
        return this.getMapper(example.getEntityClass()).selectCountByExample(example);
    }

    public SqlSession getSqlSession(){
        if (null == sqlSession){
            synchronized (MyBatisPrimaryBaseDaoImpl.class) {
                this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
            }
        }
        return this.sqlSession;
    }

}
