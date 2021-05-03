package org.flowable.idm.rest.service.api;

import io.github.markixy.flowable.Constants;
import io.github.markixy.flowable.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.idm.FlowableIdmProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.spring.boot.idm.IdmEngineRestConfiguration
 * @see org.flowable.spring.boot.RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.Property.IDM, havingValue = Constants.ENABLED)
public class IdmEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableIdmProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}