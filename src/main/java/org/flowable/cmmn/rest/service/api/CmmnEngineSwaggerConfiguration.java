package org.flowable.cmmn.rest.service.api;

import com.markix.flowable.swagger.Constants;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.cmmn.CmmnEngineRestConfiguration;
import org.flowable.spring.boot.cmmn.FlowableCmmnProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see CmmnEngineRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.Property.CMMN, havingValue = Constants.ENABLED)
public class CmmnEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableCmmnProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}