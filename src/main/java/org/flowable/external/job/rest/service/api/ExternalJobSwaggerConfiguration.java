package org.flowable.external.job.rest.service.api;

import com.markix.flowable.swagger.Constants;
import com.markix.flowable.swagger.condition.ExternalJobSwaggerCondition;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.job.ExternalJobRestConfiguration;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see ExternalJobRestConfiguration
 * @see RestApiAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@Conditional(ExternalJobSwaggerCondition.class)
public class ExternalJobSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {


    @Override
    public FlowableServlet getServlet() {
        return Constants.EXTERNAL_JOB;
    }

}