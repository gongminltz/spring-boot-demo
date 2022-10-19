package org.example.aop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 日志信息
 *
 * @author gongmin
 * @date 2022/10/19 9:38
 */
@Getter
@Setter
@NoArgsConstructor
public class LogInfo {
    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    private long startTime;

    /**
     * 消耗时间
     */
    private long spendTime;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private Object parameter;

    /**
     * 请求返回的结果
     */
    private Object result;

    /**
     * 城市
     */
    private String city;

    /**
     * 请求设备信息
     */
    private String device;
}
