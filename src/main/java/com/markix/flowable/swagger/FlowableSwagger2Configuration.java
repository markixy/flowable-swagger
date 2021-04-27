package com.markix.flowable.swagger;

import com.markix.flowable.swagger.swagger2.FlowableSwaggerResourcesProvider;
import org.flowable.spring.boot.rest.BaseRestApiConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * @author markix
 */
@Order(value = Ordered.LOWEST_PRECEDENCE)
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
@ConditionalOnBean({
        BaseRestApiConfiguration.class,
        Swagger2DocumentationConfiguration.class
})
@ConditionalOnProperty(prefix = "flowable.swagger", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FlowableSwagger2Configuration {

    @Primary
    @Bean
    public SwaggerResourcesProvider delegateSwaggerResourcesProvider(Environment environment, DocumentationCache documentationCache, FlowableSwaggerProperties properties) {
        return new FlowableSwaggerResourcesProvider(environment, documentationCache, properties);
    }

}