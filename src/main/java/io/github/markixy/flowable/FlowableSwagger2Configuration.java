package io.github.markixy.flowable;

import io.github.markixy.flowable.swagger2.FlowableSwaggerResourcesProvider;
import org.flowable.spring.boot.rest.BaseRestApiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author markix
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "flowable.swagger", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FlowableSwagger2Configuration {

    /**
     * 主应用上下文开启了Swagger，且存在flowable rest模块
     */
    @ConditionalOnBean({
            Swagger2DocumentationConfiguration.class,
            BaseRestApiConfiguration.class
    })
    @Primary
    @Bean
    public SwaggerResourcesProvider delegateSwaggerResourcesProvider(Environment environment, DocumentationCache documentationCache) {
        return new FlowableSwaggerResourcesProvider(environment, documentationCache);
    }

    @Autowired
    private Environment environment;
    @Autowired
    private FlowableSwaggerProperties swaggerProperties;

    @PostConstruct
    private void addFlowableEngineSwaggerSwitchProperties(){
        if(!swaggerProperties.isEnabled()){
            return;
        }
        //添加属性，flowable各个模块根据属性值判断是否开启Swagger
        Properties properties = new Properties();
        properties.put(Constants.Property.PROCESS, swaggerProperties.getProcess().isEnabled());
        properties.put(Constants.Property.APP, swaggerProperties.getApp().isEnabled());
        properties.put(Constants.Property.CMMN, swaggerProperties.getCmmn().isEnabled());
        properties.put(Constants.Property.CONTENT, swaggerProperties.getContent().isEnabled());
        properties.put(Constants.Property.DMN, swaggerProperties.getDmn().isEnabled());
        properties.put(Constants.Property.FORM, swaggerProperties.getForm().isEnabled());
        properties.put(Constants.Property.IDM, swaggerProperties.getIdm().isEnabled());
        properties.put(Constants.Property.EVENT_REGISTRY, swaggerProperties.getEventRegistry().isEnabled());
        properties.put(Constants.Property.EXTERNAL_JOB, swaggerProperties.getExternalJob().isEnabled());
        ((ConfigurableEnvironment) environment).getPropertySources().addLast(new PropertiesPropertySource(Constants.Property.NAME, properties));
    }

}