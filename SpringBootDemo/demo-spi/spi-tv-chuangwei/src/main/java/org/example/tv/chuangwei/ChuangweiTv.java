package org.example.tv.chuangwei;

import org.example.tv.api.ITv;

/**
 * 创维电视
 *
 * @author gongmin
 * @date 2023/2/22 15:01
 */
public class ChuangweiTv implements ITv {
    @Override
    public void turnOn() {
        System.out.println("欢迎使用创维电视");
    }

    @Override
    public void turnOff() {
        System.out.println("欢迎下次再次使用创维电视");
    }

    @Override
    public String getBrand() {
        return "chuangwei";
    }
}
