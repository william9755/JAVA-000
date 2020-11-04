package io.github.kimmking.gateway.router;

import io.github.kimmking.gateway.compoment.ServerNode;

import java.util.List;
import java.util.Random;

/**
 * @author YangMin
 * @time 2020-11-03 20:33
 */
public class WeightRouter implements HttpEndpointRouter {

    private List<ServerNode> servers;
    private boolean isRandom;
    private final static int TOTAL_WEIGHT = 100;

    public WeightRouter(List<ServerNode> servers) throws Exception {
        this.servers = servers;

        double totalWeight = 0d;
        for (ServerNode node : servers) {
            totalWeight += node.getWeight();
        }
        if (totalWeight != 100) {
            throw new Exception("权重总和必须为 100 ，请调整权重配置！");
        }

        // 如果所有权重相等，则使用随机的路由方式
        for (ServerNode node : servers) {
            if (node.getWeight() == servers.get(0).getWeight()) {
                this.isRandom = true;
            }
        }
    }

    public String route() {
        String address = "";
        try {
            address = getServerNode().getAddress();
        } catch (Exception e) {
            address = servers.get(0).getAddress();
        }
        return address;
    }

    private ServerNode getServerNode() {
        if (this.isRandom) {
            return servers.get(new Random().nextInt(servers.size()));
        }

        // 随机获取一个在总权重范围内的数，并用 randomNum 不断与节点权重相减
        // 当 randomNum < 0 时，则认为当前节点在概率范围内
        // 在这种情况下，权重越大，越容易被选中
        int randomNum = new Random().nextInt(TOTAL_WEIGHT);
        int targetIndex = 0;
        for(int i = 0;i < servers.size();i++) {
            randomNum = randomNum - servers.get(i).getWeight();
            if(randomNum < 0) {
                targetIndex = i;
                break;
            }
        }
        return servers.get(targetIndex);
    }

}
