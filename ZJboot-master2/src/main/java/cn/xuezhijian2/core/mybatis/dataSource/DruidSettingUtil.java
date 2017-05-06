package cn.xuezhijian2.core.mybatis.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.mybatis.dataSource
 * User         : zj
 * Date         : 17/4/20
 * Time         : 下午4:17
 * Description  :
 */


public class DruidSettingUtil {

    private DruidSettingUtil(){}

    //配置数据源的其他参数
    public static DataSource setupDataSource(DruidDataSource dataSource,DruidProperties properties){

        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setMaxWait(properties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setConnectionProperties(properties.getConnectionProperties());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        try {
            //dataSource.init();
            dataSource.setFilters(properties.getFilters());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

}
