package org.flowable.dmn.rest.service.api;

import io.github.markixy.flowable.Constants;
import io.github.markixy.flowable.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.dmn.FlowableDmnProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.spring.boot.dmn.DmnEngineRestConfiguration
 * @see org.flowable.spring.boot.RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.Property.DMN, havingValue = Constants.ENABLED)
public class DmnEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableDmnProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}