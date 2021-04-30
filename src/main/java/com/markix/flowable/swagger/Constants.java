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


    /**
     * UI APP
     */
    FlowableServlet ADMIN_APP = new FlowableServlet("/admin-app", "Flowable Admin App");
    FlowableServlet IDM_APP = new FlowableServlet("/idm-app", "Flowable IDM App Servlet");
    FlowableServlet IDM_APP_API = new FlowableServlet("/api/idm", "Flowable IDM App API Servlet");
    FlowableServlet MODELER_APP = new FlowableServlet("/modeler-app", "Flowable Modeler App Servlet");
    FlowableServlet MODELER_APP_API = new FlowableServlet("/api/editor", "Flowable Modeler App API Servlet");
    FlowableServlet TASK_APP = new FlowableServlet("/", "flowable Task App Servlet");

    interface UiProperty {
        String NAME = "flowableUiModuleSwaggerSwitchProperties";

        String ADMIN_APP = "flowable-ui.swagger.admin.enabled";
        String IDM_APP = "flowable-ui.swagger.idm.enabled";
        String IDM_APP_API = "flowable-ui.swagger.idm-api.enabled";
        String MODELER_APP = "flowable-ui.swagger.modeler.enabled";
        String MODELER_APP_API = "flowable-ui.swagger.modeler-api.enabled";
        String TASK_APP = "flowable-ui.swagger.task.enabled";
    }

}
