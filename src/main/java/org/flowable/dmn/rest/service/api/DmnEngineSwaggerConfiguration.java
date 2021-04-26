package org.flowable.dmn.rest.service.api;

import com.markix.flowable.swagger.condition.DmnEngineSwaggerCondition;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.dmn.DmnEngineRestConfiguration;
import org.flowable.spring.boot.process.FlowableProcessProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see DmnEngineRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Conditional(DmnEngineSwaggerCondition.class)
public class DmnEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableProcessProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}