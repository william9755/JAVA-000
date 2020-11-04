package io.github.kimmking.gateway;


import io.github.kimmking.gateway.compoment.ServerConfig;
import io.github.kimmking.gateway.compoment.ServerNode;
import io.github.kimmking.gateway.inbound.HttpInboundServer;
import org.ho.yaml.Yaml;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NettyServerApplication {
    
    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "1.0.0";
    public static ServerConfig serverConfig;
    
    public static void main(String[] args) {
        try {
            initServerConfig();
            HttpInboundServer server = new HttpInboundServer(Integer.valueOf(serverConfig.getServer().get("port").toString()));
            server.run();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void initServerConfig() throws FileNotFoundException {
        serverConfig = Yaml.loadType(NettyServerApplication.class.getResourceAsStream("/server-config.yml"),
                ServerConfig.class);
        List<Map> servers = serverConfig.getProxyservers();
        List<ServerNode> serverNodes = new ArrayList(servers.size());
        ServerNode serverNode = null;
        for(Map server : servers) {
            serverNode = new ServerNode(server.get("address").toString());
            serverNode.setWeight(Integer.valueOf(server.getOrDefault("weight","0").toString()));
            serverNodes.add(serverNode);
        }
        serverConfig.setProxyServerNodes(serverNodes);
    }

}
