package org.flowable.ui.admin.rest;

import com.markix.flowable.swagger.Constants;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.ui.admin.conf.DispatcherServletConfiguration
 * @see org.flowable.ui.admin.conf.ApplicationConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.UiProperty.ADMIN_APP, havingValue = Constants.ENABLED)
public class AdminAppSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {


    @Override
    public FlowableServlet getServlet() {
        return Constants.ADMIN_APP;
    }

}