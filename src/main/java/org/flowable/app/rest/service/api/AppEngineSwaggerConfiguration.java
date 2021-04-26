package org.flowable.app.rest.service.api;

import com.markix.flowable.swagger.condition.AppEngineSwaggerCondition;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.app.AppEngineRestConfiguration;
import org.flowable.spring.boot.app.FlowableAppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see AppEngineRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Conditional(AppEngineSwaggerCondition.class)
public class AppEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableAppProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}