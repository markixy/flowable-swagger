package org.flowable.ui.idm.rest.api;

import com.markix.flowable.swagger.Constants;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.ui.idm.servlet.ApiDispatcherServletConfiguration
 * @see org.flowable.ui.idm.conf.ApplicationConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.UiProperty.IDM_APP, havingValue = Constants.ENABLED)
public class IdmApiSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {


    @Override
    public FlowableServlet getServlet() {
        return Constants.IDM_APP;
    }

}