package org.flowable.rest.service.api;

import com.markix.flowable.swagger.condition.ProcessEngineSwaggerCondition;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.process.FlowableProcessProperties;
import org.flowable.spring.boot.process.ProcessEngineRestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see ProcessEngineRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Conditional(ProcessEngineSwaggerCondition.class)
public class ProcessEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableProcessProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}