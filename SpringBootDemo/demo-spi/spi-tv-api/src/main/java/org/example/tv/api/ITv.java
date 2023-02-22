package org.example.tv.api;

/**
 * 电视接口
 *
 * @author gongmin
 * @date 2023/2/22 14:49
 */
public interface ITv {
    /**
     * 打开电视
     */
    void turnOn();

    /**
     * 关闭电视
     */
    void turnOff();

    /**
     * 获取电视机品牌
     *
     * @return 电视机品牌
     */
    String getBrand();
}
