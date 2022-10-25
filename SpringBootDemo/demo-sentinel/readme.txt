1 如何使用sentinel限流
2 如何进行限流异常消息自定义

3 如何使用nacos对流量控制参数进行持久化
3.1 在application配置文件中通过如下配置将参数同步到sentinel dashboard
spring.cloud.sentinel.transport.dashboard = http://localhost:8080
spring.cloud.sentinel.eager = true

3.2 在application配置文件中通过如下配置将限流参数持久化到nacos
spring.cloud.sentinel.datasource.ds.nacos.server-addr= localhost:8848
spring.cloud.sentinel.datasource.ds.nacos.data_id= sentinel-service.json
spring.cloud.sentinel.datasource.ds.nacos.group-id= DEFAULT_GROUP
spring.cloud.sentinel.datasource.ds.nacos.data-type= json
spring.cloud.sentinel.datasource.ds.nacos.rule-type= system

当rule-type为system时表示是系统规则（可以认为对服务限流），为flow表示是流控规则（可以认为对接口限流）

3.3 nacos配置文件中的内容
[
{
    "maxThread": 2
}
]

更多规则可以参考 https://blog.csdn.net/Q54665642ljf/article/details/126087297
