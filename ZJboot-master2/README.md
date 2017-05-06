# ZJboot-master

--------------------------------------------------------

> ## 概述
* 本项目为spring boot 项目.
* 集成Swagger2 API.(完成)
* 集成velocity模板引擎 （完成）
* 使用Druid数据源、监控管理（完成）
* 整合mybatis、分页插件 PageHelper、通用 Mapper（完成）
* 多数据源（完成）
* MyBatis Generator 插件 (完成)
* 通用CRUD案例、异常统一处理（完成）
* 集成 Redis（完成）
* 集成RabbitMQ （完成）
* 集成Spring session redis(完成)
* @Scheduled 定时任务 / 定时任务线程池(完成)
* @Async 异步调用(完成)
* 使用AOP，@Aspect统一处理Web请求日志 (完成)
* 集成spring-boot-starter-mail发送邮件 (完成)
* 配置httpClient连接池 （完成）
* ThreadPool 线程池 （完成）
* 集成Dubbo （计划内）
* baseDao 优化 (计划内)
* ResultDataDto 优化 (计划内)
* JTA，Atomikos 分布式事务例子 （计划内）



> ## 运行环境
> 1.   JDK1.8
> 2.   redis
> 3.   rabbitmq
> 4.   zookeeper （目前不需要）

> ## 部署测试
> 1.   建立两个测试的数据库，名字分别为'ZJboot_primary_db'和'ZJboot_auxiliary_db',对应导入primary.sql和auxiliary.sql.
> 2.   更改properties的配置，贴合你本地环境

> ## 补充
> 1.   项目中配置的是多数据源。如果要实现动态数据源的，可以看下
AbstractRoutingDataSource这个接口，不过要注意动态数据源的事物问题。

 
## 作者信息
- 作者邮箱：746753491@qq.com
  
 
