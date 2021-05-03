package io.github.markixy.flowable.ui.boot;

import io.github.markixy.flowable.boot.FlowableSwaggerAutoConfiguration;
import io.github.markixy.flowable.ui.FlowableUiSwagger2Configuration;
import io.github.markixy.flowable.ui.FlowableUiSwaggerProperties;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author markix
 */
@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(RestApiAutoConfiguration.class)
@AutoConfigureBefore(FlowableSwaggerAutoConfiguration.class)
@Import(FlowableUiSwagger2Configuration.class)
@EnableConfigurationProperties(FlowableUiSwaggerProperties.class)
public class FlowableUiSwaggerAutoConfiguration {


}