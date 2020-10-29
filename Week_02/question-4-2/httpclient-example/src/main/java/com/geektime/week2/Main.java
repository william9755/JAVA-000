package com.geektime.week2;

import com.geektime.week2.utils.HttpUtil;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author YangMin
 * @time 2020-10-28 16:12
 */
public class Main {

    public static void main(String[] args) {
        try {
            String url = "http://127.0.0.1:8801";
            System.out.println(HttpUtil.get(url));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(URISyntaxException ue) {
            ue.printStackTrace();
        }
    }
}
