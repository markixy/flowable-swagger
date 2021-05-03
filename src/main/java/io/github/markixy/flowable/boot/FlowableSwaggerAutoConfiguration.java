package io.github.markixy.flowable.boot;

import io.github.markixy.flowable.FlowableSwagger2Configuration;
import io.github.markixy.flowable.FlowableSwaggerProperties;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
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
@Import(FlowableSwagger2Configuration.class)
@EnableConfigurationProperties(FlowableSwaggerProperties.class)
public class FlowableSwaggerAutoConfiguration {


}