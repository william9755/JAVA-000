package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author YangMin
 * @time 2020-11-03 20:53
 */
public class HttpRequestHeaderFilter implements HttpRequestFilter {

    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().add("nio","YangMin");
    }

}
