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
@MapperScan(basePackages = {"org.example.multiple.data.source.mapper.gm2"}, sqlSessionFactoryRef = "gm2SqlSessionFactory")
public class Gm2DataSourceConfig {
    @Bean(name = "gm2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.gm2")
    public DataSource gm2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "gm2SqlSessionFactory")
    @Primary
    public SqlSessionFactory gm2SqlSessionFactory(@Qualifier("gm2DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/gm2/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "gm2TransactionManager")
    @Primary
    public DataSourceTransactionManager gm2TransactionManager(@Qualifier("gm2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "gm2SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate gm2SqlSessionTemplate(
            @Qualifier("gm2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
