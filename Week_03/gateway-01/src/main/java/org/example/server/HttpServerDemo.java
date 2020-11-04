package org.example.server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import org.example.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author YangMin
 * @time 2020-11-02 21:42
 */
public class HttpServerDemo {

    private Logger logger = LoggerFactory.getLogger(HttpServerDemo.class);

    public void start() throws IOException {
        HttpServerProvider provider = HttpServerProvider.provider();
        HttpServer httpServer =provider.createHttpServer(new InetSocketAddress(Config.PORT), 50);
        httpServer.createContext("/", new HttpHandlerDemo());
        httpServer.setExecutor(null);
        httpServer.start();
        logger.info("开启 http 服务器，监听地址为【127.0.0.1】，监听端口为【" + Config.PORT + "】，后端实际地址为【" + Config.SERVER_ADDR + "】");
    }

}
