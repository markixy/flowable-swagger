package com.markix.flowable.swagger.swagger2;

import org.flowable.spring.boot.FlowableServlet;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Flowable Engine 集成 Swagger2 基础配置
 *
 * @author markix
 */
@EnableSwagger2
public abstract class AbstractEngineSwaggerConfiguration {

    @Bean
    public Docket docket() {
        return docket(getServlet());
    }

    private Docket docket(FlowableServlet servlet) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title(servlet.getName()).build())
                .select()
                .build();
    }

    /**
     * 获取 Engine 的 Servlet
     *
     * @return FlowableServlet
     */
    public abstract FlowableServlet getServlet();


}
