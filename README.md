# 简介
该项目实现了 Flowable 整合 Swagger 的自动化配置。

# 实现思路
- 基本情况
我们启动的应用为'主应用上下文'；Flowable每个Rest模块都是一个独立的'子应用上下文'。
Swagger只能获取到'当前应用上下文'的接口信息，也就是说在'主应用上下文'启用的Swagger（@EnableSwagger2）无法获取到'子应用上下文'的接口信息。

- 实现
在各个'子应用上下文'的扫描路径中添加配置类，启用Swagger；
覆盖'主应用上下文'中的Swagger资源提供者（SwaggerResourcesProvider），聚合'子应用上下文'中的Swagger资源。

## 基础依赖
- Swagger：2.9.2

# 配置
```yaml
flowable:
  swagger:
    enabled: true #是否启用 Flowable 的 Swagger
    # 细粒度控制各模块的Swagger启用状态
    process.enabled: true #是否启用 Process 模块的 Swagger
    idm.enabled: true #是否启用 IDM 模块的 Swagger
    cmmn.enabled: true #是否启用 CMMN 模块的 Swagger
    content.enabled: true #是否启用 Content 模块的 Swagger
    event-registry.enabled: true #是否启用 EventRegistry 模块的 Swagger
    app.enabled: true #是否启用 App 模块的Swagger
    form.enabled: true #是否启用 Form 模块的Swagger
    dmn.enabled: true #是否启用 DMN 模块的Swagger
```

# 使用
- 在`pom.xml`中引入依赖：
```xml
<dependency>
    <groupId>io.github.markixy</groupId>
    <artifactId>flowable-swagger</artifactId>
    <version>1.0.0</version>
</dependency>
```
