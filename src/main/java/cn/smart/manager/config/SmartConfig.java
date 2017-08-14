package cn.smart.manager.config;

import cn.smart.manager.dataSource.SmartDataSourceConfig;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/8/1.
 */
@Configuration
@MapperScan(basePackages = {"cn.smart.mapper"}, sqlSessionTemplateRef = "smartSqlSessionTemplate")
@Primary
public class SmartConfig {
    // 配置数据源
    @Primary
    @Bean(name = "smartSource")
    public DataSource smartDataSource(SmartDataSourceConfig dataSource) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dataSource.getUrl());
        mysqlXaDataSource.setUser(dataSource.getUsername());
        mysqlXaDataSource.setPassword(dataSource.getPassword());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("smartSource");
        return xaDataSource;
    }

    @Bean(name = "smartSqlSessionFactory")
    public SqlSessionFactory smartSqlSessionFactory(@Qualifier("smartSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:cn/smart/**/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "smartSqlSessionTemplate")
    public SqlSessionTemplate smartSqlSessionTemplate(
            @Qualifier("smartSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}