package org.flowable.ui.task.rest;

import com.google.common.base.Predicates;
import com.markix.flowable.swagger.Constants;
import org.flowable.spring.boot.FlowableServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * TASK APP 比较特殊，其接口是直接注册到’主应用上下文‘的，并不是单独为一个’子应用上下文‘，所以只需要暴露相应的Docket bean就行了
 *
 * @author markix
 * @see org.flowable.ui.task.servlet.AppDispatcherServletConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = Constants.UiProperty.TASK_APP, havingValue = Constants.ENABLED, matchIfMissing = true)
public class TaskAppSwaggerConfiguration {

    @Bean
    public Docket taskAppDocket() {
        return docket(getServlet());
    }

    private Docket docket(FlowableServlet servlet) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title(servlet.getName()).build())
                .groupName(servlet.getName())
                .select()
                .apis(
                        Predicates.or(
                                RequestHandlerSelectors.basePackage("org.flowable.ui.task.rest"),
                                RequestHandlerSelectors.basePackage("org.flowable.ui.common.rest")
                        )
                )
                .build();
    }

    public FlowableServlet getServlet() {
        return Constants.TASK_APP;
    }

}