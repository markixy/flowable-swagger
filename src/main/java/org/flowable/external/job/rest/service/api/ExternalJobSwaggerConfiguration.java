package org.flowable.external.job.rest.service.api;

import io.github.markixy.flowable.Constants;
import io.github.markixy.flowable.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.spring.boot.job.ExternalJobRestConfiguration
 * @see org.flowable.spring.boot.RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.Property.EXTERNAL_JOB, havingValue = Constants.ENABLED)
public class ExternalJobSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {


    @Override
    public FlowableServlet getServlet() {
        return Constants.EXTERNAL_JOB;
    }

}