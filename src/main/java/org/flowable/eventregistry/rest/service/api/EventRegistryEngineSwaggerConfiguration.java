package org.flowable.eventregistry.rest.service.api;

import com.markix.flowable.swagger.condition.EventRegistryEngineSwaggerCondition;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.eventregistry.EventRegistryRestConfiguration;
import org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see EventRegistryRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Conditional(EventRegistryEngineSwaggerCondition.class)
public class EventRegistryEngineSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableEventRegistryProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}