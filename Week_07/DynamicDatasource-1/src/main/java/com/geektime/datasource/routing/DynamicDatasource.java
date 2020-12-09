package com.geektime.datasource.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @author YangMin
 * @date 2020/12/6 20:44
 */
public class DynamicDatasource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDatasourceThreadLocal.getDataSource();
    }

}
