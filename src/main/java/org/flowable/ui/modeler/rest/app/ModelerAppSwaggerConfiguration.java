package org.flowable.ui.modeler.rest.app;

import com.markix.flowable.swagger.Constants;
import com.markix.flowable.swagger.swagger2.AbstractEngineSwaggerConfiguration;
import org.flowable.spring.boot.FlowableServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 * @see org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration
 * @see org.flowable.ui.modeler.conf.ApplicationConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.UiProperty.MODELER_APP, havingValue = Constants.ENABLED)
public class ModelerAppSwaggerConfiguration extends AbstractEngineSwaggerConfiguration {


    @Override
    public FlowableServlet getServlet() {
        return Constants.MODELER_APP;
    }

}