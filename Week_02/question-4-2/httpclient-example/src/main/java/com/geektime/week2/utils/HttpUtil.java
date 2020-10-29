package com.geektime.week2.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author YangMin
 * @time 2020-10-28 16:22
 */
public class HttpUtil {

    public static String get(String url) throws URISyntaxException, IOException {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient = HttpClients.createDefault();
            URI uri = buildUri(url);
            HttpGet httpGet = new HttpGet(uri);
            response = httpclient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        } finally {
            if(response != null) {
                response.close();
            }
            if(httpclient != null) {
                httpclient.close();
            }
        }
    }

    public static String post(String url) throws IOException, URISyntaxException {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient = HttpClients.createDefault();
            URI uri = buildUri(url);
            HttpPost httpPost = new HttpPost(uri);
            response = httpclient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } finally {
            if(response != null) {
                response.close();
            }
            if(httpclient != null) {
                httpclient.close();
            }
        }
    }

    private static URI buildUri(String url) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setPath(url);
        URI uri = uriBuilder.build();
        return uri;
    }

    private static URI buildUri(String url,List<NameValuePair> params) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setPath(url);
        uriBuilder.setParameters(params);
        URI uri = uriBuilder.build();
        return uri;
    }

}

