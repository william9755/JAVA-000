package com.geektime.datasource.config;

import com.geektime.datasource.common.DataSourceName;
import com.geektime.datasource.routing.DynamicDatasource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YangMin
 * @date 2020/12/6 20:06
 */
@Configuration
public class DynamicDatasourceConfig {

    @Bean("ds1")
    @ConfigurationProperties(prefix = "dynamic.datasource.ds1")
    public DataSource ds1() {
        return DataSourceBuilder.create().build();
    }

    @Bean("ds2")
    @ConfigurationProperties(prefix = "dynamic.datasource.ds2")
    public DataSource ds2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DynamicDatasource buildDynamicDatasource() {
        Map<Object, Object> allDataSources = new HashMap<>();
        allDataSources.put(DataSourceName.DS1, ds1());
        allDataSources.put(DataSourceName.DS2, ds2());

        DynamicDatasource dynamicDatasource = new DynamicDatasource();
        dynamicDatasource.setDefaultTargetDataSource(ds1());
        dynamicDatasource.setTargetDataSources(allDataSources);
        return dynamicDatasource;
    }
}
