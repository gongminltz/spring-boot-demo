分布式事务解决方案

1 multiple-data-source-test模块演示了一个服务内多数据源如何使用seata进行分布式事务管理

2 seata-provider和seata-client两个模块演示了微服务模式下如何使用seata进行分布式事务管理
2.1 需要启动一个eureka作为注册中心
2.2 需要启动一个seata-server作为TC
2.3 