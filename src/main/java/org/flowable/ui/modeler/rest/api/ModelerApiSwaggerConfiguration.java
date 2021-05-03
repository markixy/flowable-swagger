package org.flowable.ui.modeler.rest.api;

import io.github.markixy.flowable.Constants;
import io.github.markixy.flowable.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.ui.modeler.servlet.ApiDispatcherServletConfiguration
 * @see org.flowable.ui.modeler.conf.ApplicationConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.UiProperty.MODELER_APP_API, havingValue = Constants.ENABLED)
public class ModelerApiSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {


    @Override
    public FlowableServlet getServlet() {
        return Constants.MODELER_APP_API;
    }

}