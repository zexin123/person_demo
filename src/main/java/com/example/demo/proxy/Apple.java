package com.example.demo.proxy;

/**
 * @author xuzexin
 * @Description:
 * @date 2020/3/30 0030 下午 14:13
 */
public class Apple implements Fruit {
    @Override
    public void show() {
        System.out.println("<<<<show method is invoked");
    }
}
