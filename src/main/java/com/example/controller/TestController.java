package com.example.controller;/**
 * Created by Administrator on 2016/12/28.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/12/28
 */
@RestController
public class TestController {

    public static InetAddress getInetAddress() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("unknown host!");
        }
        return null;
    }

    public static String getHostIp(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String ip = netAddress.getHostAddress(); //get the ip address
        return ip;
    }

    public static String getHostName(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String name = netAddress.getHostName(); //get the host address
        return name;
    }

    public TestController() {
        InetAddress netAddress = getInetAddress();
        System.out.println("host ip:" + getHostIp(netAddress));
        System.out.println("host name:" + getHostName(netAddress));
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("-------");
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @RequestMapping("/test")
    public java.util.Map get() {
        java.util.Map map = new HashMap<>();
        map.put("aa", "bb");
        return map;
    }

}
