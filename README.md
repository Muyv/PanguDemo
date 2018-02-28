# Pangu 框架使用示例项目

## 使用说明
 - 每个目录都是可以运行的工程，可以下载到本地通过 IDE 或 Maven 编译后运行。
 - 每个例子除了代码还有关键的配置代码都在 Disconf 中，请登录 10.10.110.50 阅读 DEMO.PANGU 应用下的对应配置文件。
 - 每个例子都用了 Web 方式启动，并开启了 Swagger，可以启动后通过访问 http://localhost:*8080*/swagger-ui.html (**注意**，为保证启动成功，Web 端口号是从8080 开始递增取可用端口)测试各个例子的运行效果。

## 目录

 - [idgen](idgen): ID 生成器例子
 - [shardingjdbc](shardingjdbc): ShardingJDBC 分表分库例子
 - [fastdfs](fastdfs): FastDFS 分布式文件系统使用例子
 - [redis](redis): Redis 简单使用例子
 - [rabbitmq](rabbitmq): RabbitMQ 使用例子
 - [sms](sms): 短信发送例子
 - [elasticjob](elasticjob): ElasticJob 分布式任务调度例子
 - [restful](restful): RESTful 接口开发样例
 - [webfilter](webfilter): Filter 写法示例
 - [webinterceptor](webinterceptor): Interceptor 写法示例
 - [dubbo](dubbo): Dubbo 用法示例
 - [mybatis](mybatis): MyBatis 用法示例，含多数据源、读写分离示例
