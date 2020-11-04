package io.github.kimmking.gateway.router;

import io.github.kimmking.gateway.NettyServerApplication;
import io.github.kimmking.gateway.compoment.ServerNode;

import java.util.List;

/**
 * @author YangMin
 * @time 2020-11-03 20:31
 */
public class RandomRouter implements HttpEndpointRouter {

    private List<ServerNode> servers;

    public RandomRouter(List<ServerNode> servers) {
        this.servers = servers;
    }

    public String route() {
        if(servers == null || servers.size() <= 0) {
            return "";
        }

        long randomNum = System.currentTimeMillis();
        Long index = randomNum % servers.size();
        return servers.get(index.intValue()).getAddress();
    }

}
