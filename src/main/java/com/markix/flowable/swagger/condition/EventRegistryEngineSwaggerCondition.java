package com.markix.flowable.swagger.condition;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;

/**
 * @author markix
 */
public class EventRegistryEngineSwaggerCondition extends AllNestedConditions {

    public EventRegistryEngineSwaggerCondition() {
        super(ConfigurationPhase.PARSE_CONFIGURATION);
    }

    @Conditional(FlowableSwaggerCondition.class)
    static class Enabled {
    }

    @ConditionalOnProperty(prefix = "flowable.swagger.event-registry", name = "enabled", havingValue = "true", matchIfMissing = true)
    static class EngineEnabled {
    }

}