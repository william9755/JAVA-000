package io.github.kimmking.gateway.compoment;

import java.util.List;
import java.util.Map;

/**
 * @author YangMin
 * @time 2020-11-03 20:02
 */
public class ServerConfig {

    private String proxystrategy;
    private Map<String,Object> server;
    private List<Map> proxyservers;
    private List<String> filters;
    private List<ServerNode> proxyServerNodes;

    public String getProxystrategy() {
        return proxystrategy;
    }

    public void setProxystrategy(String proxystrategy) {
        this.proxystrategy = proxystrategy;
    }

    public Map<String, Object> getServer() {
        return server;
    }

    public void setServer(Map<String, Object> server) {
        this.server = server;
    }

    public List<Map> getProxyservers() {
        return proxyservers;
    }

    public void setProxyservers(List<Map> proxyservers) {
        this.proxyservers = proxyservers;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public List<ServerNode> getProxyServerNodes() {
        return proxyServerNodes;
    }

    public void setProxyServerNodes(List<ServerNode> proxyServerNodes) {
        this.proxyServerNodes = proxyServerNodes;
    }

}
