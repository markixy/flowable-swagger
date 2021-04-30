package com.markix.flowable.swagger.ui;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author markix
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "flowable-ui.swagger", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FlowableUiSwagger2Configuration {


}