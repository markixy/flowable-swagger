package com.markix.flowable.swagger.ui;

import com.markix.flowable.swagger.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author markix
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "flowable-ui.swagger", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FlowableUiSwagger2Configuration {

    @Autowired
    private Environment environment;
    @Autowired
    private FlowableUiSwaggerProperties uiSwaggerProperties;

    @PostConstruct
    private void addFlowableUiAppSwaggerSwitchProperties() {
        if(!uiSwaggerProperties.isEnabled()){
            return;
        }
        //添加属性，flowable ui各个模块根据属性值判断是否开启Swagger
        Properties properties = new Properties();
        properties.put(Constants.UiProperty.ADMIN_APP, uiSwaggerProperties.getAdmin().isEnabled());
        properties.put(Constants.UiProperty.IDM_APP, uiSwaggerProperties.getIdm().isEnabled());
        properties.put(Constants.UiProperty.IDM_APP_API, uiSwaggerProperties.getIdmApi().isEnabled());
        properties.put(Constants.UiProperty.MODELER_APP, uiSwaggerProperties.getModeler().isEnabled());
        properties.put(Constants.UiProperty.MODELER_APP_API, uiSwaggerProperties.getModelerApi().isEnabled());
        ((ConfigurableEnvironment) environment).getPropertySources().addLast(new PropertiesPropertySource(Constants.UiProperty.NAME, properties));
    }


}