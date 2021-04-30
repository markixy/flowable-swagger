package com.markix.flowable.swagger;

import com.markix.flowable.swagger.swagger2.FlowableSwaggerResourcesProvider;
import com.markix.flowable.swagger.ui.FlowableUiSwaggerProperties;
import org.flowable.spring.boot.rest.BaseRestApiConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

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
    public SwaggerResourcesProvider delegateSwaggerResourcesProvider(Environment environment, DocumentationCache documentationCache,
                                                                     FlowableSwaggerProperties properties, FlowableUiSwaggerProperties uiProps) {
        return new FlowableSwaggerResourcesProvider(environment, documentationCache, properties, uiProps);
    }

}