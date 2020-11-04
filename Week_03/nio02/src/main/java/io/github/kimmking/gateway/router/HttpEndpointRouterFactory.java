package io.github.kimmking.gateway.router;

import io.github.kimmking.gateway.NettyServerApplication;
import io.github.kimmking.gateway.compoment.ServerNode;

import java.util.List;

/**
 * @author YangMin
 * @time 2020-11-03 20:35
 */
public class HttpEndpointRouterFactory {

    private final static String RANDOM = "random";
    private final static String WEIGHT = "weight";

    public HttpEndpointRouter getRouter() throws Exception {
        String proxystrategy = NettyServerApplication.serverConfig.getProxystrategy();
        List<ServerNode> servers = NettyServerApplication.serverConfig.getProxyServerNodes();
        if(WEIGHT.equalsIgnoreCase(proxystrategy)) {
            return new WeightRouter(servers);
        } else {
            // 默认随机
            return new RandomRouter(servers);
        }
    }

}
