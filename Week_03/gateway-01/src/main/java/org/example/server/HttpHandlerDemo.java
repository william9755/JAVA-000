package org.example.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.client.HttpClientUtil;
import org.example.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;

/**
 * @author YangMin
 * @time 2020-11-02 22:59
 */
public class HttpHandlerDemo implements HttpHandler {

    private Logger logger = LoggerFactory.getLogger(HttpHandlerDemo.class);

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Headers responseHeaders = httpExchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "text/html;charset=utf-8");
        String requestMethod = httpExchange.getRequestMethod();
        String url = httpExchange.getRequestURI().toString();
        String fullUrl = Config.SERVER_ADDR + url;
        logger.info("访问：" + url + "，实际访问：" + fullUrl);
        String response = null;
        try {
            if (requestMethod.equalsIgnoreCase("GET")) {
                response = HttpClientUtil.get(fullUrl);
            } else if (requestMethod.equalsIgnoreCase("POST")){
                response = HttpClientUtil.post(fullUrl);
            }
        } catch (URISyntaxException e) {
            response = "访问出错！";
            logger.error("访问出错！实际访问 url : " + fullUrl);
            e.printStackTrace();
        } catch (IOException e) {
            response = "访问出错！";
            logger.error("访问出错！实际访问 url : " + fullUrl);
            e.printStackTrace();
        }

        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes("UTF-8").length);
        OutputStream responseBody = httpExchange.getResponseBody();
        OutputStreamWriter writer = new OutputStreamWriter(responseBody, "UTF-8");
        writer.write(response);
        writer.close();
        responseBody.close();
    }
}
