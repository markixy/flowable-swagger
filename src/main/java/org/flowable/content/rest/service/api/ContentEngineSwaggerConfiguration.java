package org.flowable.content.rest.service.api;

import io.github.markixy.flowable.Constants;
import io.github.markixy.flowable.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.content.FlowableContentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.spring.boot.content.ContentEngineRestConfiguration
 * @see org.flowable.spring.boot.RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.Property.CONTENT, havingValue = Constants.ENABLED)
public class ContentEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableContentProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}