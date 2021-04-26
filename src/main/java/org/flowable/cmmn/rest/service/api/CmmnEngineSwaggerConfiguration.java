package org.flowable.cmmn.rest.service.api;

import com.markix.flowable.swagger.condition.CmmnEngineSwaggerCondition;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.cmmn.CmmnEngineRestConfiguration;
import org.flowable.spring.boot.cmmn.FlowableCmmnProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see CmmnEngineRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Conditional(CmmnEngineSwaggerCondition.class)
public class CmmnEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableCmmnProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}