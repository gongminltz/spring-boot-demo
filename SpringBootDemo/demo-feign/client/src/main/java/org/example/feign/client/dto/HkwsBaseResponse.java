package org.example.feign.client.dto;

import lombok.Data;

/**
 * 海康威视基础返回类
 *
 * @author gongmin
 * @date 2022/10/20 17:12
 */
@Data
public class HkwsBaseResponse {
    /**
     * 成功状态码
     */
    private static final String CODE_SUCCESS = "200";

    /**
     * 返回状态码
     * 200	操作成功	请求成功
     * 10001	参数错误	参数为空或格式不正确
     * 10005	appKey异常	appKey被冻结
     * 10017	appKey不存在	确认appKey是否正确
     * 10030	appkey和appSecret不匹配
     * 49999	数据异常	接口调用异常
     */
    private String code;

    /**
     * 消息描述
     */
    private String msg;

    public boolean isSucceed() {
        return CODE_SUCCESS.equals(code);
    }
}