package io.github.kimmking.gateway.compoment;

/**
 * @author YangMin
 * @time 2020-11-03 20:04
 */
public class ServerNode {

    private int weight;
    private String address;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.endsWith("/")?address.substring(0,address.length()-1):address;
    }

    public ServerNode(String address) {
        this.address = address;
    }

    public ServerNode(String address,int weight) {
        this.address = address.endsWith("/")?address.substring(0,address.length()-1):address;
        this.weight = weight;
    }

}
