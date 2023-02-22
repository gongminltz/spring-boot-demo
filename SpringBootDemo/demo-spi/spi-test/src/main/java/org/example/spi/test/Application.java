package org.example.spi.test;

import org.example.tv.api.ITv;

import java.util.ServiceLoader;

/**
 * 启动类
 *
 * @author gongmin
 * @date 2023/2/22 15:08
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("main start");

        ITv tcl = getTv("tcl");
        if (tcl == null) {
            System.out.println("没有找到品牌为tcl的电视机");
            return;
        }

        tcl.turnOn();
    }

    /**
     * 根据品牌型号获取电视机
     *
     * @param brand 品牌
     * @return 返回电视机
     */
    public static ITv getTv(String brand) {
        ServiceLoader<ITv> load = ServiceLoader.load(ITv.class);

        for (ITv tv : load) {
            System.out.println("检测到:" + tv.getBrand());

            if (brand.equals(tv.getBrand())) {
                return tv;
            }
        }

        return null;
    }
}
