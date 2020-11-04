package org.example;

import org.example.server.HttpServerDemo;

import java.io.IOException;

/**
 * @author YangMin
 * @time 2020-11-02 13:49
 */
public class GatewayDemo {

    public static void main(String[] args) {
        HttpServerDemo server = new HttpServerDemo();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
