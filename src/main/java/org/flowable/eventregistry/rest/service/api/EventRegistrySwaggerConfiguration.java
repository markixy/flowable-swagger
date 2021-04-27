package org.flowable.eventregistry.rest.service.api;

import com.markix.flowable.swagger.Constants;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.eventregistry.EventRegistryRestConfiguration;
import org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see EventRegistryRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.Property.EVENT_REGISTRY, havingValue = Constants.ENABLED)
public class EventRegistrySwaggerConfiguration extends AbstractEngineSwaggerConfiguration {

    @Autowired
    private FlowableEventRegistryProperties properties;

    @Override
    public FlowableServlet getServlet() {
        return properties.getServlet();
    }

}