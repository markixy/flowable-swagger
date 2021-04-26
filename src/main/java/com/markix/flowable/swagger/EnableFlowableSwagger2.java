package com.markix.flowable.swagger;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author markix
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(FlowableSwagger2Configuration.class)
@EnableConfigurationProperties(FlowableSwaggerProperties.class)
public @interface EnableFlowableSwagger2 {
}
