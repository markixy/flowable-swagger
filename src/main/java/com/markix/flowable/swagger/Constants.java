package com.markix.flowable.swagger;

import org.flowable.spring.boot.FlowableServlet;

/**
 * @author markix
 */
public interface Constants {

    FlowableServlet EXTERNAL_JOB = new FlowableServlet("/external-job-api", "Flowable External Job Rest API");

    String ENABLED = "true";

    interface Property {
        String NAME = "flowableModuleSwaggerSwitchProperties";

        String PROCESS = "flowable.swagger.process.enabled";
        String APP = "flowable.swagger.app.enabled";
        String CMMN = "flowable.swagger.cmmn.enabled";
        String CONTENT = "flowable.swagger.content.enabled";
        String DMN = "flowable.swagger.dmn.enabled";
        String FORM = "flowable.swagger.form.enabled";
        String IDM = "flowable.swagger.idm.enabled";
        String EVENT_REGISTRY = "flowable.swagger.event-registry.enabled";
        String EXTERNAL_JOB = "flowable.swagger.external-job.enabled";
    }


}
