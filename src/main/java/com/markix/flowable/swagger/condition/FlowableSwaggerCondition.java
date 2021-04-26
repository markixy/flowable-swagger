package com.markix.flowable.swagger.condition;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;

/**
 * @author markix
 */
public class FlowableSwaggerCondition extends AllNestedConditions {

    public FlowableSwaggerCondition() {
        super(ConfigurationPhase.PARSE_CONFIGURATION);
    }

    /**
     * Whether the Swagger are enabled on root web context.
     */
    @ConditionalOnBean(DocumentationPluginsBootstrapper.class)
    static class OuterAppSwaggerEnabled {
    }

    @ConditionalOnProperty(prefix = "flowable.swagger", name = "enabled", havingValue = "true", matchIfMissing = true)
    static class Enabled {
    }

}
