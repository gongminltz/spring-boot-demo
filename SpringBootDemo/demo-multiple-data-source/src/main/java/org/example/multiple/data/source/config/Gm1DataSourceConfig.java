package org.example.multiple.data.source.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * 数据源gm1配置
 *
 * @author gongmin
 * @date 2022/10/18 10:10
 */
@Configuration
@MapperScan(basePackages = {"org.example.multiple.data.source.mapper.gm1"}, sqlSessionFactoryRef = "gm1SqlSessionFactory")
public class Gm1DataSourceConfig {
    @Bean(name = "gm1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.gm1")
    @Primary
    public DataSource gm1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "gm1SqlSessionFactory")
    @Primary
    public SqlSessionFactory gm1SqlSessionFactory(@Qualifier("gm1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/gm1/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "gm1TransactionManager")
    @Primary
    public DataSourceTransactionManager gm1TransactionManager(@Qualifier("gm1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "gm1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate gm1SqlSessionTemplate(
            @Qualifier("gm1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
