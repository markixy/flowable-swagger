package com.markix.flowable.swagger;

import com.markix.flowable.swagger.condition.FlowableSwaggerCondition;
import com.markix.flowable.swagger.swagger2.FlowableSwaggerResourcesProvider;
import org.flowable.spring.boot.rest.BaseRestApiConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author markix
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
@ConditionalOnBean(BaseRestApiConfiguration.class)
@Conditional(FlowableSwaggerCondition.class)
public class FlowableSwagger2Configuration {

    @Primary
    @Bean
    public SwaggerResourcesProvider flowableSwaggerResourcesProvider(Environment environment, DocumentationCache documentationCache) {
        return new FlowableSwaggerResourcesProvider(environment, documentationCache);
    }

}