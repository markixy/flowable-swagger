package org.flowable.form.rest.service.api;

import com.markix.flowable.swagger.condition.FormEngineSwaggerCondition;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.form.FlowableFormProperties;
import org.flowable.spring.boot.form.FormEngineRestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see FormEngineRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Conditional(FormEngineSwaggerCondition.class)
public class FormEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableFormProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}